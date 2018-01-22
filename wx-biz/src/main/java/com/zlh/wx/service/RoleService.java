package com.zlh.wx.service;

import com.zlh.wx.dto.RoleDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface RoleService {

		public List<RoleDTO> getRoleList(PageBounds page);
	
		public 	RoleDTO getRole(int id);
		
		public 	int saveRole(RoleDTO roleDTO);
		
		public 	int updateRole(RoleDTO roleDTO);
		
		public 	int deleteRole(int id);
}
