package com.zlh.cms.service;

import com.zlh.cms.dto.ContentDTO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类ContentService.java的实现描述：新闻内容表实现接口 类实现描述 * @author zlh 2016-07-22 21:34:38
 */
public interface ContentService {

		public List<ContentDTO> getContentList(PageBounds page,Integer columnId);
	
		public 	ContentDTO getContent(int id);
		
		public 	int saveContent(ContentDTO contentDTO);
		
		public 	int updateContent(ContentDTO contentDTO);
		
		public 	int deleteContent(int id);
		
		public List<ContentDTO> searchContents(PageBounds page,@Param("title")String title);
}
