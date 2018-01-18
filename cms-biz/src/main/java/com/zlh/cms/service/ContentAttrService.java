package com.zlh.cms.service;

import com.zlh.cms.dto.ContentAttrDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类ContentAttrService.java的实现描述：新闻内容扩展字段实现接口 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface ContentAttrService {

		public List<ContentAttrDTO> getContentAttrList(PageBounds page);
	
		public 	ContentAttrDTO getContentAttr(int id);
		
		public 	int saveContentAttr(ContentAttrDTO contentAttrDTO);
		
		public 	int updateContentAttr(ContentAttrDTO contentAttrDTO);
		
		public 	int deleteContentAttr(int id);
}
