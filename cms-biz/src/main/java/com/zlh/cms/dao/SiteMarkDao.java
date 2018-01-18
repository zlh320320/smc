package com.zlh.cms.dao;

import java.util.List;
import com.zlh.cms.dto.SiteMarkDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类SiteMarkDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface SiteMarkDao {

		public List<SiteMarkDTO> getSiteMarkList(PageBounds page);
	
		public 	SiteMarkDTO getSiteMark(int id);
		
		public 	int saveSiteMark(SiteMarkDTO siteMarkDTO);
		
		public 	int updateSiteMark(SiteMarkDTO siteMarkDTO);
		
		public 	int deleteSiteMark(int id);
}
