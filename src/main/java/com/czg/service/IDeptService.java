package com.czg.service;

import com.czg.domain.TaskDept;

import java.util.List;

public interface IDeptService {

    /**
     * 查询所有的部门信息
     * @return
     */
    List<TaskDept> selectTaskDept();
}
