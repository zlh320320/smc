package com.zlh.cms.service;

import com.zlh.cms.dto.SiteLogoDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类SiteLogoService.java的实现描述：站点logo表实现接口 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface SiteLogoService {

		public List<SiteLogoDTO> getSiteLogoList(PageBounds page);
	
		public 	SiteLogoDTO getSiteLogo(int id);
		
		public 	int saveSiteLogo(SiteLogoDTO siteLogoDTO);
		
		public 	int updateSiteLogo(SiteLogoDTO siteLogoDTO);
		
		public 	int deleteSiteLogo(int id);
}
