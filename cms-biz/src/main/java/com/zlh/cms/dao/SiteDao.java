package com.zlh.cms.dao;

import java.util.List;
import com.zlh.cms.dto.SiteDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类SiteDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface SiteDao {

		public List<SiteDTO> getSiteList(PageBounds page);
	
		public 	SiteDTO getSite(int id);
		
		public 	int saveSite(SiteDTO siteDTO);
		
		public 	int updateSite(SiteDTO siteDTO);
		
		public 	int deleteSite(int id);
}
