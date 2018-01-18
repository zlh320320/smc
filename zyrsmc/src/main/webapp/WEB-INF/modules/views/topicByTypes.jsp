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
      .hotTag{height:300px;over-flow:hidden;}
      .hotTag a{margin-left: 11px; margin-top: 20px;float:left;}
       .page{float:right;text-align:center;}
      .page span{width:33px;height:30px;display:inline-block;}
      .page .cur{background-color:#006699;}
      .page .cur a {color:white;}
    </style>
</head>
<body id="index">
    <!-- top -->
    <jsp:include page="/WEB-INF/modules/views/common/header.jsp"></jsp:include>
    <!-- content -->
    <div class="w-content m-center">
        <div class="con-right fl">
           <form action="${ctx}/topic/list/${columnId}.html" id="searchForm" method="post">
                  <input type="hidden" name="pageNo" value="${page.page }">
					  <input type="hidden" name="pageSize" value="${page.limit }">
					  <input type="hidden" name="totalPage" value="${page.totalPages }">
            </form>
            <div class="ztz">
                <h1>
                   ${fns:getColumnById(columnId).columnName}
                </h1>
                <c:forEach items="${contentList}" var="topic" varStatus="vs">
	                <div class="qsg" >
	                     <div class="title" style="font-size: 20px;font-weight: bold;color: black;width:63%;overflow: hidden; white-space: nowrap;text-overflow: ellipsis;">
	                     <span style="color:red;">${vs.index<3?'New':'' }</span><a  href="${ctx}/topic/detail/${topic.id}.html" title="${topic.title}">${topic.title }</a></div>
	                     <div class="summary" style="width:30%;float:right;margin-top:-10px;">
	                    	  <fmt:formatDate value="${topic.createDate}" pattern="yyyy年MM月dd日  hh:mm"/> | 浏览:${topic.clickNum }
	                     </div>
	                     <div class="summary" style="width:63%;margin-top:10px;">
	                     ${topic.summary }... <a href="${ctx}/topic/detail/${topic.id}.html">[详情]</a>
	                     </div>
	                </div>
                </c:forEach>
                <div class="page" >

                </div>
            </div>
        </div>
        <div class="con-left fr">
            <div class="zxxz">
                <h3 class="title">
                    热门关键词<span><!-- <a href="#">更多</a> --></span>
                </h3>
                <div class="hotTag" >
	                <c:forEach items="${searchTags }" var="tag">
	                  <a target="_blank" href="${ctx}/search/searchTopics/${tag.id }.html">${tag.tagName }</a>
	                </c:forEach>
                </div>
            </div>
           
            <div class="unit_wrap">
                <h3 class="title">
                   贡献榜<span><!-- <a href="#">更多</a> --></span>
                </h3>
                <ul class="star">
                   <c:forEach items="${topUsers }" var="top">
                   <c:set value="${fns:getUserById(top.creator)}" var="us"></c:set>
                    <li>
                        <div class="elite_wrap br">
                            <a class="user_ava" href="#">
                                <img src="${ctx}/${us.avatar ==null||us.avatar ==''?'static/front/images/default_avatar.png':us.avatar }" alt="" />
                            </a>
                            <div class="user_intro">
                                <a href="${ctx}/my/myinfo/${top.creator}.html">${us.username }</a>
                                <p class="user_grade">
                                    	贡献数:${top.count }
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
    <script type="text/javascript" src="${ctx}/static/front/js/common/page.js"></script>
    <script type="text/javascript">
        var type="${type}";
        if(type=="1"){
        $(".topNav .current").removeClass("current");
        $(".topNav .cur3").addClass("current");
        }
        if(type=="2"){
        $(".topNav .current").removeClass("current");
        $(".topNav .cur4").addClass("current");
        }
        
        $(".topNav li[data-id='${columnId}'] a").addClass("current");
        
    </script>
</body>
</html>
