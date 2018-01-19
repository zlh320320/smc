package com.zlh.web.utils;

import javax.servlet.http.HttpServletRequest;

import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.SystemParamDTO;
import com.zlh.wx.dto.UserDTO;
import com.zlh.wx.service.SystemParamService;
import com.zlh.wx.service.UserService;

public class UserUtils {

    public static UserDTO getUserById(int userId) {
        UserService userService = WechatServiceLocator.getUserService();
        return userService.getUserByUserId(userId);
    }

    public static UserDTO getCurrentUser(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) return null;
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        return user;
    }

    public static int getCurrentUserId(HttpServletRequest request) {
        UserDTO user = getCurrentUser(request);
        if (user == null) return 0;
        return user.getUserId();
    }

    public static SystemParamDTO getSystemparamByName(String name) {
        SystemParamService systemParamService = WechatServiceLocator.getSystemParamService();
        return systemParamService.getSystemParamByName(name);
    }
}
