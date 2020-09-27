package com.czg.service.impl;

import com.czg.dao.LevelDao;
import com.czg.domain.TaskLevel;
import com.czg.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements ILevelService {

    @Autowired
    private LevelDao levelDao;

    @Override
    public List<TaskLevel> selectTaskLevel() {
        return levelDao.selectTaskLevel();
    }
}
