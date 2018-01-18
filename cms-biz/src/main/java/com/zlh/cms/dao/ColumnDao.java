package com.zlh.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.cms.dto.ColumnDTO;
 /**
 * * 类ColumnDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public interface ColumnDao {

		public List<ColumnDTO> getColumnList(PageBounds page,@Param("siteId") int siteId);
	
		public 	ColumnDTO getColumn(int id);
		
		public 	int saveColumn(ColumnDTO columnDTO);
		
		public 	int updateColumn(ColumnDTO columnDTO);
		
		public 	int delColumn(int id);
}
