package com.zlh.web.wechat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.web.front.intercepter.NeedLogin;
import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.UserDTO;
import com.zlh.wx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Log logger = LogFactory.getLog(UserController.class);

	private final static UserService userService = WechatServiceLocator.getUserService();

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@NeedLogin
	public ModelAndView getUser(int userId) {
		logger.info("to UserController Index Method...");

		ModelAndView modelAndView = new ModelAndView();

		UserDTO user = userService.getUserByUserId(userId);

		modelAndView.addObject("user", user);
		modelAndView.addObject("name", user.getNickName());
		modelAndView.setViewName("/sys/userForm");

		return modelAndView;
	}
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
    @NeedLogin
    public ModelAndView userList(String username,@RequestParam(defaultValue = "1")
    Integer pageNo, @RequestParam(defaultValue = "10")
    Integer pageSize) {
        logger.info("to UserController Index Method...");

        ModelAndView modelAndView = new ModelAndView();

        List<UserDTO> userList = userService.getUserList(new PageBounds(pageNo,pageSize), null);

        modelAndView.addObject("userList", userList);
        modelAndView.addObject("username", username);
        modelAndView.setViewName("/sys/userList");

        return modelAndView;
    }

	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	@ResponseBody
	@NeedLogin
	public Map<String, Object> getUserInfo(int userId) {
		logger.info("to UserController Index Method...");

		Map<String, Object> result = new HashMap<String, Object>();

		UserDTO account = userService.getUserByUserId(userId);

		if (account != null) {
			result.put("success", true);
			result.put("account", account);
		} else {
			result.put("success", false);
		}

		return result;
	}
}
