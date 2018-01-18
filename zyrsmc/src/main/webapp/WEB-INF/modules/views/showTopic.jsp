<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${topic.title }</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content=">${topic.title }" />
    <meta name="description" content="${topic.title }" />
    <link type="text/css" href="${ctx}/static/css/index.css" rel="stylesheet" />
    <link type="text/css" href="${ctx}/static/front/css/topic.css" rel="stylesheet" />
    <style type="text/css">
      .remen{list-style:none;}
      .remen li{margin-top:20px;}
      .remen li a{margin-left:20px;margin-top:20px; width: 100%;overflow: hidden;text-overflow: ellipsis; white-space: nowrap;}
     .content1 *{max-width:100%;}
    </style>
</head>
<body id="index">
    <!-- top -->
    <%@include file="/WEB-INF/modules/views/common/header.jsp"  %>
    <!-- content -->
    <div class="w-content m-center">
        <span><a href="${ctx}/index.html">首页<a/></span>&nbsp;><span><a href="${ctx}/topic/list/${topic.columnId}.html">${fns:getColumnById(topic.columnId).columnName}</a></span>&nbsp;><span>${topic.title }</span>
         <div class="content" style="margin:0px auto;text-align:center;">
             <%-- <div class="control">
               <span class="inp">${topic.summary }</span>
             </div> --%>
             <div class="control">
             <div class="control" style="display:block;width:70%;float:left;">
               <h1 style="text-align:center;">${topic.title }</h1>
             	<div class="bdsharebuttonbox" data-tag="share_1" style="float:right;">
					<a class="bds_mshare" data-cmd="mshare"></a>
					<a class="bds_qzone" data-cmd="qzone"></a>
					<a class="bds_tsina" data-cmd="tsina"></a>
					<a class="bds_baidu" data-cmd="baidu"></a>
					<a class="bds_renren" data-cmd="renren"></a>
					<a class="bds_tqq" data-cmd="tqq"></a>
					<a class="bds_more" data-cmd="more">更多</a>
				</div>
             </div>
               <span class="inp content1" style="display:block;width:70%;float:left;">
                ${topic.content }
               </span>
               <div class="inp" style="float:right;width:28%;height:700px;">
	               <div class="inp" style="float:right;width:99%;height:340px;">
	                  <h3>相关话题</h3>
	                  <ul class="remen">
	                     <c:forEach items="${relateList }" var="relate">
	                     <li title="${relate.title }"><a href="${ctx}/topic/detail/${relate.id}.html">${relate.title }</a></li>
	                    </c:forEach>
	                  </ul>
	               </div>
	               <div class="inp" style="float:right;width:99%;height:340px;margin-top:10px;">
	               		<h3>热门话题</h3>
	                    <ul class="remen">
	                    <c:forEach items="${hotList }" var="hot">
	                     <li title="${hot.title }"><a href="${ctx}/topic/detail/${hot.id}.html">${hot.title }</a></li>
	                    </c:forEach>
	                     </ul>
	               </div>
               </div>
             </div>
         </div>
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
                            alert("投稿成功");
                        } else {  
                            alert(result);
                        }  
                    }  
                });  
		});
		$(function(){
		$.ajax({  
                    type : "POST",  //提交方式  
                    url : "${ctx}/topic/updateClick",//路径  
                    data :  {"topicId":"${topic.id}"},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                    }  
                });  
          });
	</script>
	<script>
	
	with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
</script>
</body>
</html>
