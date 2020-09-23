package com.czg.controller;

import com.czg.domain.TaskStaff;
import com.czg.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @RequestMapping("/login")
    public void login(HttpSession session, HttpServletRequest request) {
        String workcode = request.getParameter("staff_workcode");
        String password = request.getParameter("staff_password");
        TaskStaff staff = staffService.checkUser(workcode, password);
        System.out.println(staff);
    }
}
