package com.single.platform.exception;

import com.single.platform.enums.HttpEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: 吴邪
 * @date: 2020/5/14 17:38
 */
@Data
@AllArgsConstructor
public class MyException extends Exception {
    HttpEnum errorEnum;

    public MyException(String msg){
        super(msg);
    }
}
