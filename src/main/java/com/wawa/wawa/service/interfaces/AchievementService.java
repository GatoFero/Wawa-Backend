package com.wawa.wawa.service.interfaces;

import com.wawa.wawa.entity.Achievement;

import java.util.List;

public interface AchievementService {
    Achievement getAchievementById(int id);

    List<Achievement> getAllAchievements();
}
