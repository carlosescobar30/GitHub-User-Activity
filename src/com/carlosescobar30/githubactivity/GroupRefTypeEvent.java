package com.carlosescobar30.githubactivity;

public record GroupEventN3 (int groupEvent, String type, String repo, String refType) implements GroupAllEvents {
}
