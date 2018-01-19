package com.zlh.web.wechat.common;

import java.util.List;

import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.MenuDTO;
import com.zlh.wx.service.MenuService;

public class MenuUtils {

	private final static MenuService menuService = WechatServiceLocator
			.getMenuService();

	public static List<MenuDTO> getMenus() {
		return menuService.getAllMenus();
	}
}
