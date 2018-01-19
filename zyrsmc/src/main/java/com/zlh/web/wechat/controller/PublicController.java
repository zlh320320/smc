package com.zlh.web.wechat.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zlh.web.front.intercepter.NeedLogin;
import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.PublicNumberDTO;
import com.zlh.wx.service.PublicService;

/**
 * 公众号相关
 * 
 * @author z
 * 
 */
@Controller
@RequestMapping("/public")
public class PublicController {
	private static Log logger = LogFactory.getLog(PublicController.class);
	private PublicService publicService = WechatServiceLocator
			.getPublicService();

	@RequestMapping(value = "/getPublicNumber", method = RequestMethod.GET)
	@NeedLogin
	public ModelAndView getPublicNumber(int creator) {
		logger.info("to getPublicNumber Method...");

		ModelAndView modelAndView = new ModelAndView();

		PublicNumberDTO publicNumberDTO = publicService
				.getPublicNumber(creator);

		modelAndView.addObject("publicNumberDTO", publicNumberDTO);
		modelAndView.setViewName("/public/publicNumberEdit");

		return modelAndView;
	}
}
