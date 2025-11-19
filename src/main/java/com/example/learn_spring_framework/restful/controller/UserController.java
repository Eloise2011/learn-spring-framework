package com.example.learn_spring_framework.restful.controller;

import com.example.learn_spring_framework.restful.dao.User;
import com.example.learn_spring_framework.restful.exception.NoUserFoundException;
import com.example.learn_spring_framework.restful.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-17 21:04
 */
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "欢迎页面 - UserController 已启动！";
    }

    // 添加测试端点
    @GetMapping("/test")
    public String test() {
        return "测试端点正常工作！时间：" + new java.util.Date();
    }

    @GetMapping("/users")
    public List<User> findAll() {
        System.out.println("Getting all users via findAll");
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User findOne(@PathVariable int id) {
        User one = userService.findOne(id);
        if(null == one){
            throw new NoUserFoundException("User not found, id: ~~~" + id);
        }
        return one;
    }

    @DeleteMapping("/user/{id}")
    public User deleteOne(@PathVariable int id) {
        User one = userService.deleteOne(id);
        if(null == one){
            throw new NoUserFoundException("User not found, id: ~~~" + id + ", hence not deleted");
        }
        return one;
    }

//    @PostMapping("/user")
//    public User saveUser(@RequestBody User user){
//        return userService.save(user);
//    }

    @PostMapping(value = "/user", produces = {"application/json","application/xml"}) // this will save and return the correct HTTP status code
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        //return ResponseEntity.created(null).build();
        return ResponseEntity.created(uriLocation)
                .build();
    }
}
