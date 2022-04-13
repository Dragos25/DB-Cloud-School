package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    public List<User> generateList(Integer howMany){
        Stream<User> users = Stream.generate(() -> User.createUser()).limit(howMany);
        return users.collect(Collectors.toList());
    }

    public List<User> filterAge(List<User> users){
        return users.stream().filter(u -> u.getAge()<18).collect(Collectors.toList());
    }

    public List<User> doubleAge(List<User> users){
        return users.stream().map( u -> {
            u.setAge(u.getAge()*2);
            return u;
        }).collect(Collectors.toList());
    }

    public User getLast(List<User> users){
        return users.stream().reduce((first, second) -> second).get();
    }

    public User getYoungest(List<User> users){
        return users.stream().min(Comparator.comparing(User::getAge)).get();
    }

    public User getOldest(List<User> users){
        return users.stream().max(Comparator.comparing(User::getAge)).get();

    }

    public List<User> removeDuplicates(List<User> users){
        return users.stream().distinct().collect(Collectors.toList());
    }

    public List<User> bigFilter(List<User> users){
        return users.stream().filter(u -> u.getAge()>30).map(u -> {
            u.setName(u.getName().toUpperCase());
            return u;
        }).sorted().collect(Collectors.toList());
    }
}
