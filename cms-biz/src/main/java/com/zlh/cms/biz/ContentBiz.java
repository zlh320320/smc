package com.zlh.cms.biz;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlh.cms.dao.ContentDao;
import com.zlh.cms.dto.ContentDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
 /**
 * * 类ContentBiz.java的实现描述：新闻内容表 类实现描述 * @author zlh 2016-07-22 21:34:38
 */
@Component
public class ContentBiz {
	
	@Autowired
	private ContentDao contentDao;
	
	public 	ContentDTO getContent(int id){
	      return contentDao.getContent(id);
	}
		
	public 	int saveContent(ContentDTO contentDTO){
		   return contentDao.saveContent(contentDTO);
	}
	
	public 	int updateContent(ContentDTO contentDTO){
		  return contentDao.updateContent(contentDTO);
	}
	
	public 	int deleteContent(int id){
		  return contentDao.delContent(id);
	}
	
	public List<ContentDTO> getContentList(PageBounds page,Integer columnId){
		 return contentDao.getContentList(page,columnId);
	}
	
	public List<ContentDTO> searchContents(PageBounds page,@Param("title")String title){
	    return contentDao.searchContents(page, title);
	}
}
