package com.czg.controller;

import com.czg.domain.*;
import com.czg.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DEBUG调试，F6下一步  F8跳出当前断点
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;
    @Autowired
    private ILevelService staffLevel;
    @Autowired
    private IStateService stateService;
    @Autowired
    private IDeptService deptService;
    @Autowired
    private IInfoService infoService;

    @RequestMapping("/login")
    @ResponseBody
    public TaskStaff login(HttpSession session, HttpServletRequest request) {
        String workcode = request.getParameter("staff_workcode");
        String password = request.getParameter("staff_password");
        TaskStaff staff = staffService.checkUser(workcode, password);
        session.setAttribute("user", staff);
        return staff;
    }

    @RequestMapping("/selectTaskLevel")
    @ResponseBody
    public List<TaskLevel> selectTaskLevel() {
        return staffLevel.selectTaskLevel();
    }

    @RequestMapping("/selectTaskState")
    @ResponseBody
    public List<TaskState> selectTaskState() {
        return stateService.selectTaskState();
    }

    @RequestMapping("/selectTaskDept")
    @ResponseBody
    public List<TaskDept> selectTaskDept() {
        return deptService.selectTaskDept();
    }

    @RequestMapping("/selectTaskStaff")
    @ResponseBody
    public List<TaskStaff> selectTaskStaff(HttpServletRequest request) {
        String dept_id = request.getParameter("dept_id");
        return staffService.selectTaskStaff(dept_id);
    }

    @RequestMapping("/selectTaskInfo")
    @ResponseBody
    public List<TaskInfo> selectTaskInfo(HttpSession session, HttpServletRequest request) {
        int staff_id = ((TaskStaff) session.getAttribute("user")).getStaff_id();
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        return infoService.selectTaskInfo(staff_id, year, month);
    }

    @RequestMapping("/addTaskInfo")
    @ResponseBody
    public Map<String, String> addTaskInfo(HttpSession session, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        //name:  taskTime  taskName  taskDetail  staff  level      state
        //注意session必须包含登录信息，否则会产生NullPointerException
        int sendStaff_id = ((TaskStaff) session.getAttribute("user")).getStaff_id();
        String receiveStaff_id = request.getParameter("staff");
        String taskTime = request.getParameter("taskTime");
        String taskName = request.getParameter("taskName");
        String taskDetail = request.getParameter("taskDetail");
        String level_id = request.getParameter("taskLevel");
        String state_id = request.getParameter("taskState");
        //创建外键id对应实体类，并将值放入
        TaskStaff sendStaff = new TaskStaff();
        sendStaff.setStaff_id(sendStaff_id);
        TaskStaff receiveStaff = new TaskStaff();
        receiveStaff.setStaff_id(Integer.parseInt(receiveStaff_id));
        TaskLevel level = new TaskLevel();
        level.setLevel_id(Integer.parseInt(level_id));
        TaskState state = new TaskState();
        state.setState_id(Integer.parseInt(state_id));
        //创建TaskInfo对象，将值放入
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setInfo_name(taskName);
        taskInfo.setInfo_desc(taskDetail);
        taskInfo.setInfo_create_date(taskTime);
        taskInfo.setSendStaff(sendStaff);
        taskInfo.setReceiveStaff(receiveStaff);
        taskInfo.setStaffLevel(level);
        taskInfo.setStaffState(state);
        //调用service
        int i = infoService.addTaskInfo(taskInfo);
        if (i == 1) {
            map.put("result", "添加成功");
        } else {
            map.put("result", "添加失败");
        }
        return map;
    }
}
