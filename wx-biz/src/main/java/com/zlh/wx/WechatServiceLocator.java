package com.zlh.wx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.zlh.wx.service.DictService;
import com.zlh.wx.service.LoginLogService;
import com.zlh.wx.service.MenuService;
import com.zlh.wx.service.PublicService;
import com.zlh.wx.service.RoleAuthService;
import com.zlh.wx.service.RoleService;
import com.zlh.wx.service.SystemParamService;
import com.zlh.wx.service.UserAuthService;
import com.zlh.wx.service.UserRoleService;
import com.zlh.wx.service.UserService;
import com.zlh.wx.service.impl.DictServiceImpl;
import com.zlh.wx.service.impl.LoginLogServiceImpl;
import com.zlh.wx.service.impl.MenuServiceImpl;
import com.zlh.wx.service.impl.PublicServiceImpl;
import com.zlh.wx.service.impl.RoleAuthServiceImpl;
import com.zlh.wx.service.impl.RoleServiceImpl;
import com.zlh.wx.service.impl.SystemParamServiceImpl;
import com.zlh.wx.service.impl.UserAuthServiceImpl;
import com.zlh.wx.service.impl.UserRoleServiceImpl;
import com.zlh.wx.service.impl.UserServiceImpl;

/**
 * @author z
 */
public class WechatServiceLocator {

    private static Log                logger = LogFactory.getLog(WechatServiceLocator.class);
    private static ApplicationContext applicationContext;

    static {
        synchronized (WechatServiceLocator.class) {
            try {
                applicationContext = new ClassPathXmlApplicationContext(
                                                                        new String[] { "classpath*:conf/wechat-service-locator.xml" });

            } catch (Exception e) {
                logger.error("Init WechatServiceLocator services error!", e);
                applicationContext = null;
            }
        }
    }

    public static UserService getUserService() {
        return (UserService) applicationContext.getBean(UserServiceImpl.class);
    }

    public static MenuService getMenuService() {
        return (MenuService) applicationContext.getBean(MenuServiceImpl.class);
    }

    public static PublicService getPublicService() {
        return (PublicService) applicationContext.getBean(PublicServiceImpl.class);
    }

    public static DictService getDictService() {
        return (DictService) applicationContext.getBean(DictServiceImpl.class);
    }

    public static LoginLogService getLoginLogService() {
        return (LoginLogService) applicationContext.getBean(LoginLogServiceImpl.class);
    }

    public static SystemParamService getSystemParamService() {
        return (SystemParamService) applicationContext.getBean(SystemParamServiceImpl.class);
    }
    
    public static RoleService getRoleService() {
        return (RoleService) applicationContext.getBean(RoleServiceImpl.class);
    }
    public static UserRoleService getUserRoleService() {
        return (UserRoleService) applicationContext.getBean(UserRoleServiceImpl.class);
    }
    
    public static RoleAuthService getRoleAuthService() {
        return (RoleAuthService) applicationContext.getBean(RoleAuthServiceImpl.class);
    }
    public static UserAuthService getUserAuthService() {
        return (UserAuthService) applicationContext.getBean(UserAuthServiceImpl.class);
    }
}
