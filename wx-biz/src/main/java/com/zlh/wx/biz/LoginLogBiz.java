package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.LoginLogDao;
import com.zlh.wx.dto.LoginLogDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类LoginLogBiz.java的实现描述：登陆日志 类实现描述 * @author zlh 2016-11-27 16:52:14
 */
@Component
public class LoginLogBiz {
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public 	LoginLogDTO getLoginLog(int id){
	      return loginLogDao.getLoginLog(id);
	}
		
	public 	int saveLoginLog(LoginLogDTO loginLogDTO){
		   return loginLogDao.saveLoginLog(loginLogDTO);
	}
	
	public 	int updateLoginLog(LoginLogDTO loginLogDTO){
		  return loginLogDao.updateLoginLog(loginLogDTO);
	}
	
	public 	int deleteLoginLog(int id){
		  return loginLogDao.deleteLoginLog(id);
	}
	
	public List<LoginLogDTO> getLoginLogList(PageBounds page,Integer type){
		 return loginLogDao.getLoginLogList(page,type);
	}
}
