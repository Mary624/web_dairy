package com.example.web_example.models;

public enum Permission {
    USERS_READ("users:read"),
    USERS_WRITE("users:write");

    public String getPermission() {
        return permission;
    }

    private final String permission;
    Permission(String permission) {
        this.permission = permission;
    }
}
