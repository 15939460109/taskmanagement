package com.czg.service;

import com.czg.domain.TaskState;

import java.util.List;

public interface IStateService {

    /**
     * 获取所有的任务状态
     * @return
     */
    List<TaskState> selectTaskState();
}
