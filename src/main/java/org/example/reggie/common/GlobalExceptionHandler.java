package org.example.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author doodle
 */
@Slf4j
@ResponseBody
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {


    /**
     * 全局异常
     * @param exception
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionhandler(CustomException exception){
        log.error(exception.getMessage());
        return R.error(exception.getMessage());
    }


    /**
     * 全局异常
     * @param exception
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionhandler(SQLIntegrityConstraintViolationException exception){
        log.error(exception.getMessage());

        if (exception.getMessage().contains("Duplicate entry")) {
            String[] spilt = exception.getMessage().split(" ");
            String entry = spilt[2]+"已存在";
            return R.error(entry);
        }

        return R.error("未知错误");
    }
}
