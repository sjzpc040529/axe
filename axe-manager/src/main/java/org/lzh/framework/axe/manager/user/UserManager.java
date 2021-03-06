package org.lzh.framework.axe.manager.user;
import org.lzh.framework.axe.domain.entities.User;

import java.util.List;

/**
 * @Description: 用户信息事物管理接口
 * @author: lizhaohua
 * @date: 15/11/9 下午4:00
 * @version: V1.0
 */
public interface UserManager {
    /**
     * 保存用户信息
     * @param user
     */
    public  void save(User user);

	public void batchSave(List<User> users);

	public void batchSave2(List<User> users);
}
