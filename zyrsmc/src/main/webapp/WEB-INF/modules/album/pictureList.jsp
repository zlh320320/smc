<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
 <link href="${ctx}/static/css/style.css?v=3.0.0" rel="stylesheet"> 
<link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
 <link href="${ctx}/static/css/font-awesome.css?v=4.3.0" rel="stylesheet">
<link href="${ctx}/static/css/animate.css" rel="stylesheet">
<link href="${ctx}/static/fancyBox-master/source/jquery.fancybox.css" rel="stylesheet">
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
.file {
    position: relative;
    display: inline-block;
    background: #D0EEFF;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: #1E88C7;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
    top:28px;
}
.file input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.file:hover {
    background: #AADFFD;
    border-color: #78C3F3;
    color: #004974;
    text-decoration: none;
}
</style>
<title>相册管理</title>
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
					<form method="post" id="searchForm" action="${ctx}/album/getPictureList">
					  <input type="hidden" name="albumId" value="${albumId }">
					  <input type="hidden" name="pageNo" value="${page.page }">
					  <input type="hidden" name="pageSize" value="${page.limit }">
					  <input type="hidden" name="totalPage" value="${page.totalPages }">
              		      照片名称 :<input name="babyName" type="text"/>
                     <button data-toggle="button" class="btn btn-primary" type="button" onclick="search()">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:;" class="file">上传文件
					    <input type="file" name="files" id="file">
					</a>
                     </form>
				</div>
				<div class="ibox-content">
				<div class="row">
				<c:forEach items="${pictureDTOs }" var="picture">
				  <div class="col-xs-6 col-md-3" style="margin-top:10px;">
				    <span style="position:absolute;width:200px;overflow:hidden;margin-left:20px;">${picture.picName }</span>
				    <a onclick="previewPicture('${ctx}${picture.picPath }')" class="thumbnail">
				    <img src="${ctx}${picture.picPath }" alt="${picture.picName }" style="height:170px;">
				    </a>
				   <a style="margin-left:20px;" type="button" href="${ctx}${picture.picPath }" class="btn btn-primary" title="下载"><i class="glyphicon glyphicon-download-alt"></i></a>&nbsp;&nbsp;
				  <%--  <a style="margin-left:20px;" type="button" href="${ctx}${picture.picPath }" class="btn btn-primary" title="预览"><i class="glyphicon glyphicon-zoom-in"></i></a>&nbsp;&nbsp; --%>
					<button style="margin-left:20px;" type="button" class="btn btn-danger" title="删除"><i class="glyphicon glyphicon-trash"></i></button>
				  </div>
				</c:forEach>
				</div>
					<div id="pageId" class="m-pagination"></div>
				</div>
			</div>
		</div>
	</div>
	    <script type="text/javascript" src="${ctx }/static/js/jquery-2.1.1.min.js"></script>
	     <script src="${ctx }/static/js/bootstrap.min.js?v=3.4.0"></script>
	     <script src="${ctx}/static/fancyBox-master/source/jquery.fancybox.js"></script>
	     <script src="${ctx }/static/js/ajaxfileupload.js"></script>
	     <script src="${ctx }/static/js/page.js"></script>
<script type="text/javascript">
		function search(){
		  $("#searchForm").submit();
		}
		
		
		function previewPicture(src){
		  $.fancybox({
		   "href":"${ctx}/album/showPicture?src="+src,
		   "type":'iframe',
		   "width":1000,
		   "height":700,
		   "openEffect": 'elastic'
		  });
		}
		
		$('#file').change(function() {
			 uploadFile("file");
		});
		
		function uploadFile(fileId) {
            $.ajaxFileUpload
            (
                {
                    url: '${ctx}/file/uploadFile?prePath=baby', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: fileId, //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data)  //服务器成功响应处理函数
                    {
                       $.each(data,function(i,n){
                       		savePicture(n);
                       });
                       
                    }
                }
            )
            return false;
        }
        
        function savePicture(data){
	        var fileParent=$("#file").parent();
	        $("#file").remove();
	        $(fileParent).append("<input type='file' name='files' id='file'>");
		        var fileName=data.fileName;
		        var filePath=data.filePath;
		        var albumId="${albumId}";
	           $.ajax({
	               url:'${ctx}/album/savePicture',
	               type:"POST",
	               data:{"picName":fileName,"picPath":filePath,"albumId":albumId},
	               dataType:"json",
	               success:function(data){
	                 if(data=="success")
	                   {
	                    alert("上传成功!");
	                    search();
	                   }
	               }
	           });
        }
</script>
</body>
</html>