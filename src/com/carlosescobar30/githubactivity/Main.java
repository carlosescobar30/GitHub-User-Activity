package com.carlosescobar30.githubactivity;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        int eventQuantity = 30;
        File file = new File("src/com/carlosescobar30/githubactivity/code.json");
        EventObjectManagement.eventJsonToObject(file);
    }
}