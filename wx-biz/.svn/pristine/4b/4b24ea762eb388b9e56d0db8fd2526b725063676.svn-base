package com.zlh.wx.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dao.PublicNumberDao;
import com.zlh.wx.dto.PublicNumberDTO;

@Component
public class PublicNumberbiz {

	@Autowired
	private PublicNumberDao publicNumberDao;

	public List<PublicNumberDTO> getPublicNumbers(PageBounds page) {
		return publicNumberDao.getPublicNumbers(page);
	}

	public PublicNumberDTO getPublicNumber(int creator) {
		return publicNumberDao.getPublicNumber(creator);
	}

	public int createPublicNumber(PublicNumberDTO publicNumberDTO) {
		return publicNumberDao.createPublicNumber(publicNumberDTO);
	}

	public int updatePublicNumber(PublicNumberDTO publicNumberDTO) {
		return publicNumberDao.updatePublicNumber(publicNumberDTO);
	}
}
