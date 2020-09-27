package com.czg.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
//序列化的时候不包含某个属性
@JsonIgnoreProperties(value = "handler")
public class TaskDept implements Serializable {

    private static final long serialVersionUID = 3396826021514482702L;

    private int dept_id;
    private String dept_name;
    private String dept_code;
}
