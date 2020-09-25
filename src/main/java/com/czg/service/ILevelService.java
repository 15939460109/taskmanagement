package com.czg.service;

import com.czg.domain.TaskLevel;

import java.util.List;

public interface ILevelService {

    /**
     * 查询所有的任务级别
     * @return
     */
    List<TaskLevel> selectTaskLevel();
}
