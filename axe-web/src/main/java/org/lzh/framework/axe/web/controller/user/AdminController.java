package org.lzh.framework.axe.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 后台管理控制器
 * @author: lizhaohua
 * @date: 15/12/2 下午6:03
 * @version: V1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(){
        return  new ModelAndView("index");
    }
}
