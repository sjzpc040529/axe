package org.lzh.framework.axe.service.user;

import org.lzh.framework.axe.domain.entities.User;
import org.lzh.framework.common.web.result.Result;

import java.util.List;

/**
 * 用户信息service
 */
public interface UserService {
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	Result save(User user);
	Integer update(User user);
	Integer delete(int id);
	User findById(int id);
	List<User> findAll();
}
