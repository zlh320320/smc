package com.zlh.web.sys;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zlh.web.front.intercepter.NeedLogin;
import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.UserDTO;
import com.zlh.wx.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

    private static Log               logger      = LogFactory.getLog(LoginController.class);
    private final static UserService userService = WechatServiceLocator.getUserService();

    // 进入登录页面
   /* @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        logger.info("to login page...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/sys/syslogin");

        return modelAndView;
    }*/
    

    // 表单登录
   /* @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        logger.info("to login page...");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDTO user = userService.getUserByUserName(username);
        if (user == null) {
            return "redirect:/login";
        }

        if (password != null) { // 密码正确进入首页
            if (password.equals(EncoderUtil.decry(user.getPassword()))) {
                return "redirect:/index";
            }
        }

        return "redirect:/login";
    }*/

    // 进入后台首页
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @NeedLogin
    public ModelAndView main(HttpServletRequest request) {
        logger.info("to idnex page...");
        UserDTO user=(UserDTO)request.getSession().getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        if(user!=null&&user.getIsAdmin()==1){
          modelAndView.setViewName("/sys/main");
        }
        else if(user!=null&&user.getIsAdmin()!=1){
          modelAndView.setViewName("redirect:/index.html");
        }
        else{
            modelAndView.setViewName("/views/login");
        }
        

        return modelAndView;
    }
}
