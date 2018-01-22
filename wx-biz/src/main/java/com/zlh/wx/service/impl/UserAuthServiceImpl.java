package com.zlh.wx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.wx.biz.UserAuthBiz;
import com.zlh.wx.service.UserAuthService;
import com.zlh.wx.dto.UserAuthDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  UserAuthServiceImpl implements UserAuthService {

	@Autowired
    private UserAuthBiz userAuthBiz;

	@Override
	public 	UserAuthDTO getUserAuth(int id){
	      return userAuthBiz.getUserAuth(id);
	}
		
	@Override
	public 	int saveUserAuth(UserAuthDTO userAuthDTO){
		   return userAuthBiz.saveUserAuth(userAuthDTO);
	}
	
	@Override
	public 	int updateUserAuth(UserAuthDTO userAuthDTO){
		  return userAuthBiz.updateUserAuth(userAuthDTO);
	}
	
	@Override
	public 	int deleteUserAuth(int id){
		  return userAuthBiz.deleteUserAuth(id);
	}
	
	@Override
	public List<UserAuthDTO> getUserAuthList(PageBounds page){
		 return userAuthBiz.getUserAuthList(page);
	}
}
