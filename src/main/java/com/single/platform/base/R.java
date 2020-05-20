package com.single.platform.base;

import com.single.platform.enums.HttpEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义返回类
 * @author: 吴邪
 * @date: 2020/5/13 15:17
 */
@Data
@AllArgsConstructor
public class R<T>{

    private int errorCode;
    private String errorMsg;
    private T data;

    public static R success(){
        return new R(HttpEnum.SUCCESS,null);
    }

    public static R fail(HttpEnum httpEnum){
        return new R(httpEnum,null);
    }

    public static R fail(String errorMsg){
        return new R(999,errorMsg,null);
    }

    public static R exception(){
        return new R(HttpEnum.EXCEPTION,null);
    }

    public static<T> R success(T data){
        return new R(HttpEnum.SUCCESS,data);
    }

    public R(HttpEnum httpEnum,T data){
        this.errorCode = httpEnum.code;
        this.errorMsg = httpEnum.msg;
        this.data = data;
    }



}
