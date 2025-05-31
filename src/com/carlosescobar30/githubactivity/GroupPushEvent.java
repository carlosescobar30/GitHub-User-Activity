package com.carlosescobar30.githubactivity;

public record GroupPushEvent(int groupEvent, String type, String repo, int size) implements GroupAllEvents{
}
