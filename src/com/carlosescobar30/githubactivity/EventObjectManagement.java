package com.carlosescobar30.githubactivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EventObjectManagement {
    final private static Map <String,List<GroupAllEvents>> cacheListsObject = new HashMap<>();

    static List<GroupAllEvents> eventJsonToObject (String gitHubUser) {
        List<GroupAllEvents> eventObjectList = cacheListsObject.get(gitHubUser);
        if (eventObjectList != null && !eventObjectList.isEmpty()){
            for (GroupAllEvents event : eventObjectList){
                System.out.println(event.toString() + "\n");
            }
            return eventObjectList;
        }
        eventObjectList = new ArrayList<>();
        List<String> eventJsonList = EventJsonManagement.eventJsonSplit(gitHubUser);
        String eventType;
        EventGroups group;
        for (String event : eventJsonList) {
            eventType = event.substring(
                    event.indexOf("\"type\":") + 8,
                    event.indexOf("\",",event.indexOf("\"type\":\"")))
                    .replaceAll("(?<!^)(?=[A-Z])", " ")
                    .replace(" Event","")
                    .toLowerCase();
            group = ClassifyEvents.getEventGroup(eventType);

            switch (group){
                case GROUP_ACTION:
                    eventObjectList.add(eventAsGroupAction(eventType,event));
                    break;

                case GROUP_SIMPLE:
                    eventObjectList.add(eventAsGroupSimple(eventType,event));
                    break;

                case GROUP_REF_TYPE:
                    eventObjectList.add(eventAsGroupRefType(eventType,event));
                    break;

                case GROUP_PUSH:
                    eventObjectList.add(eventAsGroupPush(eventType,event));
                    break;
                case GROUP_SPONSOR:
                    eventObjectList.add(eventAsGroupSponsor(eventType,event));
                    break;

                default:
                    System.out.println("Error: Unknown event");
            }

        }

        cacheListsObject.put(gitHubUser,eventObjectList);
        return eventObjectList;
    }

    private static GroupActionEvent eventAsGroupAction(String eventType, String event){
        String attPattern = "\"repo\":.*?\"name\":\"(.*?)\",.*?\"payload\":.*?\"action\":\"(.*?)\",?";
        Pattern pattern = Pattern.compile(attPattern);
        Matcher matcher = pattern.matcher(event);
        String eventRepo = "repo not found";
        String eventAction = "action not found";
        while (matcher.find()) {
            eventRepo = matcher.group(1);
            eventAction = matcher.group(2);
        }
        return new GroupActionEvent(1, eventType, eventRepo, eventAction);
    }

    private static GroupSimpleEvent eventAsGroupSimple(String eventType, String event){
        String attPattern = "\"repo\":.*?\"name\":\"(.*?)\",";
        Pattern pattern = Pattern.compile(attPattern);
        Matcher matcher = pattern.matcher(event);
        String eventRepo ="repo not found";
        while (matcher.find()){
            eventRepo = matcher.group(1);
        }
        return new GroupSimpleEvent(2, eventType,eventRepo);
    }

    private static GroupRefTypeEvent eventAsGroupRefType(String eventType, String event){
        String attPattern = "\"repo\":.*?\"name\":\"(.*?)\",.*?\"payload\":\\{.*?\"ref_type\":\"(.*?)\",";
        Pattern pattern = Pattern.compile(attPattern);
        Matcher matcher = pattern.matcher(event);
        String eventRepo = "repo not found";
        String eventRefType = "ref_type not found";
        while (matcher.find()){
            eventRepo = matcher.group(1);
            eventRefType = matcher.group(2);
        }
        return new GroupRefTypeEvent(3, eventType,eventRepo,eventRefType);
    }

    private static GroupPushEvent eventAsGroupPush(String eventType, String event){
        String attPattern = "\"repo\":.*?\"name\":\"(.*?)\",.*?\"payload\":.*?\"size\":(\\d*?),";
        Pattern pattern = Pattern.compile(attPattern);
        Matcher matcher = pattern.matcher(event);
        String eventRepo = "repo not found";
        int eventSeize = 0;
        while (matcher.find()){
            eventRepo = matcher.group(1);
            eventSeize = Integer.parseInt(matcher.group(2));
        }
        return new GroupPushEvent(4, eventType,eventRepo,eventSeize);
    }

    private static GroupSponsorEvent eventAsGroupSponsor(String eventType, String event){
        String attPattern = "\"payload\":.*?\"action\":\"(.*?)\",.*?\"sponsorable\":\\{.*?\"login\":\"(.*?)\",";
        Pattern pattern = Pattern.compile(attPattern);
        Matcher matcher = pattern.matcher(event);
        String eventAction = "action not found";
        String eventSponsored = "sponsored not found";
        while (matcher.find()) {
            eventAction = matcher.group(1);
            eventSponsored = matcher.group(2);
        }
        System.out.println(eventAction + " " + eventSponsored);
        return new GroupSponsorEvent(5, eventType, eventAction, eventSponsored);
    }
}
