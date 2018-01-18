package com.zlh.cms.service;

import com.zlh.cms.dto.ColumnDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类ColumnService.java的实现描述：网站栏目表实现接口 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface ColumnService {

		public List<ColumnDTO> getColumnList(PageBounds page,int siteId);
	
		public 	ColumnDTO getColumn(int id);
		
		public 	int saveColumn(ColumnDTO columnDTO);
		
		public 	int updateColumn(ColumnDTO columnDTO);
		
		public 	int deleteColumn(int id);
}
