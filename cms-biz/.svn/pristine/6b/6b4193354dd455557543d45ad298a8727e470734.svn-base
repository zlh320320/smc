package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.ModuleItemDao;
import com.zlh.cms.dto.ModuleItemDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类ModuleItemBiz.java的实现描述：模型字段 类实现描述 * @author zlh 2016-07-22 21:34:40
 */
@Component
public class ModuleItemBiz {
	
	@Autowired
	private ModuleItemDao moduleItemDao;
	
	public 	ModuleItemDTO getModuleItem(int id){
	      return moduleItemDao.getModuleItem(id);
	}
		
	public 	int saveModuleItem(ModuleItemDTO moduleItemDTO){
		   return moduleItemDao.saveModuleItem(moduleItemDTO);
	}
	
	public 	int updateModuleItem(ModuleItemDTO moduleItemDTO){
		  return moduleItemDao.updateModuleItem(moduleItemDTO);
	}
	
	public 	int deleteModuleItem(int id){
		  return moduleItemDao.deleteModuleItem(id);
	}
	
	public List<ModuleItemDTO> getModuleItemList(PageBounds page){
		 return moduleItemDao.getModuleItemList(page);
	}
}
