package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final UserService userService;
    private static List<User> users;
    @GetMapping("/demo")
    public String test(){
        return "alo";
    }

    @PostMapping("/generate/{howMany}")
    public List<User> generateList(@PathVariable Integer howMany){
        users = userService.generateList(howMany);
        return users;

    }

    @GetMapping("/filterAge")
    public List<User> filterAge(){
        return userService.filterAge(users);

    }

    @GetMapping("/doubleAge")
    public List<User> doubleAge(){
        return userService.doubleAge(users);
    }

    @GetMapping("/getLast")
    public User getLast(){
        return userService.getLast(users);
    }

    @GetMapping("/getYoungest")
    public User getYoungest(){
        return userService.getYoungest(users);
    }

    @GetMapping("/getOldest")
    public User getOldest(){
        return userService.getOldest(users);
    }

    @GetMapping("/removeDuplicates")
    public List<User> removeDuplicates(){
        return userService.removeDuplicates(users);
    }

    @GetMapping("/bigFilter")
    public List<User> bigFilter(){
        return userService.bigFilter(users);
    }
}
