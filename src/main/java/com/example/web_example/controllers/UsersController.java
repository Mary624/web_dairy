package com.example.web_example.controllers;

import com.example.web_example.models.UserOfDairy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasAuthority('users:write')")
public class UsersController {
    private List<UserOfDairy> USERS = Stream.of(
            new UserOfDairy(1L,"Олежик"),
            new UserOfDairy(2L,"Петя")
    ).collect(Collectors.toList());

    @PostMapping
    public UserOfDairy createUser(@RequestBody UserOfDairy user){
        this.USERS.add(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        this.USERS.removeIf((userOfDairy -> userOfDairy.getId().equals(id)));
    }

    @GetMapping
    public List<UserOfDairy> getUsers(){
        return USERS;
    }

    @GetMapping("/{id}")
    public UserOfDairy getUser(@PathVariable Long id){
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst()
                .orElse(null);
    }
}
