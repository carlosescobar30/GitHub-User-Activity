package com.carlosescobar30.githubactivity;

public record GroupEventN1 (String type, String repo, String action) implements GroupAllEvents {
}
