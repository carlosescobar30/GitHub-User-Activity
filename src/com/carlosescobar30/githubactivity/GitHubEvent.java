package com.carlosescobar30.githubactivity;

 public record GitHubEvent (int IdGroupEvent, String type) implements GroupAllEvents {
}
