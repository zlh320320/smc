<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>网站设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="网站设置" />
    <meta name="description" content="网站设置。" />
    <link type="text/css" href="${ctx}/static/css/index.css" rel="stylesheet" />
    <link type="text/css" href="${ctx}/static/front/css/topic.css" rel="stylesheet" />

</head>
<body id="index">
    <!-- top -->
    <!-- content -->
    <div class="w-content m-center">
       <form action="${ctx }/content/saveSite" method="post" id="inputForm">
        <input type="hidden" name="id" value="${site.id }"/>
         <div class="content">
             <div class="control">
               <label>网站标题:</label>
               <span class="inp"><input class="width300" type="text" value="${site.siteName }" name="siteName"/></span>
             </div>
             <div class="control">
               <label>网站关键词:</label>
               <span class="inp"><input class="width300" type="text" value="${site.keywords }" name="keywords"/></span>
             </div>
             <div class="control">
               <label>网站描述:</label>
               <span class="inp"><input class="width300" type="text" value="${site.siteDesc }" name="siteDesc"/></span>
             </div>
             
             <div class="control">
               <label>logo:</label>
               <span class="inp">
               <input type="hidden" value="${site.logo }" name="logo"/>
                <input type="file" name="files" id="file">
               <img src="${ctx}${site.logo }" style="width:100px;"/>
               </span>
             </div>
            
             <div class="operation">
                 <input type="button" id="saveBtn" value="保存"/>
             </div>
         </div>
         </form>
    </div>
        <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/index.js"></script>
     <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
     <script src="${ctx }/static/js/ajaxfileupload.js"></script>
    <script type="text/javascript">
    
		$("#saveBtn").click(function(){
		
		    $.ajax({  
                    type : "POST",  //提交方式  
                    url : $("#inputForm").attr("action"),//路径  
                    data :  $("#inputForm").serialize(),//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="success") {  
                            alert("保存成功");
                        } else {  
                            alert(result);
                        }  
                    }  
                });  
		});
		
		$('#file').change(function() {
			 uploadFile("file");
		});
		
		function uploadFile(fileId) {
          $.ajaxFileUpload
          (
              {
                  url: '${ctx}/file/uploadFile?prePath=content', //用于文件上传的服务器端请求地址
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
		        $(fileParent).find("input[name='logo']").val(filePath);
		        $(fileParent).find("img").attr("src","${ctx}"+filePath);
		        
      }
	</script>
</body>
</html>
