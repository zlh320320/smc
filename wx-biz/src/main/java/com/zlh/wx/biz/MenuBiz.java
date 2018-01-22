package com.zlh.wx.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlh.wx.dao.MenuDao;
import com.zlh.wx.dto.MenuDTO;
@Component
public class MenuBiz {
	@Autowired
	private MenuDao menuDao;
	
	public List<MenuDTO> getAllMenus(){
		List<MenuDTO> menuList=menuDao.getAllMenus();
		return menuList;
	}
}
