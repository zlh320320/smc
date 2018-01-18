package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.SiteDao;
import com.zlh.cms.dto.SiteDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类SiteBiz.java的实现描述：站点表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
@Component
public class SiteBiz {
	
	@Autowired
	private SiteDao siteDao;
	
	public 	SiteDTO getSite(int id){
	      return siteDao.getSite(id);
	}
		
	public 	int saveSite(SiteDTO siteDTO){
		   return siteDao.saveSite(siteDTO);
	}
	
	public 	int updateSite(SiteDTO siteDTO){
		  return siteDao.updateSite(siteDTO);
	}
	
	public 	int deleteSite(int id){
		  return siteDao.deleteSite(id);
	}
	
	public List<SiteDTO> getSiteList(PageBounds page){
		 return siteDao.getSiteList(page);
	}
}
