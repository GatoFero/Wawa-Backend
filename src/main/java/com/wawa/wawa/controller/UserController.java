package com.wawa.wawa.controller;

import com.wawa.wawa.entity.User;
import com.wawa.wawa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/saludo")
    public String saludo() {
        return "Hola mundo";
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getIdUser());
    }
}
