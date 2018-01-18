package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.SiteLogoDao;
import com.zlh.cms.dto.SiteLogoDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类SiteLogoBiz.java的实现描述：站点logo表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
@Component
public class SiteLogoBiz {
	
	@Autowired
	private SiteLogoDao siteLogoDao;
	
	public 	SiteLogoDTO getSiteLogo(int id){
	      return siteLogoDao.getSiteLogo(id);
	}
		
	public 	int saveSiteLogo(SiteLogoDTO siteLogoDTO){
		   return siteLogoDao.saveSiteLogo(siteLogoDTO);
	}
	
	public 	int updateSiteLogo(SiteLogoDTO siteLogoDTO){
		  return siteLogoDao.updateSiteLogo(siteLogoDTO);
	}
	
	public 	int deleteSiteLogo(int id){
		  return siteLogoDao.deleteSiteLogo(id);
	}
	
	public List<SiteLogoDTO> getSiteLogoList(PageBounds page){
		 return siteLogoDao.getSiteLogoList(page);
	}
}
