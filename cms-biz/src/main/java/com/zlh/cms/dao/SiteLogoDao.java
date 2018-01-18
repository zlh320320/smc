package com.zlh.cms.dao;

import java.util.List;
import com.zlh.cms.dto.SiteLogoDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类SiteLogoDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface SiteLogoDao {

		public List<SiteLogoDTO> getSiteLogoList(PageBounds page);
	
		public 	SiteLogoDTO getSiteLogo(int id);
		
		public 	int saveSiteLogo(SiteLogoDTO siteLogoDTO);
		
		public 	int updateSiteLogo(SiteLogoDTO siteLogoDTO);
		
		public 	int deleteSiteLogo(int id);
}
