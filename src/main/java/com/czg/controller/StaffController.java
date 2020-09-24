package com.czg.controller;

import com.czg.domain.TaskStaff;
import com.czg.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//DEBUG调试，F6下一步  F8跳出当前断点
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @RequestMapping("/login")
    @ResponseBody
    public TaskStaff login(HttpSession session, HttpServletRequest request) {
        String workcode = request.getParameter("staff_workcode");
        String password = request.getParameter("staff_password");
        return staffService.checkUser(workcode, password);
    }
}
