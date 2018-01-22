package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.UserRoleDao;
import com.zlh.wx.dto.UserRoleDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;

@Component
public class UserRoleBiz {
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	public 	UserRoleDTO getUserRole(int id){
	      return userRoleDao.getUserRole(id);
	}
		
	public 	int saveUserRole(UserRoleDTO userRoleDTO){
		   return userRoleDao.saveUserRole(userRoleDTO);
	}
	
	public 	int updateUserRole(UserRoleDTO userRoleDTO){
		  return userRoleDao.updateUserRole(userRoleDTO);
	}
	
	public 	int deleteUserRole(int id){
		  return userRoleDao.deleteUserRole(id);
	}
	
	public List<UserRoleDTO> getUserRoleList(PageBounds page){
		 return userRoleDao.getUserRoleList(page);
	}
}
