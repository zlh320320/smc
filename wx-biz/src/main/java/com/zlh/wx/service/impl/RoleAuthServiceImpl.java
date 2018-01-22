package com.zlh.wx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.wx.biz.RoleAuthBiz;
import com.zlh.wx.service.RoleAuthService;
import com.zlh.wx.dto.RoleAuthDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  RoleAuthServiceImpl implements RoleAuthService {

	@Autowired
    private RoleAuthBiz roleAuthBiz;

	@Override
	public 	RoleAuthDTO getRoleAuth(int id){
	      return roleAuthBiz.getRoleAuth(id);
	}
		
	@Override
	public 	int saveRoleAuth(RoleAuthDTO roleAuthDTO){
		   return roleAuthBiz.saveRoleAuth(roleAuthDTO);
	}
	
	@Override
	public 	int updateRoleAuth(RoleAuthDTO roleAuthDTO){
		  return roleAuthBiz.updateRoleAuth(roleAuthDTO);
	}
	
	@Override
	public 	int deleteRoleAuth(int id){
		  return roleAuthBiz.deleteRoleAuth(id);
	}
	
	@Override
	public List<RoleAuthDTO> getRoleAuthList(PageBounds page){
		 return roleAuthBiz.getRoleAuthList(page);
	}
}
