package com.czg.service.impl;

import com.czg.dao.IInfoDao;
import com.czg.domain.TaskInfo;
import com.czg.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements IInfoService {

    @Autowired
    private IInfoDao infoDao;

    @Override
    public int addTaskInfo(TaskInfo taskInfo) {
        return infoDao.addTaskInfo(taskInfo);
    }

    @Override
    public List<TaskInfo> selectTaskInfo(int staff_id, int year, int month) {
        return infoDao.selectTaskInfo(staff_id, year, month);
    }
}
