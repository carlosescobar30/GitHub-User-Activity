package com.carlosescobar30.githubactivity;

public record GroupSimpleEvent(int groupEvent, String type, String repo) implements GroupAllEvents {
}

