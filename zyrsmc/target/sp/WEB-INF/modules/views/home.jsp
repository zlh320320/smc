<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/modules/sys/common.jsp"  %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${site.siteName }</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="${site.keywords }" />
    <meta name="description" content="${site.siteDesc }" />
    <link type="text/css" href="${ctx}/static/css/index.css" rel="stylesheet" />
    <link type="text/css" href="${ctx}/static/css/online.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/jquery.slideBox.css" /> 
      
    <style type="text/css">
    </style>
</head>
<body id="index">
    <!-- top -->
    <%@include file="/WEB-INF/modules/views/common/header.jsp"  %>
    <div id="slideBox" class="slideBox m-center" >
	  <ul class="items">
	    <c:forEach items="${bannerList }" var="banner">
         <li><a href="${ctx}/topic/detail/${banner.id}.html" title="${banner.title }"><img src="${ctx}/${banner.picture}"></a></li>
	    </c:forEach>
	  </ul>
	</div>
    <!-- content -->
    <div class="w-content m-center">
        <div class="con-right fl">
            <div class="ztz">
              <!--   <h1>
                    热点话题
                </h1> -->
                <div class="qsg">
                    <div class="zwysh fl">
                        <h5 class="item-title">
                            菜鸟进阶<span><a href="${ctx}/topic/list/15.html">更多</a></span>
                        </h5>
                        <div class="zhtt">
                         <c:forEach items="${lowTopicList }" var="banner" varStatus="vs">
                          <c:if test="${vs.index eq 0 }">
				         <li style="width:80%;"><a href="${ctx}/topic/detail/${banner.id}.html" title="${banner.title }"><img src="${ctx}/${banner.picture}"></a></li>
                          </c:if>
					    </c:forEach>
                         <c:forEach items="${lowTopicList }" var="topic" varStatus="vs">
                          <c:if test="${vs.index==0 }">
                            <h6>
                                <a href="${ctx}/topic/detail/${topic.id}.html" class="io-tt">${topic.title}</a>
                            </h6>
                            <p class="io-wzjs" style="max-height: 90px;">
                              ${topic.summary}
                            </p>
                             <a href="${ctx}/topic/detail/${topic.id}.html" class="io-xq" style="color:#42972b;float:right;font-size:13px;">详细</a>
                            </c:if>
                           </c:forEach>
                        </div>
                        <ul class="zwysh-list">
                           <c:forEach items="${lowTopicList }" var="topic" varStatus="vs">
                            <c:if test="${vs.index>0 }">
                            <li><a href="${ctx}/topic/detail/${topic.id}.html" title="${topic.title}">${topic.title}</a></li>
                            </c:if>
                           </c:forEach>
                        </ul>
                    </div>
                    <div class="kksc fr">
                        <div class="kkrj" style="height:210px;">
                            <h5 class="item-title">
                                高手分享<span><a href="${ctx}/topic/list/13.html">更多</a></span>
                            </h5>
                           <%--  <a href="#">
                                <img src="${ctx}/static/images/100_120394953194a3fef0f_15_1438047745.png" alt="" />
                            </a> --%>
                            <ul class="kkrj-list">
                            	<c:forEach items="${highTopicList }" var="topic" varStatus="vs">
                                <li><a href="${ctx}/topic/detail/${topic.id}.html" title="${topic.title}">${topic.title}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="sczd">
                            <h5 class="item-title">
                                猿来如此<span><a href="${ctx}/topic/hotQuestions.html">更多</a></span>
                            </h5>
                            <div class="sczd-con">
                            	<c:forEach items="${qaList }" var="topic" varStatus="vs">
                            	<c:if test="${vs.index==0 }">
                                <h6>
                                    <a href="${ctx}/topic/showQuestion/${topic.id}.html" class="io-tt">${topic.title}</a>
                                </h6>
                                <p class="io-wzjs" style="max-height: 90px;">
                                    ${topic.summary}
                                </p><a href="${ctx}/topic/showQuestion/${topic.id}.html" class="io-xq"  style="color:#42972b;float:right;font-size:13px;">详细</a>
                                </c:if>
                                </c:forEach>
                            </div>
                            <ul class="sczd-list">
                            <c:forEach items="${qaList }" var="topic" varStatus="vs">
                            	<c:if test="${vs.index>0 }">
                                <li><a href="${ctx}/topic/showQuestion/${topic.id}.html" title="${topic.title}">${topic.title}</a></li>
                                 </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
           
            </div>
        </div> 
        <div class="con-left fr">
            <div class="zxxz">
                <h3 class="title">
                    最新加入<span><!-- <a href="#">更多</a> --></span>
                </h3>
                <c:forEach items="${lastUserList }" var="us">
	                <div class="sub-item">
	                    <div class="pic">
	                        <a href="#">
	                            <img src="${ctx}/${us.avatar ==null||us.avatar ==''?'static/front/images/default_avatar.png':us.avatar }" alt="" />
	                        </a>
	                    </div>
	                    <div class="info">
	                        <a href="${ctx}/my/myinfo/${us.userId}.html" class="xzmc">${us.username }</a>
	                        <p>
	                            ${us.nickName }
	                        </p>
	                    </div>
	                </div>
                </c:forEach>
            </div>
            <div class="unit_wrap">
                <h3 class="title">
                   最近活跃<span></span>
                </h3>
                <ul class="star">
                	<c:forEach items="${loginLogs }" var="ll">
                    <li>
                        <div class="elite_wrap">
                            <a class="user_ava" href="#">
                                <img src="${ctx}/${ll.avatar ==null||ll.avatar ==''?'static/front/images/default_avatar.png':ll.avatar }" alt="" />
                            </a>
                            <div class="user_intro">
                                <a href="${ctx}/my/myinfo/${ll.userId}.html">${ll.username }</a>
                                <!-- <p class="user_grade">
                                    	粉丝数<em>100</em>
                                </p> -->
                                 <p class="user_grade">
                              		${ll.nickName }
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
    
    <div class="main-im">
	<div id="open_im" class="open-im">&nbsp;</div>  
	<div class="im_main" id="im_main">
		<div id="close_im" class="close-im"><a href="javascript:void(0);" title="点击关闭">&nbsp;</a></div>
		<a href="http://wpa.qq.com/msgrd?v=3&uin=740627371&site=qq&menu=yes" target="_blank" class="im-qq qq-a" title="在线QQ客服">
			<div class="qq-container"></div>
			<div class="qq-hover-c"><img class="img-qq" alt="QQ在线咨询" src="${ctx}/static/images/qq.png"></div>
			<span> QQ在线咨询</span>
		</a>
		<!-- <div class="im-tel">
			<div></div>
			<div class="tel-num"></div>
		</div> -->
		<div class="im-footer" style="position:relative">
			<div class="weixing-container">
				<div class="weixing-show">
					<div class="weixing-txt">微信扫一扫</div>
					<img class="weixing-ma" alt="微信扫一扫" src="${ctx}/static/images/weixing-ma.jpg">
					<div class="weixing-sanjiao"></div>
					<div class="weixing-sanjiao-big"></div>
				</div>
			</div>
			<div class="go-top"><a href="javascript:;" title="返回顶部"></a> </div>
			<div style="clear:both"></div>
		</div>
	</div>
