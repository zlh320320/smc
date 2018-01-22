package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.RoleAuthDao;
import com.zlh.wx.dto.RoleAuthDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;

@Component
public class RoleAuthBiz {
	
	@Autowired
	private RoleAuthDao roleAuthDao;
	
	public 	RoleAuthDTO getRoleAuth(int id){
	      return roleAuthDao.getRoleAuth(id);
	}
		
	public 	int saveRoleAuth(RoleAuthDTO roleAuthDTO){
		   return roleAuthDao.saveRoleAuth(roleAuthDTO);
	}
	
	public 	int updateRoleAuth(RoleAuthDTO roleAuthDTO){
		  return roleAuthDao.updateRoleAuth(roleAuthDTO);
	}
	
	public 	int deleteRoleAuth(int id){
		  return roleAuthDao.deleteRoleAuth(id);
	}
	
	public List<RoleAuthDTO> getRoleAuthList(PageBounds page){
		 return roleAuthDao.getRoleAuthList(page);
	}
}
