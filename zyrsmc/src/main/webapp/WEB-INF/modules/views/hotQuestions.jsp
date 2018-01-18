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
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/index.js"></script>
    <style type="text/css">
      .qsg{margin-top:20px;}
    </style>
</head>
<body id="index">
   <jsp:include page="/WEB-INF/modules/views/common/header.jsp"></jsp:include>
    <!-- content -->
    <div class="w-content m-center">
        <div class="con-right fl">
          
            <div class="ztz">
                <h1>你问TA答<a href="${ctx}/topic/addQuestions.html" style="float:right;color: blue;">我要提问</a>
                </h1>
                <ul>
                <c:forEach items="${topicList}" var="topic">
                  <li style="border-bottom: 1px solid;border-bottom-color: #d8dee2;margin-top: 10px;">
                  <a href="${ctx }/topic/showQuestion/${topic.id}.html" style="line-height: 54px;">${topic.title }<a/>
                  <span style="float:right;line-height: 54px;">${topic.clickNum } 浏览    <fmt:formatDate value="${topic.createDate }" type="both"/> </span>
                  </li>
                </c:forEach>
                </ul>
              
            </div>
        </div>
        <div class="con-left fr">
            <div class="unit_wrap">
                <h3 class="title">
                    活跃用户<span></span>
                </h3>
                <ul class="star">
                  <c:forEach items="${topReplyUsers}" var="top">
                  <c:set value="${fns:getUserById(top.creator)}" var="us"></c:set>
                    <li>
                        <div class="elite_wrap">
                            <a class="user_ava" href="#">
                                <img src="${ctx}/${us.avatar ==null||us.avatar ==''?'static/front/images/default_avatar.png':us.avatar }" alt="${us.username }" />
                            </a>
                            <div class="user_intro">
                                <a href="${ctx}/my/myinfo/${top.creator}.html">${us.username }</a>
                                <p class="user_grade">
                                                                                                         回答数<em>${top.count }</em>
                                </p>
                                <p class="user_grade">
                                	${us.nickName }
                                </p>
                            </div>
                        </div>
                       <!--  <div class="star_info">
                            <span></span>
                            <p>
                                创建词条：<em>1520</em>&nbsp;&nbsp;&nbsp;更新词条：<em>100</em>
                            </p>
                        </div> -->
                    </li>
                  </c:forEach>
                </ul>
            </div>
            <div class="unit_wrap">
                <h3 class="title">
                  提问榜<span><!-- <a href="#">更多</a> --></span>
                </h3>
                <ul class="star">
                 <c:forEach items="${topUsers }" var="top">
                 <c:set value="${fns:getUserById(top.creator)}" var="us"></c:set>
                    <li>
                        <div class="elite_wrap br">
                            <a class="user_ava" href="#">
                                <img src="${ctx}/${us.avatar ==null||us.avatar ==''?'static/front/images/default_avatar.png':us.avatar }" alt="${us.username }" />
                            </a>
                            <div class="user_intro">
                                <a href="${ctx}/my/myinfo/${top.creator}.html">${us.username }</a>
                                <p class="user_grade">
                                    	提问数:${top.count }
                                </p>
                                <p class="user_grade">
                                    	${us.nickName }
                                </p>
                            </div>
                        </div>
                    </li>
                     </c:forEach>
                </ul>
            </div>
           
        </div>
    </div>
    <!-- foot -->
    <jsp:include page="/WEB-INF/modules/sys/foot.jsp"></jsp:include>
    <script type="text/javascript">
        $(".topNav .current").removeClass("current");
        $(".topNav .cur2").addClass("current");
    </script>
</body>s
</html>
