package com.czg.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
//序列化的时候不包含某个属性
@JsonIgnoreProperties(value = "handler")
public class TaskInfo implements Serializable {

    private static final long serialVersionUID = 860805628383734250L;

    private int info_id;
    private String info_desc;
    private String info_create_date;
    private String info_name;
    private String info_no_end_date;
    private String info_end_date;

    private TaskStaff sendStaff;
    private TaskStaff receiveStaff;
    private TaskLevel staffLevel;
    private TaskState staffState;

}
