package com.czg.dao;

import com.czg.domain.TaskLevel;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelDao {

    @Select("SELECT LEVEL_ID, LEVEL_NAME FROM TASK_LEVEL")
    List<TaskLevel> selectTaskLevel();
}
