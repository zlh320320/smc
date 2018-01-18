package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.SiteMarkDao;
import com.zlh.cms.dto.SiteMarkDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类SiteMarkBiz.java的实现描述：站点水印表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
@Component
public class SiteMarkBiz {
	
	@Autowired
	private SiteMarkDao siteMarkDao;
	
	public 	SiteMarkDTO getSiteMark(int id){
	      return siteMarkDao.getSiteMark(id);
	}
		
	public 	int saveSiteMark(SiteMarkDTO siteMarkDTO){
		   return siteMarkDao.saveSiteMark(siteMarkDTO);
	}
	
	public 	int updateSiteMark(SiteMarkDTO siteMarkDTO){
		  return siteMarkDao.updateSiteMark(siteMarkDTO);
	}
	
	public 	int deleteSiteMark(int id){
		  return siteMarkDao.deleteSiteMark(id);
	}
	
	public List<SiteMarkDTO> getSiteMarkList(PageBounds page){
		 return siteMarkDao.getSiteMarkList(page);
	}
}
