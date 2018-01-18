package com.zlh.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.cms.biz.SiteMarkBiz;
import com.zlh.cms.service.SiteMarkService;
import com.zlh.cms.dto.SiteMarkDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  SiteMarkServiceImpl implements SiteMarkService {

	@Autowired
    private SiteMarkBiz siteMarkBiz;

	@Override
	public 	SiteMarkDTO getSiteMark(int id){
	      return siteMarkBiz.getSiteMark(id);
	}
		
	@Override
	public 	int saveSiteMark(SiteMarkDTO siteMarkDTO){
		   return siteMarkBiz.saveSiteMark(siteMarkDTO);
	}
	
	@Override
	public 	int updateSiteMark(SiteMarkDTO siteMarkDTO){
		  return siteMarkBiz.updateSiteMark(siteMarkDTO);
	}
	
	@Override
	public 	int deleteSiteMark(int id){
		  return siteMarkBiz.deleteSiteMark(id);
	}
	
	@Override
	public List<SiteMarkDTO> getSiteMarkList(PageBounds page){
		 return siteMarkBiz.getSiteMarkList(page);
	}
}
