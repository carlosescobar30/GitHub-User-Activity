package com.carlosescobar30.githubactivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventJsonManagement {

    private static String ReadTestJson (File file){
        StringBuilder testJson = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                testJson.append(line).append("\n");
            }
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        /*System.out.println(testJson.toString().replace(" ","").replace("\n",""));*/
        return testJson.toString().replace(" ","").replace("\n","");
    }

    private static String eventJsonCapture(){
        StringBuilder eventJsonBody = new StringBuilder();
        String gitHubUser = "torvalds";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + gitHubUser + "/events"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            eventJsonBody = new StringBuilder(response.body());

        } catch (Exception e) {
            e.getCause();
            System.out.println(e.getMessage());
        }
        return eventJsonBody.toString().replace(" ","").replace("\n","");
    }

    public static List<String> eventJsonSplit (File file){

        List<String> eventJsonList = new ArrayList<>();
        String eventPattern = "(\\{\"id\":\".*?\"created_at\":\".*?}),*?";
        Pattern pattern = Pattern.compile(eventPattern);
        Matcher matcher = pattern.matcher(ReadTestJson(file));
        int counter = 0;
        while (counter < 30 && matcher.find()) {
            String event = matcher.group(1);
            eventJsonList.add(event);
            counter++;
        }
        /*for (String eventJson : eventJsonList){
            System.out.println(eventJson);
        }*/

        return eventJsonList;
    }

}


