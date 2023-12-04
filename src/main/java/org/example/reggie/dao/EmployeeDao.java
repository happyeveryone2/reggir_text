package org.example.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.reggie.entity.Employee;

/**
 * @author doodle
 */
@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
}
