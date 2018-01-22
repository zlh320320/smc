package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.RoleDao;
import com.zlh.wx.dto.RoleDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;

@Component
public class RoleBiz {
	
	@Autowired
	private RoleDao roleDao;
	
	public 	RoleDTO getRole(int id){
	      return roleDao.getRole(id);
	}
		
	public 	int saveRole(RoleDTO roleDTO){
		   return roleDao.saveRole(roleDTO);
	}
	
	public 	int updateRole(RoleDTO roleDTO){
		  return roleDao.updateRole(roleDTO);
	}
	
	public 	int deleteRole(int id){
		  return roleDao.deleteRole(id);
	}
	
	public List<RoleDTO> getRoleList(PageBounds page){
		 return roleDao.getRoleList(page);
	}
}
