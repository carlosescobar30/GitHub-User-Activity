package com.carlosescobar30.githubactivity;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class EventOutput {



    public static void eventOutput (String gitHubUser, int eventsNumber, String typeEvent){
        List<GroupAllEvents> events = EventObjectManagement.eventJsonToObject(gitHubUser);
        int count = 0;

        if (!typeEvent.equals("all")){
            events = EventOutput.filterEvents(typeEvent,events);
        }

        if (events.isEmpty()){
            System.out.println("This user has no events to display");
            return;
        }

        System.out.println("The user: ");
        while (count < eventsNumber){

            GroupAllEvents event = events.get(count);

             switch (event){
                case GroupActionEvent aE ->{

                    EventOutput.showActionEvent((GroupActionEvent) event);
                    break;
                }

                case GroupSimpleEvent sE -> {
                    EventOutput.showSimpleEvent((GroupSimpleEvent) event);
                    break;
                }

                case GroupRefTypeEvent rTE -> {
                    EventOutput.showRefTypeEvent((GroupRefTypeEvent) event);
                    break;
                }

                case GroupPushEvent pE -> {
                    EventOutput.showPushEvent((GroupPushEvent) event);
                    break;
                }

                case GroupSponsorEvent sE -> {
                    EventOutput.showSponsorEvent((GroupSponsorEvent) event);
                    break;
                }
                default -> {
                    System.out.println("Fatal Error");
                    return;
                }
            }
            count++;
            if (events.size() == count){
                break;
            }
        }

        System.out.println("\n" + count + " of the " + eventsNumber + " requested records were found");
    }

    private static void showActionEvent (GroupActionEvent event) {
        switch (event.type()) {
            //GroupEventN1
            case "issues":
                String msjI = " an issue on ";
                if (event.action().equals("opened")) {
                    msjI = " a new issue on ";
                }
                String capActionIE = EventOutput.capitalize(event.action());
                System.out.println(capActionIE + msjI + event.repo());
                break;

            case "release":
                String msjR = event.action().equals("published") ? " a new " + event.type() + " on " : " a " + event.type() + " on ";
                String capActionR = EventOutput.capitalize(event.action());
                System.out.println(capActionR + msjR + event.repo() );
                break;

            case "pull request":
                String msjPR = event.action().equals("opened") ? " a new " + event.type() + " on " : " a " + event.type() + " on ";
                String capActionPR = "review_requested".equals(event.action()) ? "Requested a review for" : EventOutput.capitalize(event.action());
                System.out.println(capActionPR.replace("_", " ") + msjPR + event.repo());
                break;

            case "pull request review":
                String capActionPRR = EventOutput.capitalize(event.action());
                System.out.println(capActionPRR + " a review for a pull request on " + event.repo());
                break;

            case "pull request review comment":
                String capActionPRC = EventOutput.capitalize(event.action());
                System.out.println( capActionPRC + " a comment on a pull request review in " + event.repo());
                break;

            case "pull request review thread":
                String capActionPRRT = EventOutput.capitalize(event.action());
                System.out.println(capActionPRRT + " a discussion in a pull request on " + event.repo());
                break;

            case "issue comment":
                System.out.println("Commented on an issue in " + event.repo());
                break;

            case "gollum":
                String capActionG = EventOutput.capitalize(event.action());
                System.out.println(capActionG + " a Wiki page in " + event.repo());
                break;

            case "member" :
                String capActionM = EventOutput.capitalize(event.action());
                String msj = "removed".equals(event.action()) ? " a collaborator from " : " a collaborator to ";
                System.out.println(capActionM + msj + event.repo());
                break;

            case "watch" :
                System.out.println("Starred " + event.repo());
                break;
        }
    }

    private static void showSimpleEvent (GroupSimpleEvent event){
        switch (event.type()){

            case "commit comment", "fork":
                System.out.println("Created a new " + event.type() + " on " + event.repo());
                break;

            case "public":
                System.out.println("Made repository " + event.repo() + " public");
                break;
        }
    }

    private static void showRefTypeEvent (GroupRefTypeEvent event){
        String eventType = "create".equals(event.type()) ? "Created" : "Deleted";
        String msj = "create".equals(event.type()) ? " a new " + event.refType() + " on " : " a " + event.refType() + " from ";
        System.out.println(eventType + msj + event.repo());
    }

    private static void showPushEvent (GroupPushEvent event) {
        String msj = (event.size() == 1) ? " commit to " : " commits to ";
        System.out.println("Pushed " + event.size() + msj + event.repo());
    }

    private static void showSponsorEvent (GroupSponsorEvent event){
        System.out.println("Started sponsoring " + event.sponsored());
    }

    //UTILS

    public static String capitalize (String string){
        return string.substring(0,1).toUpperCase()+string.substring(1).toLowerCase();
    }

    private static List<GroupAllEvents> filterEvents (String typeEvent, List<GroupAllEvents> events){
        return events.stream()
                .filter(event -> Objects.equals(event.type(), typeEvent))
                .toList();
    }

    public static void readFile (File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
