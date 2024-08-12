package com.wawa.wawa.controller;

import com.wawa.wawa.dtos.ProgressDto;
import com.wawa.wawa.dtos.UserDataDto;
import com.wawa.wawa.dtos.UserInfoDto;
import com.wawa.wawa.entity.User;
import com.wawa.wawa.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserInfo(@PathVariable String username) {

        User user = userService.getUserByUsername(username);
        if(user != null) {

            UserInfoDto userInfoDto = UserInfoDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .vip(user.isVip())
                    .level(user.getLevel())
                    .top(user.getTop()).build();

            List<ProgressDto> progress = user.getProgress().stream().map(p -> ProgressDto.builder()
                    .state(p.getState())
                    .progress(p.getProgress())
                    .materialsCompleted(p.getMaterialsCompleted())
                    .course(p.getCourse()).build()).toList();

            UserDataDto userDataDto = UserDataDto.builder()
                    .userInfo(userInfoDto)
                    .progress(progress).build();

            return ResponseEntity.ok(userDataDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{username}/profile")
    public ResponseEntity<?> getUserProfile(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if(user != null) {
            UserInfoDto userInfoDto = UserInfoDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .vip(user.isVip())
                    .level(user.getLevel())
                    .top(user.getTop()).build();
            return ResponseEntity.ok(userInfoDto);
        }
        return ResponseEntity.notFound().build();
    }
}
