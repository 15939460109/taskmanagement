package com.czg.service.impl;

import com.czg.dao.IStaffDao;
import com.czg.domain.TaskStaff;
import com.czg.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private IStaffDao staffDao;

    @Override
    public TaskStaff checkUser(String workcode, String password) {
        try {
            return staffDao.checkUser(workcode, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TaskStaff> selectTaskStaff(String dept_id) {
        return staffDao.selectTaskStaff(dept_id);
    }
}
