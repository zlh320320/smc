package com.zlh.wx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.wx.biz.UserRoleBiz;
import com.zlh.wx.service.UserRoleService;
import com.zlh.wx.dto.UserRoleDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  UserRoleServiceImpl implements UserRoleService {

	@Autowired
    private UserRoleBiz userRoleBiz;

	@Override
	public 	UserRoleDTO getUserRole(int id){
	      return userRoleBiz.getUserRole(id);
	}
		
	@Override
	public 	int saveUserRole(UserRoleDTO userRoleDTO){
		   return userRoleBiz.saveUserRole(userRoleDTO);
	}
	
	@Override
	public 	int updateUserRole(UserRoleDTO userRoleDTO){
		  return userRoleBiz.updateUserRole(userRoleDTO);
	}
	
	@Override
	public 	int deleteUserRole(int id){
		  return userRoleBiz.deleteUserRole(id);
	}
	
	@Override
	public List<UserRoleDTO> getUserRoleList(PageBounds page){
		 return userRoleBiz.getUserRoleList(page);
	}
}
