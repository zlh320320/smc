package com.zlh.wx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.wx.biz.AuthBiz;
import com.zlh.wx.service.AuthService;
import com.zlh.wx.dto.AuthDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  AuthServiceImpl implements AuthService {

	@Autowired
    private AuthBiz authBiz;

	@Override
	public 	AuthDTO getAuth(int id){
	      return authBiz.getAuth(id);
	}
		
	@Override
	public 	int saveAuth(AuthDTO authDTO){
		   return authBiz.saveAuth(authDTO);
	}
	
	@Override
	public 	int updateAuth(AuthDTO authDTO){
		  return authBiz.updateAuth(authDTO);
	}
	
	@Override
	public 	int deleteAuth(int id){
		  return authBiz.deleteAuth(id);
	}
	
	@Override
	public List<AuthDTO> getAuthList(PageBounds page){
		 return authBiz.getAuthList(page);
	}
}
