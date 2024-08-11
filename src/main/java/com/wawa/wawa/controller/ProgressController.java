package com.wawa.wawa.controller;

import com.wawa.wawa.entity.Progress;
import com.wawa.wawa.service.interfaces.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/add")
    public Progress addProgress(@RequestBody Progress progress) {
        return progressService.createProgress(progress);
    }
    @GetMapping("/{id}")
    public Progress getProgress(@PathVariable Long id) {
        return progressService.getProgressById(id);
    }
    @GetMapping("/all")
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }
    @GetMapping("/delete/{id}")
    public void deleteProgress(@PathVariable Long id) {
        progressService.deleteProgress(id);
    }
}
