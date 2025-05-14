package com.carlosescobar30.githubactivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class EventObjectManagement {

    static List<GroupAllEvents> eventJsonToObject (File file) {
        List<String> eventJsonList = EventJsonManagement.eventJsonSplit(file);
        List<GroupAllEvents> eventObjectList = new ArrayList<>();
        String typeEvent;
        EventGroups group;
        for (String event : eventJsonList) {
            typeEvent = event.substring(
                    event.indexOf("\"type\":") + 8,
                    event.indexOf("\",",event.indexOf("\"type\":\"")));
            group = ClassifyEvents.getEventGroup(typeEvent);

            switch (group){
                case GROUP_N1:

            }
        }
        return eventObjectList;
    }

    private static GroupEventN1 eventAsGroupN1 (String eventType, String event){



        )
    }
}
