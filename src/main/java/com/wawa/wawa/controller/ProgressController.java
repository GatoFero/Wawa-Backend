package com.wawa.wawa.controller;

import com.wawa.wawa.dtos.ProgressDto;
import com.wawa.wawa.entity.Course;
import com.wawa.wawa.entity.Progress;
import com.wawa.wawa.entity.User;
import com.wawa.wawa.service.interfaces.CourseService;
import com.wawa.wawa.service.interfaces.ProgressService;
import com.wawa.wawa.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class ProgressController {

    private final ProgressService progressService;
    private final CourseService courseService;
    private final UserService userService;


    public ProgressController(ProgressService progressService, CourseService courseService, UserService userService) {
        this.progressService = progressService;
        this.courseService = courseService;
        this.userService = userService;
    }

    @PostMapping("/{username}/add/{idCourse}")
    public ResponseEntity<?> addProgress(@PathVariable String username, @PathVariable int idCourse) {
        if (username == null || username.isEmpty() || idCourse <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos inválidos");
        }

        User user = userService.getUserByUsername(username);
        Course course = courseService.getCourseById(idCourse);
        if (user == null || course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o curso no encontrado");
        }

        Progress progress = new Progress();
        progress.setProgress(0f);
        progress.setState("En Progreso");
        progress.setCourse(course);
        progress.setUser(user);

        if(!userService.progressExists(progress.getUser().getUsername(), progress.getCourse().getId())){
            progressService.createProgress(progress);
            ProgressDto progressDto = ProgressDto.builder()
                    .course(progress.getCourse())
                    .state(progress.getState())
                    .progress(progress.getProgress())
                    .materialsCompleted(progress.getMaterialsCompleted()).build();

            return ResponseEntity.ok(progressDto);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El progreso ya existe para este curso y usuario.");
    }
}
