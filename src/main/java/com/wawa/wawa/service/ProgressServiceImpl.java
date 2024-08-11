package com.wawa.wawa.service;

import com.wawa.wawa.entity.Progress;
import com.wawa.wawa.repository.ProgressRepository;
import com.wawa.wawa.service.interfaces.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    @Override
    public Progress createProgress(Progress progress){
        return progressRepository.save(progress);
    }

    @Override
    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }

    @Override
    public Progress getProgressById(Long id) {
        return progressRepository.findById(id).orElse(null);
    }
}
