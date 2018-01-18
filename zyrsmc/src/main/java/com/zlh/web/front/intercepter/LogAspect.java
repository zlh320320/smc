package com.zlh.web.front.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Component  
@Aspect
public class LogAspect{
    
    private static Log logger=LogFactory.getLog(LogAspect.class);
    
    @Pointcut("execution(* com.zlh.web..*.*(..))")
    public void aspect(){
         
    }
    
    @Around("aspect() && @annotation(com.zlh.web.front.intercepter.NeedLogin)")  
    public Object checkLogin(ProceedingJoinPoint thisJoinPoint) throws Throwable {  
        String clazzName = thisJoinPoint.getTarget().getClass().getName();  
        String methodName = thisJoinPoint.getSignature().getName();  
        Object result =null;
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        // 计时并调用目标函数  
        long start = System.currentTimeMillis();  
        if(request.getSession().getAttribute("user") == null ){
            //未登陆跳转
            response.sendRedirect(request.getContextPath()+"/login.html");  
        }  
            result = thisJoinPoint.proceed();  
         
        
      //  result = thisJoinPoint.proceed();  
        long time = System.currentTimeMillis() - start;  
           
        // 输出计时信息  
        logger.info("操作计时：" + time + "ms  类名: " + clazzName+ "  方法名:" + methodName + "()");  
  
        return result;  
    }  
}
