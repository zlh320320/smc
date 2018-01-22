package com.zlh.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.biz.UserBiz;
import com.zlh.wx.dto.UserDTO;
import com.zlh.wx.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBiz userBiz;

    @Override
    public UserDTO getUserByUserId(int userId) {
        return userBiz.getUserByUserId(userId);
    }

    @Override
    public List<UserDTO> getUserList(PageBounds page, String realName) {
        return userBiz.getUserList(page, realName);
    }

    @Override
    public int createUser(UserDTO userDTO) {
        return userBiz.createUser(userDTO);
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        return userBiz.updateUser(userDTO);
    }

    @Override
    public int updateUserByFlag(int userId, int delFlag) {
        return userBiz.updateUserByFlag(userId, delFlag);
    }

    @Override
    public int deleteUser(int userId) {
        return userBiz.deleteUser(userId);
    }

    @Override
    public UserDTO getUserByUserName(String username) {
        return userBiz.getUserByUserName(username);
    }

    @Override
    public List<UserDTO> getLatestUserList(PageBounds page, String realName) {
        return userBiz.getLatestUserList(page, realName);
    }
    @Override
    public List<UserDTO> getLatestLoginUser(PageBounds page){
        return userBiz.getLatestLoginUser(page);
    }
}
