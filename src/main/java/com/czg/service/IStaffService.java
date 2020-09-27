package com.czg.service;

import com.czg.domain.TaskStaff;

import java.util.List;

public interface IStaffService {

    /**
     * 根据工号和密码校验用户是否存在，如果存在则返回该用户，不存在则返回null
     * @param workcode
     * @param password
     * @return
     */
    TaskStaff checkUser(String workcode, String password);

    /**
     * 查询某个部门所有的员工信息
     * @param dept_id
     * @return
     */
    List<TaskStaff> selectTaskStaff(String dept_id);
}
