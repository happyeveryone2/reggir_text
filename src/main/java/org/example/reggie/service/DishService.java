package org.example.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.reggie.dto.DishDto;
import org.example.reggie.entity.Dish;

public interface DishService extends IService<Dish> {
    //新增菜品，需要操作两张表
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息
    public void updateWithFlavor(DishDto dishDto);
}
