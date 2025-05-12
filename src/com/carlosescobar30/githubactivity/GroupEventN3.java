package com.carlosescobar30.githubactivity;

public record GroupEventN3 (int IdEvent, int IdGroupEvent, String type, String repo, String refType) implements GroupAllEvents {
}
