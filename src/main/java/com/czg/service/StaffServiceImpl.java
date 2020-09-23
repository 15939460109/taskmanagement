package com.czg.service;

import com.czg.dao.IStaffDao;
import com.czg.domain.TaskStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffService")
public class StaffServiceImpl implements IStaffService{

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
}
