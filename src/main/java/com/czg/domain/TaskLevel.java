package com.czg.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
//序列化的时候不包含某个属性
@JsonIgnoreProperties(value = "handler")
public class TaskLevel implements Serializable {

    private static final long serialVersionUID = 6774990677491791788L;

    private int level_id;
    private String level_name;
}
