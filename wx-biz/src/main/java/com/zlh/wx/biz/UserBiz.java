package com.zlh.wx.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dao.UserDao;
import com.zlh.wx.dto.UserDTO;

@Component
public class UserBiz {

//	CacheClientForRedis clientForRedis = CacheServiceLocator
//			.getCacheClientRedis();

	@Autowired
	private UserDao userDao;

	public UserDTO getUserByUserId(int userId) {
	    return userDao.getUserByUserId(userId);
		/*UserDTO user = (UserDTO) clientForRedis.get(
				CacheKey.USER_INFO + userId, UserDTO.class);
		if (user == null) {
			user = userDao.getUserByUserId(userId);
			clientForRedis.put(CacheKey.USER_INFO + userId, user);
		}
		return user;*/
	}

	public UserDTO getUserByUserName(String username) {
	    return userDao.getUserByUserName(username);
	}
	
	public List<UserDTO> getUserList(PageBounds page, String realName) {
		return userDao.getUserList(page, realName);
	}

	public int createUser(UserDTO userDTO) {
		return userDao.createUser(userDTO);
	}

	public int updateUser(UserDTO userDTO) {
		return userDao.updateUser(userDTO);
	}

	public int updateUserByFlag(int userId, int delFlag) {
		return userDao.updateUserByFlag(userId, delFlag);
	}

	public int deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

	public List<UserDTO> getLatestUserList(PageBounds page, String realName){
	    return userDao.getLatestUserList(page, realName);
	}
	
	public List<UserDTO> getLatestLoginUser(PageBounds page){
	    return userDao.getLatestLoginUser(page);
	}
}
