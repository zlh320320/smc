package com.zlh.web.front.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.baby.BabyServiceLocator;
import com.zlh.baby.dto.TopicDTO;
import com.zlh.baby.service.TopicService;
import com.zlh.cms.CmsServiceLocator;
import com.zlh.cms.dto.ColumnDTO;
import com.zlh.cms.dto.ContentDTO;
import com.zlh.cms.service.ColumnService;
import com.zlh.cms.service.ContentService;
import com.zlh.cms.service.SiteService;
import com.zlh.web.front.intercepter.NeedLogin;
import com.zlh.web.utils.EncoderUtil;
import com.zlh.web.utils.UserUtils;
import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.LoginLogDTO;
import com.zlh.wx.dto.UserDTO;
import com.zlh.wx.service.LoginLogService;
import com.zlh.wx.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

    private static Log               logger          = LogFactory.getLog(IndexController.class);
    private final static UserService userService     = WechatServiceLocator.getUserService();
    private static TopicService      topicService    = BabyServiceLocator.getTopicService();
    // private static TopicReplyService replyService = BabyServiceLocator.getTopicReplyService();
    private static LoginLogService   loginLogService = WechatServiceLocator.getLoginLogService();
    private static ColumnService columnService=CmsServiceLocator.getColumnService();
    private static ContentService contentService=CmsServiceLocator.getContentService();
    private static SiteService siteService=CmsServiceLocator.getSiteService();
    private static final String clientId="o6a88adwv5vaVvvvWNcN6O4S";
    private static final String clientSecret="u5URro7Usm2ONF54Omf4KIVDuSGAjkCK";
    private static final String clientRedirecturl="http://www.yr87.cn/sp/loginByCode";
    // 进入前台首页
    /** * @return */
    @RequestMapping(value = {"/index.html","/"}, method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info("to idnex page...");
        ModelAndView modelAndView = new ModelAndView();
        List<ColumnDTO> columnlist=columnService.getColumnList(new PageBounds(),1);
        String bannerId=UserUtils.getSystemparamByName("index_banner").getValue();
        
        List<ContentDTO> bannerList=contentService.getContentList(new PageBounds(6), Integer.parseInt(bannerId));
        modelAndView.addObject("bannerList", bannerList);
        
        List<ContentDTO> highTopicList = contentService.getContentList(new PageBounds(1, 6), 13);// 高手区
        List<ContentDTO> lowTopicList =  contentService.getContentList(new PageBounds(1, 9), 15);// 菜鸟区
        List<TopicDTO> qaList = topicService.getTopicList(new PageBounds(1, 9), 3, 0);// 问答区

        List<UserDTO> lastUserList = userService.getLatestUserList(new PageBounds(1, 3), null);

        List<UserDTO> loginLogs = userService.getLatestLoginUser(new PageBounds(1, 3));


        modelAndView.addObject("lowTopicList", lowTopicList);
        modelAndView.addObject("highTopicList", highTopicList);
        modelAndView.addObject("qaList", qaList);
        modelAndView.addObject("lastUserList", lastUserList);
        modelAndView.addObject("loginLogs", loginLogs);
        modelAndView.addObject("columnlist", columnlist);
        modelAndView.setViewName("/views/home");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @NeedLogin
    public ModelAndView logout(HttpServletRequest request) {
        logger.info("to logout page...");
        if (request.getSession().getAttribute("user") != null) {
            UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            LoginLogDTO loginlog = new LoginLogDTO();
            loginlog.setCreateDate(new Date());
            loginlog.setLoginIp(request.getRemoteHost());
            loginlog.setMac(request.getRemoteAddr());
            loginlog.setType(1);
            loginlog.setUserId(user.getUserId());
            loginlog.setUsername(user.getUsername());
            loginLogService.saveLoginLog(loginlog);
            request.getSession().invalidate();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/views/login");

        return modelAndView;
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        logger.info("to login page...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/views/login");
        return modelAndView;
    }

    @RequestMapping(value = "/loginByCode")
    public ModelAndView loginByCode(String code,HttpServletRequest request) {
        logger.info("to loginByCode page...");
        String accessToken=(String)request.getSession().getAttribute("accessToken");
        accessToken=accessToken==null?getAccessToken(code):accessToken;
        String url="https://openapi.baidu.com/rest/2.0/passport/users/getInfo?access_token="+accessToken;
        String result=getBaiduUserInfo(url);
        /* result="{"+
            "\"userid\":\"2097322476\","+
           " \"username\":\"wl19871011\","+
            "\"realname\":\"阳光\","+
            "\"userdetail\":\"喜欢自由\","+
            "\"birthday\":\"1987-01-01\","+
            "\"marriage\":\"恋爱\","+
           " \"sex\":\"男\","+
            "\"blood\":\"O\","+
           " \"constellation\":\"射手\","+
            "\"figure\":\"小巧\","+
            "\"education\":\"大学/专科\","+
           " \"trade\":\"计算机/电子产品\","+
           " \"job\":\"未知\","+
           " \"birthday_year\":\"1987\","+
           " \"birthday_month\":\"01\","+
           " \"birthday_day\":\"01\","+
        "}";*/
        ModelAndView modelAndView = new ModelAndView();
        if(StringUtils.isEmpty(result)){
            String message = "登录授权失败,没有获取到用户信息!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }
        Map<String,Object> userinfo=JSON.toJavaObject(JSON.parseObject(result), Map.class); 
        
        if(userinfo==null||userinfo.get("username")==null){
            String message = "登录授权失败,没有获取到用户信息!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }
            
        
        UserDTO user=userService.getUserByUserName((String)userinfo.get("username"));
        if(user==null){
            user=new UserDTO();
            user.setAvatar("http://tb.himg.baidu.com/sys/portraitn/item/"+userinfo.get("portrait"));
            user.setUsername((String)userinfo.get("username"));
            user.setRealName((String)userinfo.get("realname"));
            user.setIsAdmin(0);
            user.setLastloginDate(new Date());
            userService.createUser(user);
        }
        request.getSession().setAttribute("user", user);
       
        modelAndView.setViewName("redirect:index.html");
        return modelAndView;
    }

    public String getBaiduUserInfo(String url) {
        String jsonStr =null;
        try {
            CloseableHttpClient httpclient = HttpClientBuilder.create().build();
            
            HttpGet httpget = new HttpGet(url);   
            //配置请求的超时设置
            RequestConfig requestConfig = RequestConfig.custom()  
                    .setConnectionRequestTimeout(50)
                    .setConnectTimeout(50)  
                    .setSocketTimeout(50).build();  
            httpget.setConfig(requestConfig); 
             
            CloseableHttpResponse response = httpclient.execute(httpget);        
            System.out.println("StatusCode -> " + response.getStatusLine().getStatusCode());
             
            HttpEntity entity = response.getEntity();        
             jsonStr = EntityUtils.toString(entity);//, "utf-8");
            System.out.println(jsonStr);
             
            httpget.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public String getAccessToken(String code) {
        String url="https://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code"+
    "&code="+code+"&client_id="+clientId+"&client_secret="+clientSecret+"&redirect_uri="+clientRedirecturl+"";
        String jsonStr =null;
        try {
            CloseableHttpClient httpclient = HttpClientBuilder.create().build();
            
            HttpGet httpget = new HttpGet(url);   
            //配置请求的超时设置
            RequestConfig requestConfig = RequestConfig.custom()  
                    .setConnectionRequestTimeout(50)
                    .setConnectTimeout(50)  
                    .setSocketTimeout(50).build();  
            httpget.setConfig(requestConfig); 
             
            CloseableHttpResponse response = httpclient.execute(httpget);        
            System.out.println("StatusCode -> " + response.getStatusLine().getStatusCode());
             
            HttpEntity entity = response.getEntity();        
             jsonStr = EntityUtils.toString(entity);//, "utf-8");
             System.out.println("StatjsonStrusCode -> " + jsonStr);
            httpget.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Map<String,Object> map=JSON.toJavaObject(JSONObject.parseObject(jsonStr), Map.class);
        if(map==null||map.get("access_token")==null)
            return null;
        return (String)map.get("access_token");
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("to login ...");
        ModelAndView modelAndView = new ModelAndView();
        String message = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String validatecode = request.getParameter("validatecode");
        String vaCode = (String) request.getSession().getAttribute("validateCode");

        if (vaCode == null) {
            message = "验证码已失效，请刷新页面重试!";
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }
        if (validatecode == null) {
            message = "验证码不能为空!";
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }
        if (!vaCode.toUpperCase().equals(validatecode.toUpperCase())) {
            message = "验证码不正确!";
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }

        UserDTO user = userService.getUserByUserName(username);
        if (user == null) {
            message = "用户名不存在!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }

        if (password != null) { // 密码正确进入首页
            if (password.equals(EncoderUtil.decry(user.getPassword()))) {
                request.getSession().setAttribute("user", user);

                LoginLogDTO loginlog = new LoginLogDTO();
                loginlog.setCreateDate(new Date());
                loginlog.setLoginIp(request.getRemoteHost());
                loginlog.setMac(request.getRemoteAddr());
                loginlog.setMessage(message);
                loginlog.setType(0);
                loginlog.setUserId(user.getUserId());
                loginlog.setUsername(user.getUsername());
                loginLogService.saveLoginLog(loginlog);

                user.setLastloginIp(request.getRemoteHost());
                user.setLastloginDate(new Date());
                user.setLoginTimes(user.getLoginTimes() + 1);
                userService.updateUser(user);

                modelAndView.setViewName("redirect:index.html");
                return modelAndView;
            }
            message = "用户名或密码错误!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }

        modelAndView.setViewName("/views/login");
        return modelAndView;
    }

    // 进入注册页面
    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public ModelAndView register() {
        logger.info("to register page...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/views/register");

        return modelAndView;
    }

    // 表单注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(UserDTO userDTO, HttpServletRequest request) {
        logger.info("to login page...");

        ModelAndView modelAndView = new ModelAndView();
        UserDTO user = userService.getUserByUserName(userDTO.getUsername());
        String message = "";
        String repassword = request.getParameter("repassword");

        if (StringUtils.isBlank(userDTO.getPassword()) || userDTO.getPassword().length() < 6
            || userDTO.getPassword().length() > 16) {
            modelAndView.setViewName("/views/register");
            message = "密码长度至6-16位";
            modelAndView.addObject("message", message);
            return modelAndView;
        }

        if (repassword == null || !repassword.equals(userDTO.getPassword())) {
            modelAndView.setViewName("/views/register");
            message = "两次密码不一致";
            modelAndView.addObject("message", message);
            return modelAndView;
        }

        String validatecode = request.getParameter("validatecode");
        String vaCode = (String) request.getSession().getAttribute("validateCode");
        if (vaCode == null) {
            message = "验证码已失效，请刷新页面重试!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }
        if (validatecode == null) {
            message = "验证码不能为空!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }
        if (!vaCode.toUpperCase().equals(validatecode.toUpperCase())) {
            message = "验证码不正确!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/views/login");
            return modelAndView;
        }

        if (user != null) {
            modelAndView.setViewName("/views/register");
            message = "该用户已存在";
            modelAndView.addObject("message", message);
            return modelAndView;
        }

        userDTO.setPassword(EncoderUtil.encry(userDTO.getPassword()));
        userDTO.setCreateDate(new Date());
        int row = userService.createUser(userDTO);
        if (row > 0) {
            request.getSession().setAttribute("user", userDTO);
            modelAndView.setViewName("redirect:index.html");
            return modelAndView;
        } else {
            modelAndView.setViewName("/views/register");
            message = "注册失败，请稍后重试";
            modelAndView.addObject("message", message);
            return modelAndView;
        }
    }

}
