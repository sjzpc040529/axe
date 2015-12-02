package org.lzh.framework.axe.web.controller.user;

import org.lzh.framework.axe.domain.entities.User;
import org.lzh.framework.axe.service.user.UserService;
import org.lzh.framework.axe.verify.user.UserVerify;
import org.lzh.framework.common.web.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;
	@Resource
	private UserVerify userVerify ;

	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request){

		Result<List<User>> result  = userVerify.findAll();
		logger.debug("接口"+"/getAllUser");
		request.setAttribute("userList", result.getData());
		return "/allUser";
	}

	/**
	 * 跳转到添加用户界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddUser")
	public String toAddUser(HttpServletRequest request){
		return "/addUser";
	}
	/**
	 * 添加用户并重定向
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		userService.save(user);
		return "redirect:/user/getAllUser";
	}

	/**
	 *编辑用户
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request){


		if(userService.update(user)>0){
			user = userService.findById(user.getId());
			request.setAttribute("user", user);
			return "redirect:/user/getAllUser";
		}else{
			return "/error";
		}
	}
	/**
	 * 根据id查询单个用户
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getUser")
	public String getUser(int id,HttpServletRequest request){

		request.setAttribute("user", userService.findById(id));
		return "/editUser";
	}
	/**
	 * 删除用户
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delUser")
	public void delUser(int id,HttpServletRequest request,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
String aa ="111111111";
		if(userService.delete(id)>0){
			result = "{\"result\":\"success\"}";
		}

		response.setContentType("application/json");

		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
