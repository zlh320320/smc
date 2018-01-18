package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.ContentFileDao;
import com.zlh.cms.dto.ContentFileDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类ContentFileBiz.java的实现描述：新闻附件表 类实现描述 * @author zlh 2016-07-22 21:34:40
 */
@Component
public class ContentFileBiz {
	
	@Autowired
	private ContentFileDao contentFileDao;
	
	public 	ContentFileDTO getContentFile(int id){
	      return contentFileDao.getContentFile(id);
	}
		
	public 	int saveContentFile(ContentFileDTO contentFileDTO){
		   return contentFileDao.saveContentFile(contentFileDTO);
	}
	
	public 	int updateContentFile(ContentFileDTO contentFileDTO){
		  return contentFileDao.updateContentFile(contentFileDTO);
	}
	
	public 	int deleteContentFile(int id){
		  return contentFileDao.deleteContentFile(id);
	}
	
	public List<ContentFileDTO> getContentFileList(PageBounds page){
		 return contentFileDao.getContentFileList(page);
	}
}
