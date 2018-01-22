package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.AuthDao;
import com.zlh.wx.dto.AuthDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
/**
* * 类${className}DTO.java的实现描述：//TODO 类实现描述 * @author zlh ${nowDate}
*/
@Component
public class AuthBiz {
	
	@Autowired
	private AuthDao authDao;
	
	public 	AuthDTO getAuth(int id){
	      return authDao.getAuth(id);
	}
		
	public 	int saveAuth(AuthDTO authDTO){
		   return authDao.saveAuth(authDTO);
	}
	
	public 	int updateAuth(AuthDTO authDTO){
		  return authDao.updateAuth(authDTO);
	}
	
	public 	int deleteAuth(int id){
		  return authDao.deleteAuth(id);
	}
	
	public List<AuthDTO> getAuthList(PageBounds page){
		 return authDao.getAuthList(page);
	}
}
