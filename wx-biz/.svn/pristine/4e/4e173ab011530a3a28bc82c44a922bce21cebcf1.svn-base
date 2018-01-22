package com.zlh.wx.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dto.UserDTO;

public interface UserService {
	public UserDTO getUserByUserId(int userId);
	
	public UserDTO getUserByUserName(String username);

	public List<UserDTO> getUserList(PageBounds page, String realName);

	public int createUser(UserDTO userDTO);

	public int updateUser(UserDTO userDTO);

	public int updateUserByFlag(int userId, int delFlag);

	public int deleteUser(int userId);
	
    public List<UserDTO> getLatestUserList(PageBounds page, String realName);
    
    public List<UserDTO> getLatestLoginUser(PageBounds page);
}
