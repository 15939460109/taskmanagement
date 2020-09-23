package com.czg.dao;

import com.czg.domain.TaskStaff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffDao {

    //ctrl+shift+u  转换大小写
    @Select("SELECT STAFF_ID, DEPT_ID, STAFF_NAME, STAFF_WORKCODE, STAFF_PASSWORD " +
            "FROM TASK_STAFF WHERE STAFF_WORKCODE = #{workcode} AND STAFF_PASSWORD = " +
            "#{password}")
    //多个参数处理方法，1.加注解  2.放入map  3.放入对象
    TaskStaff checkUser(@Param("workcode") String workcode, @Param("password") String password);
}
