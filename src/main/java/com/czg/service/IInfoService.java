package com.czg.service;

import com.czg.domain.TaskInfo;

import java.util.List;

public interface IInfoService {

    /**
     * 给定相关实体类，插入一条任务信息，返回记录改变行数
     * @param taskInfo
     * @return
     */
    int addTaskInfo(TaskInfo taskInfo);

    /**
     * 查询某个员工的当年当月的所有任务
     * @param staff_id
     * @param year
     * @param month
     * @return
     */
    List<TaskInfo> selectTaskInfo(int staff_id, int year, int month);
}
