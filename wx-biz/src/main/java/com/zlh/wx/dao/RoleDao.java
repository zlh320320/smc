package com.zlh.wx.dao;

import java.util.List;
import com.zlh.wx.dto.RoleDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface RoleDao {

		public List<RoleDTO> getRoleList(PageBounds page);
	
		public 	RoleDTO getRole(int id);
		
		public 	int saveRole(RoleDTO roleDTO);
		
		public 	int updateRole(RoleDTO roleDTO);
		
		public 	int deleteRole(int id);
}
