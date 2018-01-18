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
    top:-66px;
    display:none;
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
</head>
<body id="index">
   <jsp:include page="/WEB-INF/modules/views/common/header.jsp"></jsp:include>
    <!-- content -->
    <div class="w-content m-center">
        <div class="con-left fl">
            <div class="unit_wrap">
                <h3 class="title">
                    个人档<span></span>
                </h3>
                <ul class="star" style="text-align: center;">
                   <li  class="avatar"> 
                   <img  src="${ctx}/${myuser.avatar ==null||myuser.avatar ==''?'static/front/images/default_avatar.png':myuser.avatar }" alt="点击上传头像" style="width:100px;height:100px;"/></p>
                    <c:if test="${user!=null && myuser.userId eq user.userId }">
	                    <a href="javascript:;" class="file" >上传头像
						    <input type="file" name="files" id="file">
						</a>
                    </c:if>
                   </li>
                   <em>${myuser.username }</em><br/>
                   <c:if test="${user.userId != myuser.userId }">
                     <c:if test="${focusUserDTO ==null }">
                     <input type="button" value="关注+" style="margin-top:10px;" onclick="focusUser('${myuser.userId}')"/>
                     </c:if>
                     <c:if test="${focusUserDTO !=null }">
                       	 已关注
                     </c:if>
                   </c:if>
                    <li style="margin-left:10%;">
                       <div style="margin-top:10px;">昵称:${myuser.nickName }</div>
                       <div style="margin-top:10px;">浏览:0次</div>
                       <div style="margin-top:10px;">粉丝:0次</div>
                    </li>
                </ul>
            </div>
            <div class="unit_wrap">
                <h3 class="title">
                  最近来访<span><a href="#">更多</a></span>
                </h3>
                <ul class="star">
                	<c:forEach items="${visitUsers}" var="visit">
                	<c:set var="us" value="${fns:getUserById(visit.userId) }"></c:set>
                    <li>
                        <div class="elite_wrap br">
                            <a class="user_ava" href="#">
                                  <img src="${ctx}/${us.avatar ==null||us.avatar ==''?'static/front/images/default_avatar.png':us.avatar }" alt="" />
                            </a>
                            <div class="user_intro">
                                <a href="${ctx}/my/myinfo/${visit.userId}.html">${us.username }</a>
                                <!-- <p class="user_grade">
                                    2016-08-24 13:44:01
                                </p> -->
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
         <div class="con-right fr">
            <div class="ztz">
                <h1>我发布的话题
                </h1>
                <ul>
               <c:if test="${fn:length(topicList)>0}">
                <c:forEach items="${topicList}" var="topic">
                  <li style="border-bottom: 1px solid;border-bottom-color: #d8dee2;margin-top: 10px;">
                  <a href="${ctx }/topic/detail/${topic.id}.html" style="line-height: 54px;width:30%">${topic.title }<a/>
                  <span style="float:right;line-height: 54px;">${topic.clickNum } 浏览</span>
                  </li>
                </c:forEach>
                </c:if> 
                <c:if test="${fn:length(topicList)<1}">
                   <li style="margin-top: 20px;">
                     	 该用户暂未发布话题
                   </li>
                </c:if>
                </ul>
              
            </div>
        </div>
    </div>
    <!-- foot -->
    <jsp:include page="/WEB-INF/modules/sys/foot.jsp"></jsp:include>
     <script src="${ctx }/static/js/ajaxfileupload.js"></script>
  <script type="text/javascript">
  $('#file').live("change",function() {
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
		        var userId="${myuser.userId}";
	           $.ajax({
	               url:'${ctx}/my/updateMyAvatar',
	               type:"POST",
	               data:{"userId":userId,"avatar":filePath},
	               dataType:"json",
	               success:function(data){
	                 if(data=="success")
	                   {
	                    alert("头像上传成功!");
	                    $(".star img").attr("src","${ctx}/"+filePath);
	                   }
	               }
	           });
        }
        
        $(".avatar").mouseover(function(){
           $(".file").show();
        });
       
        $(".avatar").mouseout(function(){
           $(".file").hide();
        });
        
        $(function(){
           visitUser("${myuser.userId}");
        });
        
        function visitUser(visitUser){
          var userId="${user.userId}";
          if(userId==''||userId==visitUser)
            return;
          
               $.ajax({  
                    type : "POST",  //提交方式  
                    url : "${ctx}/my/saveVisitUser",//路径  
                    data :  {"visitUser":visitUser,"userId":userId},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                    }  
                });  
         }
         
          function islogin(){
           var user="${user}";
           if(user==''||user==undefined){
              window.location.href="${ctx}/login.html";
              return false;
           }
           return true;
        }
        
        function focusUser(focusUser){
               var isLogin=islogin();
               if(!isLogin)
                  return;
               $.ajax({  
                    type : "POST",  //提交方式  
                    url : "${ctx}/my/saveFocusUser",//路径  
                    data :  {"focusUser":focusUser},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                       alert("关注成功!");
                       window.location.reload();
                    }  
                });  
         }
  </script>
</body>
</html>
