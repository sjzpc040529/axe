package org.lzh.framework.axe.manager.user.impl;

import org.lzh.framework.axe.domain.entities.User;
import org.lzh.framework.axe.manager.user.UserManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:用户信息事物管理层,单表操作单条数据不启用事物
 * @author: lizhaohua
 * @date: 15/11/9 下午4:02
 * @version: V1.0
 */
@Service
public class UserManagerImpl implements UserManager {
    @Resource
    private UserMapper userMapper ;
    /**
     * 保存
     * @param user
     */
    @Override
    public void save(User user) {
        userMapper.save(user);

    }
}
