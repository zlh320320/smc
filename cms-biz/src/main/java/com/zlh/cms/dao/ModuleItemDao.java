package com.zlh.cms.dao;

import java.util.List;
import com.zlh.cms.dto.ModuleItemDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类ModuleItemDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-07-22 21:34:40
 */
public interface ModuleItemDao {

		public List<ModuleItemDTO> getModuleItemList(PageBounds page);
	
		public 	ModuleItemDTO getModuleItem(int id);
		
		public 	int saveModuleItem(ModuleItemDTO moduleItemDTO);
		
		public 	int updateModuleItem(ModuleItemDTO moduleItemDTO);
		
		public 	int deleteModuleItem(int id);
}
