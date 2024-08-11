package com.wawa.wawa.controller;

import com.wawa.wawa.dtos.CourseDto;
import com.wawa.wawa.dtos.ProgressDto;
import com.wawa.wawa.dtos.UserInfoDto;
import com.wawa.wawa.entity.Progress;
import com.wawa.wawa.entity.User;
import com.wawa.wawa.service.interfaces.UserService;
import com.wawa.wawa.utiles.Message;
import com.wawa.wawa.utiles.UpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if(user != null) {
            List<ProgressDto> progress = user.getProgress().stream().map(p -> ProgressDto.builder()
                    .id(p.getId())
                    .state(p.getState())
                    .progress(p.getProgress())
                    .themesCompleted(p.getThemesCompleted())
                    .examsCompleted(p.getExamsCompleted())
                    .activitiesCompleted(p.getActivitiesCompleted())
                    .course(CourseDto.builder()
                            .id(p.getCourse().getId())
                            .name(p.getCourse().getName())
                            .description(p.getCourse().getDescription()).build())
                    .build()).collect(Collectors.toList());

            UserInfoDto userInfoDto = UserInfoDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .vip(user.isVip())
                    .level(user.getLevel())
                    .top(user.getTop())
                    .progress(progress).build();
             return ResponseEntity.ok(userInfoDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if(users != null) {
            return ResponseEntity.ok(userService.getAllUsers().stream()
                    .map(user -> UserInfoDto.builder()
                            .id(user.getId())
                            .username(user.getUsername())
                            .vip(user.isVip())
                            .level(user.getLevel())
                            .top(user.getTop()).build())
                    .collect(Collectors.toList()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public Object registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return new Message("User registered");
    }

    @PutMapping("update/username")
    public Object updateUsername(@RequestBody UpdateData updateData) {
        userService.updateUsername(updateData);
        return new Message("User updated");
    }
}
