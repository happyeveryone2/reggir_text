package org.example.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.reggie.common.CustomException;
import org.example.reggie.dao.CategoryDao;
import org.example.reggie.entity.Category;
import org.example.reggie.entity.Dish;
import org.example.reggie.entity.Setmeal;
import org.example.reggie.service.CategoryService;
import org.example.reggie.service.DishService;
import org.example.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;
    /**
     *根据id删除菜单，先判断是否与菜品有关联
     * @param id
     */
    @Override
    public void remove(long id) {
        //条件构造器
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);

        // 抛出异常是否关联菜品
        if (dishService.count(dishLambdaQueryWrapper) > 0) {
            throw new CustomException("已关联菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealQueryWrapper = new LambdaQueryWrapper<>();
        setmealQueryWrapper.eq(Setmeal::getCategoryId,id);

        //抛出异常，是否关联套餐
        if (setmealService.count(setmealQueryWrapper) > 0) {
            throw new CustomException("已关联套餐，不能删除");
        }

        //无问题时，删除菜单
        super.removeById(id);

    }
}
