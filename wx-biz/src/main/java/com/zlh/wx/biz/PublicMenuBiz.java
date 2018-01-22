package com.zlh.wx.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zlh.wx.dao.PublicMenuDao;
import com.zlh.wx.dto.PublicMenuDTO;

public class PublicMenuBiz {

	@Autowired
	private PublicMenuDao publicMenuDao;

	public List<PublicMenuDTO> getPublicMenus(int publicId) {
		return publicMenuDao.getPublicMenus(publicId);
	}

	public PublicMenuDTO getPublicMenu(int id) {
		return publicMenuDao.getPublicMenu(id);
	}

	public int createPublicMenu(PublicMenuDTO publicMenuDTO) {
		return publicMenuDao.createPublicMenu(publicMenuDTO);
	}

	public int updatePublicMenu(PublicMenuDTO publicMenuDTO) {
		return publicMenuDao.updatePublicMenu(publicMenuDTO);
	}

	public int updateByDelFlag(int id, int delflag) {
		return publicMenuDao.updateByDelFlag(id, delflag);
	}

}
