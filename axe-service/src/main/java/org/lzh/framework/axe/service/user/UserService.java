package org.lzh.framework.axe.service.user;


import org.lzh.framework.axe.domain.entities.User;

import java.util.List;

public interface UserService {
	void save(User user);
	boolean update(User user);
	boolean delete(int id);
	User findById(int id);
	List<User> findAll();
}
