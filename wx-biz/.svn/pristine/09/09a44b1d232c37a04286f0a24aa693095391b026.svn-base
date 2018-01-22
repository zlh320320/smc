package com.zlh.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlh.wx.biz.MenuBiz;
import com.zlh.wx.dto.MenuDTO;
import com.zlh.wx.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuBiz menuBiz;
	
	@Override
	public List<MenuDTO> getAllMenus() {
		return menuBiz.getAllMenus();
	}

}
