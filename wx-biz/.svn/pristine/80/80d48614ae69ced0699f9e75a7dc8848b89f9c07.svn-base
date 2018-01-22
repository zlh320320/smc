package com.zlh.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlh.wx.biz.LoginLogBiz;
import com.zlh.wx.service.LoginLogService;
import com.zlh.wx.dto.LoginLogDTO;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  LoginLogServiceImpl implements LoginLogService {

	@Autowired
    private LoginLogBiz loginLogBiz;

	@Override
	public 	LoginLogDTO getLoginLog(int id){
	      return loginLogBiz.getLoginLog(id);
	}
		
	@Override
	public 	int saveLoginLog(LoginLogDTO loginLogDTO){
		   return loginLogBiz.saveLoginLog(loginLogDTO);
	}
	
	@Override
	public 	int updateLoginLog(LoginLogDTO loginLogDTO){
		  return loginLogBiz.updateLoginLog(loginLogDTO);
	}
	
	@Override
	public 	int deleteLoginLog(int id){
		  return loginLogBiz.deleteLoginLog(id);
	}
	
	@Override
	public List<LoginLogDTO> getLoginLogList(PageBounds page,Integer type){
		 return loginLogBiz.getLoginLogList(page,type);
	}
}
