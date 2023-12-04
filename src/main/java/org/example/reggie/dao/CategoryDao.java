package org.example.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.reggie.entity.Category;

/**
 * @author doodle
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
