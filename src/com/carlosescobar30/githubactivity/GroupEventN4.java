package com.carlosescobar30.githubactivity;

public record GroupEventN4 (int IdEvent, int IdGroupEvent, String type, String repo, String action) implements GroupAllEvents {
}
