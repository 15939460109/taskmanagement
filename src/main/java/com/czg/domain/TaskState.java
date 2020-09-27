package com.czg.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
//序列化的时候不包含某个属性
@JsonIgnoreProperties(value = "handler")
public class TaskState implements Serializable {

    private static final long serialVersionUID = 7570561321353379274L;

    private int state_id;
    private String state_name;
}
