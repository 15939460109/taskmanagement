package com.czg.service.impl;

import com.czg.dao.IDeptDao;
import com.czg.domain.TaskDept;
import com.czg.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    @Override
    public List<TaskDept> selectTaskDept() {
        return deptDao.selectTaskDept();
    }
}
