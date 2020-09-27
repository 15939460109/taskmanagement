package com.czg.dao;

import com.czg.domain.TaskState;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateDao {

    @Select("SELECT STATE_ID, STATE_NAME FROM TASK_STATE")
    List<TaskState> selectTaskState();
}
