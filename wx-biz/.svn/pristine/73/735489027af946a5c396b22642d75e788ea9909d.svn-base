package com.zlh.wx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.wx.biz.RoleBiz;
import com.zlh.wx.service.RoleService;
import com.zlh.wx.dto.RoleDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  RoleServiceImpl implements RoleService {

	@Autowired
    private RoleBiz roleBiz;

	@Override
	public 	RoleDTO getRole(int id){
	      return roleBiz.getRole(id);
	}
		
	@Override
	public 	int saveRole(RoleDTO roleDTO){
		   return roleBiz.saveRole(roleDTO);
	}
	
	@Override
	public 	int updateRole(RoleDTO roleDTO){
		  return roleBiz.updateRole(roleDTO);
	}
	
	@Override
	public 	int deleteRole(int id){
		  return roleBiz.deleteRole(id);
	}
	
	@Override
	public List<RoleDTO> getRoleList(PageBounds page){
		 return roleBiz.getRoleList(page);
	}
}
