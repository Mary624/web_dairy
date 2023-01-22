package com.example.web_example.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserOfDairy {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
