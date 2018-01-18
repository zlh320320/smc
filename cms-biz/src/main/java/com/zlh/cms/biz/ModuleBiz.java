package com.zlh.cms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.cms.dao.ModuleDao;
import com.zlh.cms.dto.ModuleDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类ModuleBiz.java的实现描述：字段模型表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
@Component
public class ModuleBiz {
	
	@Autowired
	private ModuleDao moduleDao;
	
	public 	ModuleDTO getModule(int id){
	      return moduleDao.getModule(id);
	}
		
	public 	int saveModule(ModuleDTO moduleDTO){
		   return moduleDao.saveModule(moduleDTO);
	}
	
	public 	int updateModule(ModuleDTO moduleDTO){
		  return moduleDao.updateModule(moduleDTO);
	}
	
	public 	int deleteModule(int id){
		  return moduleDao.deleteModule(id);
	}
	
	public List<ModuleDTO> getModuleList(PageBounds page){
		 return moduleDao.getModuleList(page);
	}
}