</div>
     <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
      <script type="text/javascript" src="${ctx}/static/js/index.js"></script>
   <script type="text/javascript" src="${ctx}/static/js/jquery.slideBox.js"></script> 
    <script type="text/javascript">
        $(".topNav .current").removeClass("current");
        $(".topNav .cur0").addClass("current");
        
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
                    }  
                });  
         }
        
$(function(){
	$('#close_im').bind('click',function(){
		$('#main-im').css("height","0");
		$('#im_main').hide();
		$('#open_im').show();
	});
	$('#open_im').bind('click',function(e){
		$('#main-im').css("height","272");
		$('#im_main').show();
		$(this).hide();
	});
	$('.go-top').bind('click',function(){
		$(window).scrollTop(0);
	});
	$(".weixing-container").bind('mouseenter',function(){
		$('.weixing-show').show();
	})
	$(".weixing-container").bind('mouseleave',function(){        
		$('.weixing-show').hide();
	});
	
	 $("#slideBox").slideBox({
		duration : 0.6,//滚动持续时间，单位：秒
		easing : 'linear',//swing,linear//滚动特效
		delay : 5,//滚动延迟时间，单位：秒
		hideClickBar : false,//不自动隐藏点选按键
		clickBarRadius : 10
	}); 
});
</script>
</body>
</html>
