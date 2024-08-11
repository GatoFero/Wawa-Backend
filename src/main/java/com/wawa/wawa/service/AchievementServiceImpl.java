package com.wawa.wawa.service;

import com.wawa.wawa.entity.Achievement;
import com.wawa.wawa.repository.AchievementRepository;
import com.wawa.wawa.service.interfaces.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Override
    public Achievement getAchievementById(int id) {
        return achievementRepository.getReferenceById(id);
    }

    @Override
    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }
}
