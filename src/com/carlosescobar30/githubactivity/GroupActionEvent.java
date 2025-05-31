package com.carlosescobar30.githubactivity;

public record GroupEventN1 (int groupEvent, String type, String repo, String action) implements GroupAllEvents {
}
