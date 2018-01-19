package com.zlh.web.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.baby.BabyServiceLocator;
import com.zlh.baby.dto.FocusUserDTO;
import com.zlh.baby.dto.TopicDTO;
import com.zlh.baby.dto.VisitUserDTO;
import com.zlh.baby.service.FocusUserService;
import com.zlh.baby.service.TopicService;
import com.zlh.baby.service.VisitUserService;
import com.zlh.web.front.intercepter.NeedLogin;
import com.zlh.web.utils.UserUtils;
import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.UserDTO;
import com.zlh.wx.service.UserService;

/**
 * * 类MyselfController.java的实现描述：个人中心 类实现描述 * @author zhenglh 2016年12月3日 下午2:47:13
 */
@Controller
@RequestMapping("/my")
public class MyselfController {

    private static Log              logger           = LogFactory.getLog(TopicController.class);
    private static UserService      userService      = WechatServiceLocator.getUserService();
    private static TopicService     topicService     = BabyServiceLocator.getTopicService();
    private static FocusUserService focusUserService = BabyServiceLocator.getFocusUserService();
    private static VisitUserService VisitUserService = BabyServiceLocator.getVisitUserService();

    /**
     * 用户中心 * @param userId /** * @return
     */
    @RequestMapping(value = "/myinfo/{userId}.html")
    @NeedLogin
    public ModelAndView myinfo(@PathVariable int userId, HttpServletRequest request) {
        logger.info("to getTopic Method...");
        UserDTO user = UserUtils.getCurrentUser(request);
        ModelAndView modelAndView = new ModelAndView();
        UserDTO myuser = userService.getUserByUserId(userId);

        List<TopicDTO> topicList = topicService.getTopicListByUser(new PageBounds(), userId, null);
        
        List<VisitUserDTO> visitUsers=VisitUserService.getVisitUserList(new PageBounds(6),null,userId);
        
        modelAndView.addObject("visitUsers", visitUsers);
        if(user!=null){
            FocusUserDTO focusUserDTO=focusUserService.getFocusUser(user.getUserId(),userId);
            modelAndView.addObject("focusUserDTO", focusUserDTO);
        }
        modelAndView.addObject("myuser", myuser);
        modelAndView.addObject("topicList", topicList);
        modelAndView.setViewName("/views/userpage");
        return modelAndView;
    }

    @RequestMapping(value = "/updateMyAvatar")
    @NeedLogin
    @ResponseBody
    public String updateMyAvatar(int userId, String avatar, HttpServletRequest request) {
        UserDTO user = UserUtils.getCurrentUser(request);
        int row = 0;
        if (user != null && user.getUserId() == userId) {
            user.setAvatar(avatar);
            row = userService.updateUser(user);
        }

        return row > 0 ? "success" : "error";
    }
    
    @RequestMapping(value = "/saveFocusUser")
    @NeedLogin
    @ResponseBody
    public String saveFocusUser(int focusUser, HttpServletRequest request) {
        UserDTO user = UserUtils.getCurrentUser(request);
        
        FocusUserDTO focusUserDTO=focusUserService.getFocusUser(user.getUserId(),focusUser);
        
        if(focusUserDTO!=null)
            return "error";
        focusUserDTO=new FocusUserDTO();
        focusUserDTO.setFocusUser(focusUser);
        focusUserDTO.setUserId(user.getUserId());
        int row=focusUserService.saveFocusUser(focusUserDTO);
        return row > 0 ? "success" : "error";
    }
    @RequestMapping(value = "/saveVisitUser")
    @NeedLogin
    @ResponseBody
    public String saveVisitUser(int visitUser,int userId) {
        List<VisitUserDTO> visitUsers=VisitUserService.getVisitUserList(new PageBounds(), userId, visitUser);
        if(visitUsers!=null&&visitUsers.size()>0){
            return "error";
        }
        VisitUserDTO visitUserDTO=new VisitUserDTO();
        visitUserDTO.setVisitUser(visitUser);
        visitUserDTO.setUserId(userId);
        int row=VisitUserService.saveVisitUser(visitUserDTO);
        return row > 0 ? "success" : "error";
    }
}
