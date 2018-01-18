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
      <h2>注册</h2>
       <form action="${ctx }/register" method="post" id="inputForm">
         <div class="content" style="margin-left:30%;">
         	<div class="message">${message }</div>
             <div class="control">
               <label>用&nbsp;户&nbsp;名&nbsp;&nbsp;:</label>
               <span class="inp"><input class="width300" type="text" value="" name="username" /></span>
             </div>
             <div class="control">
               <label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
               <span class="inp"><input class="width300" type="password" value="" name="password"/></span>
             </div>
             <div class="control">
               <label>确认密码:</label>
               <span class="inp"><input class="width300" type="password" value="" name="repassword"/></span>
             </div>
             <div class="control">
               <label>验&nbsp;证&nbsp;码&nbsp;:</label>
                <span class="inp"><input class="width100" type="text" value="" name="validatecode" /><span style="margin-left:20px;"><img class="randomImg" src="${ctx}/validateCode" onclick="refreshCode()"/><span/><a style="margin-left:20px;color:blue;cursor: pointer;" onclick="refreshCode()">换一张</a>
               </span>
             </div>
             <div class="operation" style="margin-left:70px;">
                 <input type="submit" id="saveBtn" value="确认注册"/> &nbsp;&nbsp;&nbsp;<span style="margin-top:20px;display:inline-block;margin-left:78px;">已有本站账号?我要<a href="${ctx}/login.html" style="color:blue;">登录</a></span>
             </div>
         </div>
         </form>
    </div>
    <!-- foot -->
   <jsp:include page="/WEB-INF/modules/sys/foot.jsp"></jsp:include>
        <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/index.js"></script>
     <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
		function refreshCode(){
		    var timestamp = new Date().getTime();
			$(".randomImg").attr('src',$(".randomImg").attr('src')+"?"+timestamp);
		}
	</script>
</body>
</html>
