package com.zlh.cms.dao;

import java.util.List;
import com.zlh.cms.dto.ContentFileDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类ContentFileDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-07-22 21:34:40
 */
public interface ContentFileDao {

		public List<ContentFileDTO> getContentFileList(PageBounds page);
	
		public 	ContentFileDTO getContentFile(int id);
		
		public 	int saveContentFile(ContentFileDTO contentFileDTO);
		
		public 	int updateContentFile(ContentFileDTO contentFileDTO);
		
		public 	int deleteContentFile(int id);
}
