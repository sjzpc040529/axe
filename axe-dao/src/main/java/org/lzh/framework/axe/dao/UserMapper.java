package org.lzh.framework.axe.dao;
import org.lzh.framework.axe.domain.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Mapper
 * Created by Courser on 2015/11/7.
 */
@Repository("userMapper")
public interface UserMapper {

    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    Integer delete(int id);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 查找所有
     * @return
     */
    List<User> findAll();
}
