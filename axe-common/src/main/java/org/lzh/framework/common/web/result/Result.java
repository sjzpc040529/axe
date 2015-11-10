package org.lzh.framework.common.web.result;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 返回結果集
 * Created by Courser on 2015/11/8.
 */
public class Result<D> implements Serializable {
    private final static  Integer sucCode=1 ;
    @Getter
    @Setter
    private boolean success;
    @Getter
    @Setter
    private String msg;
    @Getter
    @Setter
    private D data;
    @Getter
    @Setter
    private Integer resultCode;
    public  Result(boolean success){
        this.success = success;

    }
    public Result(){

    }

    public static <T> Result successResult(T data) {
        Result result = new Result();
        result.data = data;
        result.success = true;
        result.resultCode = sucCode ;
        return result;
    }

    public static Result errorResult(Integer errorCode, String message) {
        Result result = new Result(false);
//        result.success = false;
        result.resultCode = errorCode;
        result.msg = message;
        return result;
    }



}
