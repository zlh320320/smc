package com.zlh.wx.dao;

import java.util.List;
import com.zlh.wx.dto.UserRoleDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface UserRoleDao {

		public List<UserRoleDTO> getUserRoleList(PageBounds page);
	
		public 	UserRoleDTO getUserRole(int id);
		
		public 	int saveUserRole(UserRoleDTO userRoleDTO);
		
		public 	int updateUserRole(UserRoleDTO userRoleDTO);
		
		public 	int deleteUserRole(int id);
}
