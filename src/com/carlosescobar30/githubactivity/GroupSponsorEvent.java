package com.carlosescobar30.githubactivity;

public record GroupSponsorEvent(int groupEvent, String type, String action,  String sponsored) implements GroupAllEvents {
}
