package com.zlh.cms.service;

import com.zlh.cms.dto.ContentFileDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类ContentFileService.java的实现描述：新闻附件表实现接口 类实现描述 * @author zlh 2016-07-22 21:34:40
 */
public interface ContentFileService {

		public List<ContentFileDTO> getContentFileList(PageBounds page);
	
		public 	ContentFileDTO getContentFile(int id);
		
		public 	int saveContentFile(ContentFileDTO contentFileDTO);
		
		public 	int updateContentFile(ContentFileDTO contentFileDTO);
		
		public 	int deleteContentFile(int id);
}
