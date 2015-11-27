package org.lzh.framework.axe.service.user.impl;

import org.lzh.framework.axe.dao.UserMapper;
import org.lzh.framework.axe.domain.entities.User;
import org.lzh.framework.axe.domain.enums.ErrorEnum;
import org.lzh.framework.axe.manager.user.UserManager;
import org.lzh.framework.axe.service.user.UserService;
import org.lzh.framework.common.web.result.Result;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserMapper mapper;

	@Resource
	private UserManager userManager;

	public Integer delete(int id) {

		return mapper.delete(id);
	}

	public List<User> findAll() {
		List<User> findAllList = mapper.findAll();
		return findAllList;
	}

	public User findById(int id) {

		User user = mapper.findById(id);

		return user;
	}

	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	public Result save(User user) {
		try{
			userManager.save(user);
			return Result.successResult(true);
		}catch (Exception e){
			logger.info("class name:{}#{}==>{}", this.getClass().getName(), "save", e);
			return  Result.errorResult(ErrorEnum.SYSTEM_IS_ERROR.getCode(), ErrorEnum.SYSTEM_IS_ERROR.getMsg());
		}


	}

	public Integer update(User user) {

		return mapper.update(user);
	}



}
