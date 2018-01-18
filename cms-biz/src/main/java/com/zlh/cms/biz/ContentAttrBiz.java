package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.ContentAttrDao;
import com.zlh.cms.dto.ContentAttrDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类ContentAttrBiz.java的实现描述：新闻内容扩展字段 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
@Component
public class ContentAttrBiz {
	
	@Autowired
	private ContentAttrDao contentAttrDao;
	
	public 	ContentAttrDTO getContentAttr(int id){
	      return contentAttrDao.getContentAttr(id);
	}
		
	public 	int saveContentAttr(ContentAttrDTO contentAttrDTO){
		   return contentAttrDao.saveContentAttr(contentAttrDTO);
	}
	
	public 	int updateContentAttr(ContentAttrDTO contentAttrDTO){
		  return contentAttrDao.updateContentAttr(contentAttrDTO);
	}
	
	public 	int deleteContentAttr(int id){
		  return contentAttrDao.deleteContentAttr(id);
	}
	
	public List<ContentAttrDTO> getContentAttrList(PageBounds page){
		 return contentAttrDao.getContentAttrList(page);
	}
}
