package org.example.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.reggie.dto.SetmealDto;
import org.example.reggie.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    //新增套餐，保留套餐和菜品的相关性
    public void saveWithDish(SetmealDto setmealDto);

    //删除套餐，保留套餐和菜品的相关性
    public void removeWithDish(List<Long> ids);
}
