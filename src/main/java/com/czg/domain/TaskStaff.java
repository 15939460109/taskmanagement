package com.czg.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
//序列化的时候不包含某个属性
@JsonIgnoreProperties(value = "handler")
public class TaskStaff implements Serializable {

    private static final long serialVersionUID = 623139805081034555L;

    private int staff_id;
    private String staff_name;
    private String staff_workcode;
    private String staff_password;

    //staff--dept   一对多关系
    private TaskDept dept;
}
