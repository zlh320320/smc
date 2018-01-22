package com.zlh.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dto.UserDTO;

public interface UserDao {

    public UserDTO getUserByUserId(@Param("userId") int userId);

    public UserDTO getUserByUserName(@Param("username") String username);

    public List<UserDTO> getUserList(PageBounds page,@Param("realName") String realName);

    public int createUser(UserDTO userDTO);

    public int updateUser(UserDTO userDTO);

    public int updateUserByFlag(@Param("userId") int userId, @Param("delFlag") int delFlag);

    public int deleteUser(int userId);
    
    public List<UserDTO> getLatestUserList(PageBounds page, @Param("realName")String realName);
    
    public List<UserDTO> getLatestLoginUser(PageBounds page);
}
