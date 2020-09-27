package com.czg.dao;

import com.czg.domain.TaskDept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeptDao {

    @Select("select dept_id, dept_name, dept_code from task_dept")
    List<TaskDept> selectTaskDept();
}
