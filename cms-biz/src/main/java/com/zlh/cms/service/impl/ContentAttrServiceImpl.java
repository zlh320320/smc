package com.zlh.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.cms.biz.ContentAttrBiz;
import com.zlh.cms.service.ContentAttrService;
import com.zlh.cms.dto.ContentAttrDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  ContentAttrServiceImpl implements ContentAttrService {

	@Autowired
    private ContentAttrBiz contentAttrBiz;

	@Override
	public 	ContentAttrDTO getContentAttr(int id){
	      return contentAttrBiz.getContentAttr(id);
	}
		
	@Override
	public 	int saveContentAttr(ContentAttrDTO contentAttrDTO){
		   return contentAttrBiz.saveContentAttr(contentAttrDTO);
	}
	
	@Override
	public 	int updateContentAttr(ContentAttrDTO contentAttrDTO){
		  return contentAttrBiz.updateContentAttr(contentAttrDTO);
	}
	
	@Override
	public 	int deleteContentAttr(int id){
		  return contentAttrBiz.deleteContentAttr(id);
	}
	
	@Override
	public List<ContentAttrDTO> getContentAttrList(PageBounds page){
		 return contentAttrBiz.getContentAttrList(page);
	}
}
