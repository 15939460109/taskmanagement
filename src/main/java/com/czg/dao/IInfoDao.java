package com.czg.dao;

import com.czg.domain.TaskInfo;
import com.czg.domain.TaskLevel;
import com.czg.domain.TaskStaff;
import com.czg.domain.TaskState;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInfoDao {

    @Insert("INSERT INTO TASK_INFO(SENDSTAFF, RECEIVESTAFF, LEVEL_ID, STATE_ID, INFO_DESC, INFO_CREATE_DATE, INFO_NAME) VALUES(#{sendStaff.staff_id}, #{receiveStaff.staff_id}, #{staffLevel.level_id}, #{staffState.state_id}, #{info_desc}, #{info_create_date}, #{info_name})")
    int addTaskInfo(TaskInfo taskInfo);

    @Results(
            id = "selectInfo",
            value = {
                    @Result(column = "info_name", property = "info_name"),
                    @Result(column = "info_desc", property = "info_desc"),
                    @Result(column = "info_create_date", property = "info_create_date"),
                    @Result(column = "level_id", property = "staffLevel", one = @One(select = "com.czg.dao.IInfoDao.selectTaskLevel", fetchType = FetchType.LAZY)),
                    @Result(column = "state_id", property = "staffState", one = @One(select = "com.czg.dao.IInfoDao.selectTaskState", fetchType = FetchType.LAZY)),
                    @Result(column = "sendStaff", property = "sendStaff", one = @One(select = "com.czg.dao.IInfoDao.selectTaskStaff", fetchType = FetchType.LAZY))
            }
    )

    @Select("SELECT INFO_NAME, SENDSTAFF, INFO_DESC, INFO_CREATE_DATE, LEVEL_ID, STATE_ID FROM TASK_INFO WHERE RECEIVESTAFF = #{staff_id} AND YEAR(INFO_CREATE_DATE) = #{year} AND MONTH(INFO_CREATE_DATE) = #{month} ORDER BY DAY(INFO_CREATE_DATE)")
    List<TaskInfo> selectTaskInfo(@Param("staff_id") int staff_id, @Param("year") int year, @Param("month") int month);

    @Select("SELECT STAFF_NAME FROM TASK_STAFF WHERE STAFF_ID = #{sendStaff}")
    TaskStaff selectTaskStaff(int sendStaff);

    @Select("SELECT LEVEL_ID, LEVEL_NAME FROM TASK_LEVEL WHERE LEVEL_ID = #{level_id}")
    TaskLevel selectTaskLevel(int level_id);

    @Select("SELECT STATE_ID, STATE_NAME FROM TASK_STATE WHERE STATE_ID = #{state_id}")
    TaskState selectTaskState(int state_id);
}
