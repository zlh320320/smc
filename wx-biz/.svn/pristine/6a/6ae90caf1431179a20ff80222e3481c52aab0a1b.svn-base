package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.UserAuthDao;
import com.zlh.wx.dto.UserAuthDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;

@Component
public class UserAuthBiz {
	
	@Autowired
	private UserAuthDao userAuthDao;
	
	public 	UserAuthDTO getUserAuth(int id){
	      return userAuthDao.getUserAuth(id);
	}
		
	public 	int saveUserAuth(UserAuthDTO userAuthDTO){
		   return userAuthDao.saveUserAuth(userAuthDTO);
	}
	
	public 	int updateUserAuth(UserAuthDTO userAuthDTO){
		  return userAuthDao.updateUserAuth(userAuthDTO);
	}
	
	public 	int deleteUserAuth(int id){
		  return userAuthDao.deleteUserAuth(id);
	}
	
	public List<UserAuthDTO> getUserAuthList(PageBounds page){
		 return userAuthDao.getUserAuthList(page);
	}
}
