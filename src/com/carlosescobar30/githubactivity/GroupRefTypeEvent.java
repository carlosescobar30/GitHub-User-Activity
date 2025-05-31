package com.carlosescobar30.githubactivity;

public record GroupRefTypeEvent(int groupEvent, String type, String repo, String refType) implements GroupAllEvents {
}
