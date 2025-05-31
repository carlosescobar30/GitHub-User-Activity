package com.carlosescobar30.githubactivity;

import java.io.*;
import java.util.Set;

public class GHActivity {
    public static void main(String[] args) {
        File help = new File("com/carlosescobar30/githubactivity/help.txt");
        File events = new File("com/carlosescobar30/githubactivity/events.txt");
        OutputManagementInterface outputManager = new OutputManagement();
        String errorMessage = "Invalid request\nIf you need help, use the following flag: --help\nSolicitud no valida\nSi necesita ayuda use la siguiente flag: --help";
        int numberEvents = 30;
        Set<String> validEvents = ClassifyEvents.getEventSet();


        switch (args.length) {
            case 1:


                if (args[0].isBlank()) {
                    System.out.println(errorMessage);
                    return;
                }


                if (args[0].equals("--help")) {
                    OutputManagement.readFile(help);
                    return;
                }

                if (args[0].equals("--events")) {
                    OutputManagement.readFile(events);
                    return;
                }


                outputManager.eventOutput(args[0], "all", numberEvents);
                return;

            case 2:

                if (args[0].isBlank() || args[1].isBlank()){
                    System.out.println(errorMessage);
                }

                if (validEvents.contains(args[1]) || args[1].equals("all")) {
                    outputManager.eventOutput(args[0], args[1], numberEvents);
                    return;
                }
                try {
                    numberEvents = Integer.parseInt(args[1]);
                }catch (NumberFormatException n){
                    System.out.println(errorMessage);
                    return;
                }
                if (numberEvents < 1 || numberEvents > 30){
                    numberEvents = 30;
                }

                outputManager.eventOutput(args[0],"all",numberEvents);
                return;

            case 3:
                if (args[0].isBlank() || args[1].isBlank() || args[2].isBlank()){
                    System.out.println(errorMessage);
                    return;
                }

                if (!validEvents.contains(args[1]) && !args[1].equals("all")) {
                    System.out.println(args[1]);
                    for(String events123 : validEvents){
                        System.out.println(events123);
                    }
                    System.out.println(errorMessage);
                    return;
                }

                try {
                    numberEvents = Integer.parseInt(args[2]);
                }catch (NumberFormatException n){
                    System.out.println(errorMessage);
                    return;
                }

                if (numberEvents < 1 || numberEvents > 30){
                    numberEvents = 30;
                }

                outputManager.eventOutput(args[0],args[1],numberEvents);
                return;

            default:

                System.out.println(errorMessage);
        }

    }

}