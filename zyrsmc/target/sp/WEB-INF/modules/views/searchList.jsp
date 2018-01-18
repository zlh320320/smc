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
    <style type="text/css">
      .qsg{margin-top:20px;height:50px;}
      .page{float:right;text-align:center;}
      .page span{width:33px;height:30px;display:inline-block;}
      .page .cur{background-color:#006699;}
      .page .cur a {color:white;}
    </style>
</head>
<body id="index">
    <!-- top -->
    <%@include file="/WEB-INF/modules/views/common/header.jsp"%>
    <!-- content -->
    <div class="w-content m-center">
        <div class="con-right fl" style="width:100%;">
            <form action="${ctx}/topic/hotTopics.html" id="searchForm" method="post">
                  <input type="hidden" name="pageNo" value="${page.page }">
					  <input type="hidden" name="pageSize" value="${page.limit }">
					  <input type="hidden" name="totalPage" value="${page.totalPages }">
            </form>
            <div class="ztz">
                <span>搜索结果 :关键词<span style="color:red">"${tagName }"</span>共搜到${fn:length(topicList) }条记录</span>
                <div class="page">
                </div>
                <table style="width:100%;margin-top:20px;">
                <tr style="background-color: #d7d7d7;height: 40px;">
                  <td width="30%">主题</td>
                  <td width="20%">作者</td>
                  <td width="15%">栏目</td>
                  <td width="15%">阅读</td>
                  <td width="20%">发表时间</td>
                </tr>
                <c:forEach items="${topicList}" var="topic" varStatus="vs">
	                <tr class="qsg" >
	                     <td class="title" style="font-size: 18px;"><a href="${ctx}/topic/detail/${topic.id}.html">
	                        <c:set var="tn" value="<span style=color:red>${tagName}</span>"></c:set>
	                        ${fn:replace(topic.title,tagName,tn) }
	                      </a></td>
	                     <td>${topic.editor}	</td>
	                     <td>${fns:getColumnById(topic.columnId).columnName }</td>
	                     <td>
	                         ${topic.clickNum }
	                     </td>
	                     <td>
	                     	<fmt:formatDate value="${topic.createDate }" type="both"/>
	                     </td>
	                </tr>
                </c:forEach>
                </table>
                <div class="page" >

                </div>
            </div>
        </div>
     
    </div>
    <!-- foot -->
    <jsp:include page="/WEB-INF/modules/sys/foot.jsp"></jsp:include>
        <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/index.js"></script>
    <script type="text/javascript" src="${ctx}/static/front/js/common/page.js"></script>

</body>
</html>
