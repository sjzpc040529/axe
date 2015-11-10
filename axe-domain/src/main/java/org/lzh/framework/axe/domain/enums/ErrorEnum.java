package org.lzh.framework.axe.domain.enums;

import lombok.Getter;

/**
 * @Description:错误码
 * 1~200（含负值）：属于共有
 * @author: lizhaohua
 * @date: 15/11/9 下午3:13
 * @version: V1.0
 */
public enum ErrorEnum {
    PARAM_IS_NULL(-1, "参数为空"),
    SYSTEM_IS_ERROR(-2,"系统异常"),
    //201-300用户
    USERNAME_IS_NULL(-201,"用户名不为空");

    @Getter
    private Integer code ;
    @Getter
    private String msg ;
    ErrorEnum(Integer code,String msg){
        this.code = code ;
        this.msg = msg ;
    }
}
