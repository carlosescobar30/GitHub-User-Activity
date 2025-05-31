package com.carlosescobar30.githubactivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassifyEvents {
    private static final Map<String,EventGroups> mapEventByGroup = new HashMap<>();


    static {
        //GROUP_ACTION
        mapEventByGroup.put("gollum",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("issue comment",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("issues",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("member",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("pull request",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("pull request review comment",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("pull request review",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("pull request review thread",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("release",EventGroups.GROUP_ACTION);
        mapEventByGroup.put("watch",EventGroups.GROUP_ACTION);

        //GROUP_N2
        mapEventByGroup.put("commit comment",EventGroups.GROUP_SIMPLE);
        mapEventByGroup.put("fork",EventGroups.GROUP_SIMPLE);
        mapEventByGroup.put("public",EventGroups.GROUP_SIMPLE);

        //GROUP_REF_TYPE
        mapEventByGroup.put("create",EventGroups.GROUP_REF_TYPE);
        mapEventByGroup.put("delete",EventGroups.GROUP_REF_TYPE);

        //GROUP_PUSH
        mapEventByGroup.put("push",EventGroups.GROUP_PUSH);

        //GROUP_SPONSOR
        mapEventByGroup.put("sponsorship",EventGroups.GROUP_SPONSOR);

    }

    public static EventGroups getEventGroup(String eventType){
        return mapEventByGroup.get(eventType);
    }

    public static Set<String> getEventSet (){
        return mapEventByGroup.keySet();
    }

}
