<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ include file="/WEB-INF/modules/sys/common.jsp" %>
<link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${ctx}/static/css/font-awesome.css?v=4.3.0" rel="stylesheet">
<link href="${ctx}/static/fancyBox-master/source/jquery.fancybox.css" rel="stylesheet">
<link href="${ctx}/static/css/animate.css" rel="stylesheet">
<link href="${ctx}/static/css/style.css?v=3.0.0" rel="stylesheet">

<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable tr {
	background-color: #d4e3e5;
}

table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
 
</style>
<title>话题管理</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>
					</h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i> </a> <a
							class="dropdown-toggle" data-toggle="dropdown"
							href="table_data_tables.html#"> <i class="fa fa-wrench"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="table_data_tables.html#">选项1</a></li>
							<li><a href="table_data_tables.html#">选项2</a></li>
						</ul>
						<a class="close-link"> <i class="fa fa-times"></i> </a>
					</div>
					<form method="post" id="searchForm" action="${ctx}/user/userList">
					 <input type="hidden" name="pageNo" value="${page.page }">
					  <input type="hidden" name="pageSize" value="${page.limit }">
					  <input type="hidden" name="totalPage" value="${page.totalPages }">
              		      用户名:<input name="username" type="text"/>
                       <button data-toggle="button" class="btn btn-primary" type="button" onclick="search()">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     </form>
				</div>
				<div class="ibox-content">
					<table class="table">
					  <%--  <caption>上下文表格布局</caption> --%>
					   <thead>
					      <tr>
					         <th>用户名</th>
					         <th>昵称</th>
					         <th>创建时间</th>
					         <th>姓名</th>
					         <th>最后登录</th>
					         <th>操作</th>
					      </tr>
					   </thead>
					   <tbody>
					   	<c:forEach items="${userList }" var="ur">
					      <tr>
					         <td>${ur.username }</td>
					         <td>${ur.nickName}</td>
					         <td>${ur.createDate }</td>
					         <td>${ur.realName }</td>
					         <td>${ur.lastloginDate }</td>
					         <td><button type="button" class="btn btn-primary" onclick="editUser('${ur.userId}')">编辑</button>&nbsp;&nbsp;
					         <button type="button" class="btn btn-danger">删除</button>
					         </td>
					      </tr>
					   	</c:forEach>
					   </tbody>
					</table>
					<div id="pageId" class="m-pagination"></div>
				</div>
			</div>
		</div>
	</div>
	    <script type="text/javascript" src="${ctx }/static/js/jquery-2.1.1.min.js"></script>
	     <script src="${ctx }/static/js/bootstrap.min.js?v=3.4.0"></script>
	      <script src="${ctx}/static/fancyBox-master/source/jquery.fancybox.js"></script>
	     <script src="${ctx }/static/js/page.js"></script>
<script type="text/javascript">
		function editUser(id){
			 $.fancybox({
			   "href":"${ctx}/user/getUser?userId="+id,
			   "type":'iframe',
			   "width":1000,
			   "height":700,
			   "openEffect": 'elastic'
			  });
		}
		
		function search(){
		  $("#searchForm").submit();
		}
</script>
</body>
</html>