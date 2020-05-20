package com.single.platform.exception;

import com.single.platform.base.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: 吴邪
 * @date: 2020/5/13 15:12
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    public R myExceptionHandler(MyException e){
        log.error(e.getMessage(),e);
        return e.errorEnum==null?R.fail(e.getMessage()):R.fail(e.errorEnum);
    }

    @ExceptionHandler(Exception.class)
    public R allExceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        return R.exception();
    }
}
