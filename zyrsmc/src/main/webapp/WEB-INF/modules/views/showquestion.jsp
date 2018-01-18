<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/modules/sys/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>java学习社区-YOUR互联-${topic.title }</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="${topic.title }" />
    <meta name="description" content="${topic.title }" />
    <link type="text/css" href="${ctx}/static/css/index.css" rel="stylesheet" />
    <link type="text/css" href="${ctx}/static/front/css/topic.css" rel="stylesheet" />
    <style type="text/css">
      .remen{list-style:none;}
      .remen li{margin-top:20px;}
      .remen li a{margin-left:20px;margin-top:20px; width: 100%;overflow: hidden;text-overflow: ellipsis; white-space: nowrap;}
      .content1 li {width:100%;margin-top:20px;}
    </style>
</head>
<body id="index">
    <!-- top -->
     <jsp:include page="/WEB-INF/modules/views/common/header.jsp"></jsp:include>
    <!-- content -->
    <div class="w-content m-center">
        <span><a href="${ctx}/index.html">首页<a/></span>&nbsp;><span><a href="${ctx}/topic/hotQuestions.html">问答区</a></span>&nbsp;><span>${topic.title }</span>
         <div class="content" style="margin:0px auto;text-align:center;">
             <%-- <div class="control">
               <span class="inp">${topic.summary }</span>
             </div> --%>
             <div class="control">
             <div class="control" style="display:block;width:70%;float:left;">
               <h1 style="text-align:center;">${topic.title }</h1>
             </div>
               <span class="inp content1" style="display:block;width:67%;float:left;">
                ${topic.content }
                <div style="margin-top:50px;">
                                                                  回答（共${fn:length(replys)}条）
                   <c:forEach items="${replys }" var="reply" varStatus="vs">
                     	<li>${vs.index+1}楼   :${fns:getUserById(reply.userId).username }  <fmt:formatDate value="${reply.createDate}" pattern="yyyy年MM月dd日  hh:mm:ss"/> <br/>
                     	 ${reply.content }<li/>
                   </c:forEach>
                   </br>
                	<input type="hidden" name="topicId" value="${topic.id }"/>
                	<textarea rows="5" cols="60" name="content" style="display:none;"></textarea>
                	<script id="editor" type="text/plain" style="height:100px;"></script>
                	<input type="button" value="提交评论" id="subReply" style="width:60px;"/>
                </div>
               </span>
               <div class="unit_wrap" style="width:28%">
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
	               <div class=" unit_wrap" style="width:28%">
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
		
		$("#subReply").click(function(){
		  var content=ue.getContent();
		 //$("#content").val(ue.getContent());
		 var topicId=$("input[name='topicId']").val();
		    $.ajax({  
                    type : "POST",  //提交方式  
                    url : "${ctx}/topic/saveReply",//路径  
                    data :  {"content":content,"topicId":topicId},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="success") {  
                            alert("回复成功");
                        } else {  
                            alert(result);
                        }  
                        window.location.reload();
                    }  
                });  
		});
		
		$(function(){
		$.ajax({  
                    type : "POST",  //提交方式  
                    url : "${ctx}/topic/updateTopicClick",//路径  
                    data :  {"topicId":"${topic.id}"},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                    }  
                });  
          });
	</script>
</body>
</html>
