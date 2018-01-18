package com.zlh.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.cms.biz.ModuleBiz;
import com.zlh.cms.service.ModuleService;
import com.zlh.cms.dto.ModuleDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  ModuleServiceImpl implements ModuleService {

	@Autowired
    private ModuleBiz moduleBiz;

	@Override
	public 	ModuleDTO getModule(int id){
	      return moduleBiz.getModule(id);
	}
		
	@Override
	public 	int saveModule(ModuleDTO moduleDTO){
		   return moduleBiz.saveModule(moduleDTO);
	}
	
	@Override
	public 	int updateModule(ModuleDTO moduleDTO){
		  return moduleBiz.updateModule(moduleDTO);
	}
	
	@Override
	public 	int deleteModule(int id){
		  return moduleBiz.deleteModule(id);
	}
	
	@Override
	public List<ModuleDTO> getModuleList(PageBounds page){
		 return moduleBiz.getModuleList(page);
	}
}
