package com.carlosescobar30.githubactivity;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventJsonManagement {

    /*private static String ReadTestJson (File file){
        StringBuilder testJson = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                testJson.append(line).append("\n");
            }
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        *//*System.out.println(testJson.toString().replace(" ","").replace("\n",""));*//*
        return testJson.toString().replace(" ","").replace("\n","");
    }*/

    private static Map.Entry<Integer, String> eventJsonCapture(String gitHubUser){
        StringBuilder eventJsonBody = new StringBuilder();
        int statusCode = 0;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + gitHubUser + "/events"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            statusCode = response.statusCode();
            eventJsonBody = new StringBuilder(response.body());

        } catch (Exception e) {
            e.getCause();
            System.out.println(e.getMessage());
        }
        return Map.entry(statusCode,eventJsonBody.toString().replace(" ","").replace("\n",""));
    }

    private static String apiRequestValidation (String gitHubUser){

        Map.Entry<Integer, String> apiResponse = eventJsonCapture(gitHubUser);

        if (apiResponse.getKey().equals(203)){
            throw new ApiRequestException ("No event records were found for this user");
        }

        if (apiResponse.getKey().equals(404)){
            throw new ApiRequestException("User not found");
        }

        if (apiResponse.getKey() >= 400 && apiResponse.getKey() < 500 && !apiResponse.getKey().equals(404) ){
            throw new ApiRequestException ("There was an error with the client");
        }

        return apiResponse.getValue();
    }

    public static List<String> eventJsonSplit (String gitHubUser){

        List<String> eventJsonList = new ArrayList<>();
        String eventPattern = "(\\{\"id\":\".*?\"created_at\":\".*?}),*?";
        Pattern pattern = Pattern.compile(eventPattern);
        Matcher matcher = pattern.matcher(apiRequestValidation(gitHubUser));
        int counter = 0;
        while (counter < 30 && matcher.find()) {
            String event = matcher.group(1);
            eventJsonList.add(event);
            counter++;
        }

        return eventJsonList;
    }

}


