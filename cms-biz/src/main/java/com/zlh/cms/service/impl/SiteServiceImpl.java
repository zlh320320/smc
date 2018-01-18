package com.zlh.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.cms.biz.SiteBiz;
import com.zlh.cms.service.SiteService;
import com.zlh.cms.dto.SiteDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  SiteServiceImpl implements SiteService {

	@Autowired
    private SiteBiz siteBiz;

	@Override
	public 	SiteDTO getSite(int id){
	      return siteBiz.getSite(id);
	}
		
	@Override
	public 	int saveSite(SiteDTO siteDTO){
		   return siteBiz.saveSite(siteDTO);
	}
	
	@Override
	public 	int updateSite(SiteDTO siteDTO){
		  return siteBiz.updateSite(siteDTO);
	}
	
	@Override
	public 	int deleteSite(int id){
		  return siteBiz.deleteSite(id);
	}
	
	@Override
	public List<SiteDTO> getSiteList(PageBounds page){
		 return siteBiz.getSiteList(page);
	}
}
