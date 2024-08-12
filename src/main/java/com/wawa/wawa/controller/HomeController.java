package com.wawa.wawa.controller;

import com.wawa.wawa.dtos.UserInfoDto;
import com.wawa.wawa.entity.User;
import com.wawa.wawa.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody User userData) {
        User user = userService.getUserByEmail(userData.getEmail());
        if (user != null){
            if(userData.getPassword().equals(user.getPassword())){
                UserInfoDto userInfoDto = UserInfoDto.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .level(user.getLevel())
                        .vip(user.isVip())
                        .top(user.getTop())
                        .build();
                return ResponseEntity.ok(userInfoDto);
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo incorrecto");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Validated User user) {
        if (userService.existsUserByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email ya registrado");
        }
        if (userService.existsUserByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username ya registrado");
        }
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }
}
