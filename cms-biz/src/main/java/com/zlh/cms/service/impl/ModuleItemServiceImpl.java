package com.zlh.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.cms.biz.ModuleItemBiz;
import com.zlh.cms.service.ModuleItemService;
import com.zlh.cms.dto.ModuleItemDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  ModuleItemServiceImpl implements ModuleItemService {

	@Autowired
    private ModuleItemBiz moduleItemBiz;

	@Override
	public 	ModuleItemDTO getModuleItem(int id){
	      return moduleItemBiz.getModuleItem(id);
	}
		
	@Override
	public 	int saveModuleItem(ModuleItemDTO moduleItemDTO){
		   return moduleItemBiz.saveModuleItem(moduleItemDTO);
	}
	
	@Override
	public 	int updateModuleItem(ModuleItemDTO moduleItemDTO){
		  return moduleItemBiz.updateModuleItem(moduleItemDTO);
	}
	
	@Override
	public 	int deleteModuleItem(int id){
		  return moduleItemBiz.deleteModuleItem(id);
	}
	
	@Override
	public List<ModuleItemDTO> getModuleItemList(PageBounds page){
		 return moduleItemBiz.getModuleItemList(page);
	}
}
