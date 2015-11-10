package org.lzh.framework.axe.verify.user.impl;

import org.lzh.framework.axe.domain.entities.User;
import org.lzh.framework.axe.domain.enums.ErrorEnum;
import org.lzh.framework.axe.service.user.UserService;
import org.lzh.framework.axe.verify.user.UserVerify;
import org.lzh.framework.common.web.result.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 用户验证
 * @author: lizhaohua
 * @date: 15/11/9 下午3:09
 * @version: V1.0
 */
@Service
public class UserVerifyImpl implements UserVerify {
    @Resource
    private UserService userService ;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public Result save(User user) {
        if(null == user)
            return Result.errorResult(ErrorEnum.PARAM_IS_NULL.getCode(),ErrorEnum.PARAM_IS_NULL.getMsg());
        if( null == user.getUserName()||"".equals(user.getUserName()))
            return Result.errorResult(ErrorEnum.USERNAME_IS_NULL.getCode(),ErrorEnum.USERNAME_IS_NULL.getMsg());
        return userService.save(user);

    }
}
