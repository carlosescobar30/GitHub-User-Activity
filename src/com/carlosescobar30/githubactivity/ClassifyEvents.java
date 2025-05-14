package com.carlosescobar30.githubactivity;

import java.util.HashMap;
import java.util.Map;

public class ClassifyEvents {
    private static final Map<String,EventGroups> mapEventByGroup = new HashMap<>();


    static {
        //GROUP_N1
        mapEventByGroup.put("GollumEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("IssueCommentEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("IssuesEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("MemberEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("PullRequestEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("PullRequestReviewCommentEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("PullRequestReviewEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("PullRequestReviewThreadEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("ReleaseEvent",EventGroups.GROUP_N1);
        mapEventByGroup.put("WatchEvent",EventGroups.GROUP_N1);

        //GROUP_N2
        mapEventByGroup.put("CommitCommentEvent",EventGroups.GROUP_N2);
        mapEventByGroup.put("ForkEvent",EventGroups.GROUP_N2);
        mapEventByGroup.put("PublicEvent",EventGroups.GROUP_N2);

        //GROUP_N3
        mapEventByGroup.put("CreateEvent",EventGroups.GROUP_N3);
        mapEventByGroup.put("DeleteEvent",EventGroups.GROUP_N3);

        //GROUP_N4
        mapEventByGroup.put("PushEvent",EventGroups.GROUP_N4);

        //GROUP_N5
        mapEventByGroup.put("SponsorshipEvent",EventGroups.GROUP_N5);

    }

    public static EventGroups getEventGroup(String eventType){
        return mapEventByGroup.get(eventType);
    }
}
