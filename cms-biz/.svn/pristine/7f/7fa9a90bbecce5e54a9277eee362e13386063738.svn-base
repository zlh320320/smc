package com.zlh.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.cms.biz.SiteLogoBiz;
import com.zlh.cms.service.SiteLogoService;
import com.zlh.cms.dto.SiteLogoDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  SiteLogoServiceImpl implements SiteLogoService {

	@Autowired
    private SiteLogoBiz siteLogoBiz;

	@Override
	public 	SiteLogoDTO getSiteLogo(int id){
	      return siteLogoBiz.getSiteLogo(id);
	}
		
	@Override
	public 	int saveSiteLogo(SiteLogoDTO siteLogoDTO){
		   return siteLogoBiz.saveSiteLogo(siteLogoDTO);
	}
	
	@Override
	public 	int updateSiteLogo(SiteLogoDTO siteLogoDTO){
		  return siteLogoBiz.updateSiteLogo(siteLogoDTO);
	}
	
	@Override
	public 	int deleteSiteLogo(int id){
		  return siteLogoBiz.deleteSiteLogo(id);
	}
	
	@Override
	public List<SiteLogoDTO> getSiteLogoList(PageBounds page){
		 return siteLogoBiz.getSiteLogoList(page);
	}
}
