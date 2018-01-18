package com.zlh.cms.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlh.cms.biz.ContentBiz;
import com.zlh.cms.service.ContentService;
import com.zlh.cms.dto.ContentDTO;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  ContentServiceImpl implements ContentService {

	@Autowired
    private ContentBiz contentBiz;

	@Override
	public 	ContentDTO getContent(int id){
	      return contentBiz.getContent(id);
	}
		
	@Override
	public 	int saveContent(ContentDTO contentDTO){
		   return contentBiz.saveContent(contentDTO);
	}
	
	@Override
	public 	int updateContent(ContentDTO contentDTO){
		  return contentBiz.updateContent(contentDTO);
	}
	
	@Override
	public 	int deleteContent(int id){
		  return contentBiz.deleteContent(id);
	}
	
	@Override
	public List<ContentDTO> getContentList(PageBounds page,Integer columnId){
		 return contentBiz.getContentList(page,columnId);
	}
	
	public List<ContentDTO> searchContents(PageBounds page,@Param("title")String title){
        return contentBiz.searchContents(page, title);
    }
}
