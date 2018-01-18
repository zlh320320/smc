<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
<link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link href="${ctx}/static/css/font-awesome.css?v=4.3.0" rel="stylesheet">
<link
	href="${ctx}/static/css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-12">
		<form action="${ctx }/user/saveUser"
			style="width:50%;height:50%;margin-left: 300px;margin-top:100px;">
			<div class="form-group">
				<label class="col-sm-3 control-label">公众号名称：</label>
				<div class="col-sm-9">
					<input type="text" name="username" class="form-control">

				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公众号描述：</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" name="password">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公众号头像：</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" name="password">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公众号二维码：</label>
				<div class="col-sm-9">
					<input type="text" name="realname" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">注册手机：</label>
				<div class="col-sm-9">
					<input type="text" name="realname" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">注册邮箱：</label>
				<div class="col-sm-9">
					<input type="text" name="realname" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">AppID：</label>
				<div class="col-sm-9">
					<input type="text" name="realname" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">AppSecret：</label>
				<div class="col-sm-9">
					<input type="text" name="realname" class="form-control">
				</div>
			</div>
			<div style="margin-left:100px;margin-top:50px;">
				<button class="btn btn-primary " type="submit">
					<i class="fa fa-check"></i>&nbsp;提交
				</button>
				<button type="button" class="btn btn-default">取消</button>
			</div>
		</form>
	</div>
	<script type="text/javascript"
		src="${ctx }/static/js/jquery-2.1.1.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js?v=3.4.0"></script>
</body>
</html>