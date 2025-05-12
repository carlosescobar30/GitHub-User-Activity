package com.carlosescobar30.githubactivity;

public record GroupEventN2 (int IdEvent, int IdGroupEvent, String type, String repo) implements GroupAllEvents {
}

