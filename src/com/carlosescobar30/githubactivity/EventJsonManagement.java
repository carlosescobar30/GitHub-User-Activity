package com.carlosescobar30.githubactivity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventJsonManagement {

    private static StringBuilder eventJsonCapture(String gitHubUser){
        StringBuilder eventJsonBody = new StringBuilder();
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
        return eventJsonBody;
    }

    public static List<String> eventJsonSplit (String gitHubUser){
        List<String> eventJsonList = new ArrayList<>();
        String typePattern = "(\\{\"id\"\\s*:\\s*\".*?})\\s*,*?";
        Pattern pattern = Pattern.compile(typePattern);
        Matcher matcher = pattern.matcher(eventJsonCapture(gitHubUser));
        int counter = 0;
        while (counter < 30 && matcher.find()) {
            String event = matcher.group(1);
            eventJsonList.add(event);
            counter++;
        }

        for (String eventJson : eventJsonList){
            System.out.println(eventJson);
        }

        return eventJsonList;
    }

}


