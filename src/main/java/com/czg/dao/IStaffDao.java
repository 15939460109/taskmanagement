package com.czg.dao;

import com.czg.domain.TaskDept;
import com.czg.domain.TaskStaff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffDao {

    //ctrl+shift+u  转换大小写
    @Results({//结果集
            @Result(column = "staff_id", property = "staff_id"),
            @Result(column = "staff_name", property = "staff_name"),
            @Result(column = "staff_workcode", property = "staff_workcode"),
            @Result(column = "staff_password", property = "staff_password"),
            //需要通过dept_id查找dept信息
            //fetchType = FetchType.LAZY、DEFAULT懒加载    EAGER立即加载
            @Result(column = "dept_id", property = "dept", one = @One(select = "com.czg.dao.selectDeptById", fetchType = FetchType.LAZY))
    })
    @Select("SELECT STAFF_ID, STAFF_NAME, STAFF_WORKCODE, STAFF_PASSWORD " +
            "FROM TASK_STAFF WHERE STAFF_WORKCODE = #{workcode} AND STAFF_PASSWORD = " +
            "#{password}")
    //多个参数处理方法，1.加注解  2.放入map  3.放入对象
    TaskStaff checkUser(@Param("workcode") String workcode, @Param("password") String password);

    @Select("SELECT DEPT_ID, DEPT_NAME, DEPT_CODE FROM TASK_DEPT WHERE DEPT_ID = #{dept_id}")
    TaskDept selectDeptById(int dept_id);
}
