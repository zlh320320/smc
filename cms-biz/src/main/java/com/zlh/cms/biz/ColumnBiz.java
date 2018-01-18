package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.ColumnDao;
import com.zlh.cms.dto.ColumnDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类ColumnBiz.java的实现描述：网站栏目表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
@Component
public class ColumnBiz {
	
	@Autowired
	private ColumnDao columnDao;
	
	public 	ColumnDTO getColumn(int id){
	      return columnDao.getColumn(id);
	}
		
	public 	int saveColumn(ColumnDTO columnDTO){
		   return columnDao.saveColumn(columnDTO);
	}
	
	public 	int updateColumn(ColumnDTO columnDTO){
		  return columnDao.updateColumn(columnDTO);
	}
	
	public 	int deleteColumn(int id){
		  return columnDao.delColumn(id);
	}
	
	public List<ColumnDTO> getColumnList(PageBounds page,int siteId){
		 return columnDao.getColumnList(page,siteId);
	}
}
