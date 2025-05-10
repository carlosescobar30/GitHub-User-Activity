package com.carlosescobar30.githubactivity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ManagementEventsJson {

    public static String captureEventsJson(String gitHubUser){
        String eventsJson = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + gitHubUser + "/events"))
                    .build();

            HttpResponse <String > response = client.send(request, HttpResponse.BodyHandlers.ofString());
            eventsJson = response.body();
            System.out.println(response.statusCode());

        } catch (Exception e) {
            e.getCause();
            System.out.println(e.getMessage());
        }
        return eventsJson;
    }

    public static List<String> splitEventsJson (String eventJson){

    }

}
