package com.wawa.wawa.service.interfaces;

import com.wawa.wawa.entity.Progress;

import java.util.List;

public interface ProgressService {

    List<Progress> getAllProgress();

    Progress createProgress(Progress progress);

    void deleteProgress(Long id);

    Progress getProgressById(Long id);
}
