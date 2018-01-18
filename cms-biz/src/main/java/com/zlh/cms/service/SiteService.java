package com.zlh.cms.service;

import com.zlh.cms.dto.SiteDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类SiteService.java的实现描述：站点表实现接口 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface SiteService {

		public List<SiteDTO> getSiteList(PageBounds page);
	
		public 	SiteDTO getSite(int id);
		
		public 	int saveSite(SiteDTO siteDTO);
		
		public 	int updateSite(SiteDTO siteDTO);
		
		public 	int deleteSite(int id);
}
