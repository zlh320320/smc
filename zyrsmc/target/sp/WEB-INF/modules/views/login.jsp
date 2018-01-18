<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>java学习社区-YOUR互联</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="java学习 Java开发 软件开发 大数据 java论坛" />
    <meta name="description" content="旨在为大家建议一个java学习的社区。" />
    <link type="text/css" href="${ctx}/static/css/index.css" rel="stylesheet" />
    <link type="text/css" href="${ctx}/static/front/css/topic.css" rel="stylesheet" />
	<style type="text/css">
	  .message{color: red;width: 80%;font-weight: bold;}
	  #saveBtn{width:80px;height:33px;}
	</style>
</head>
<body id="index">
    <!-- top -->
     <%@include file="/WEB-INF/modules/views/common/header.jsp" %>
    <!-- content -->
    <div class="w-content m-center">
      <h2>登录</h2>
       <form action="${ctx }/login" method="post" id="inputForm">
         <div class="content" style="margin-left:30%;">
            <div class="message">${message }</div>
             <div class="control">
               <label>用户名:</label>
               <span class="inp"><input class="width300" type="text" value="${username }" name="username" /></span>
             </div>
             <div class="control">
               <label>密&nbsp;&nbsp;&nbsp;码:</label>
               <span class="inp"><input class="width300" type="password" value="${password }" name="password"/></span>
             </div>
             <div class="control">
               <label>验证码:</label>
               <span class="inp">
               <input class="width100" type="text" value="" name="validatecode" />
               </span>
               <span style="margin-left:20px;display:inline-block;"><img class="randomImg" src="${ctx}/validateCode" onclick="refreshCode()"/><span/>
               <a style="margin-left:20px;color:blue;cursor: pointer;" onclick="refreshCode()">换一张</a>
             </div>
             <div class="operation" style="margin-left:57px;">
                 <input type="submit" id="saveBtn" value="登录"/>&nbsp;&nbsp;&nbsp;<span style="margin-top:20px;display:inline-block;margin-left:78px;">还没有账号?我要<a href="${ctx}/register.html" style="color:blue;">注册</a></span>
             </div>
         </div>
         </form>
    </div>
    <!-- foot -->
    <%@include file="/WEB-INF/modules/sys/foot.jsp"  %>
        <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/index.js"></script>
    <script type="text/javascript">
		
		function refreshCode(){
		    var timestamp = new Date().getTime();
			$(".randomImg").attr('src',$(".randomImg").attr('src')+"?"+timestamp);
		}
		if (window != top){
			 top.location.href = location.href;
          }

	</script>
</body>
</html>
