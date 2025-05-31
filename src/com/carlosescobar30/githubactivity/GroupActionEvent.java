package com.carlosescobar30.githubactivity;

public record GroupActionEvent(int groupEvent, String type, String repo, String action) implements GroupAllEvents {
}
