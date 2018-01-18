package com.zlh.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.cms.biz.ContentFileBiz;
import com.zlh.cms.service.ContentFileService;
import com.zlh.cms.dto.ContentFileDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  ContentFileServiceImpl implements ContentFileService {

	@Autowired
    private ContentFileBiz contentFileBiz;

	@Override
	public 	ContentFileDTO getContentFile(int id){
	      return contentFileBiz.getContentFile(id);
	}
		
	@Override
	public 	int saveContentFile(ContentFileDTO contentFileDTO){
		   return contentFileBiz.saveContentFile(contentFileDTO);
	}
	
	@Override
	public 	int updateContentFile(ContentFileDTO contentFileDTO){
		  return contentFileBiz.updateContentFile(contentFileDTO);
	}
	
	@Override
	public 	int deleteContentFile(int id){
		  return contentFileBiz.deleteContentFile(id);
	}
	
	@Override
	public List<ContentFileDTO> getContentFileList(PageBounds page){
		 return contentFileBiz.getContentFileList(page);
	}
}
