package com.zlh.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.biz.PublicNumberbiz;
import com.zlh.wx.dto.PublicNumberDTO;
import com.zlh.wx.service.PublicService;

@Service
public class PublicServiceImpl implements PublicService {

	@Autowired
	private PublicNumberbiz publicNumberbiz;

	@Override
	public List<PublicNumberDTO> getPublicNumbers(PageBounds page) {
		return publicNumberbiz.getPublicNumbers(page);
	}

	@Override
	public PublicNumberDTO getPublicNumber(int creator) {
		return publicNumberbiz.getPublicNumber(creator);
	}

	@Override
	public int createPublicNumber(PublicNumberDTO publicNumberDTO) {
		return publicNumberbiz.createPublicNumber(publicNumberDTO);
	}

	@Override
	public int updatePublicNumber(PublicNumberDTO publicNumberDTO) {
		return publicNumberbiz.updatePublicNumber(publicNumberDTO);
	}

}
