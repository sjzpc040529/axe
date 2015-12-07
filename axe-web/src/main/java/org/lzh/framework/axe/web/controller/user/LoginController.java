package org.lzh.framework.axe.web.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/12/2 下午6:03
 * @version: V1.0
 */
@Controller
@RequestMapping("/sign")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 获取所有用户列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(HttpServletRequest request){


//        Result<List<User>> result  = userVerify.findAll();
//        logger.debug("接口"+"/getAllUser");
//        request.setAttribute("userList", result.getData());
        return "redirect:/user/getAllUser";
    }
}
