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

</head>
<body id="index">
    <!-- top -->
     <%@include file="/WEB-INF/modules/views/common/header.jsp"%>
    <!-- content -->
    <div class="w-content m-center">
       <form action="${ctx }/suggest/addsuggest" method="post" id="inputForm">
         <div class="content">
             <div class="control">
               <label>标题:</label>
               <span class="inp"><input class="width300" type="text" value="" name="title"/></span>
             </div>
             <div class="control">
               <label style="float:left;">内容:</label>
               <span class="inp"><textarea id="content" rows="10" cols="100" name="content" style="display:none;"></textarea>
                <script id="editor" type="text/plain" style="width:96%;min-height:300px;float:left;"></script>
               </span>
             </div>
             <div class="operation">
                 <input type="button" id="saveBtn" value="提交意见"/>
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
		var ue = UE.getEditor('editor');
		$("#saveBtn").click(function(){
		
		   $("#content").val(ue.getContent());
		
		    $.ajax({  
                    type : "POST",  //提交方式  
                    url : $("#inputForm").attr("action"),//路径  
                    data :  $("#inputForm").serialize(),//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="success") {  
                            alert("感谢您的建议，我们将做的更好。");
                            window.location.href="${ctx}/index.html";
                        } else {  
                            alert(result);
                        }  
                    }  
                });  
		});
        $(".topNav .current").removeClass("current");
        $(".topNav .cur5").addClass("current");
    </script>
</body>
</html>
