<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
<link rel="icon" href="${ctxStatic}/front/images/toplogo.ico" type="image/x-ico" />
 <script>
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "https://hm.baidu.com/hm.js?908adcddca6e82580ed95f2e15109ca5";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
	</script>
   <div class="head-bg">
        <div class="w-content m-center head">
            <div class="head-left fl">
                <a href="${ctx}/index.html">
                    <img src="${ctx}/static/images/logo.png" alt="java学习社区" />
                </a>
            </div>
            <div class="head-right fr">
              <form action="${ctx}/search/searchTopics/0.html" method="post" id="searchAll">
                <div class="contribute-bg">
                	<c:if test="${user==null }">
                	   <span><a href="${ctx}/topic/getTopic/-1.html" class="contribute" target="BLANK">投稿</a></span>
	                     <span><a href="${ctx}/register.html">注册</a></span>
	                    <span><a href="${ctx}/login.html">登录 </a></span>
                	</c:if>
                	<c:if test="${user!=null }">
                	   <c:if test="${user.isAdmin eq 1 }">
                	     <span> <a href="${ctx}/main" target="_BLANK" style="border: 1px solid;background-color:#30ca5f;">进入后台</a></span>
                	   </c:if>
                	   <span><a href="${ctx}/topic/getTopic/-1.html" class="contribute" target="BLANK">投稿</a></span>
                	   <span><a href="${ctx}/my/myinfo/${user.userId}.html">${user.username }</a><a href="${ctx}/logout">[退出]</a></span><span> 欢迎您，</span>
                	</c:if>
                </div>
                <div class="search-bg" id="so_mid">
                    <input id="so" class="txt-search fl" placeholder="请输入关键词" type="text" name="tagName" value="${tagName }"/>
                    <a id="so_bin" class="btn-search fr"></a>
                </div>
                </form>
            </div>
        </div>
        <div class="w-content m-center nav">
            <ul class="topNav">
                <li><a href="${ctx}/index.html" class="cur0">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
                    <li><a href="${ctx}/topic/hotTopics.html" class="cur1">热点话题</a></li>
                 <li><a href="${ctx}/topic/hotQuestions.html" class="cur2">我想知道</a></li>
                 <c:set var="cc" value="3"></c:set>
                <c:forEach items="${fns:getColumnList(1)}" var="col">
                 <c:if test="${col.parentId eq 0 && col.isMenu eq 1}">
                    <li data-id="${col.id}"><a href="${ctx}/topic/list/${col.id}.html" class="cur${cc} ">${col.columnName }</a>
                      <div class="son"> <a>java</a><a>大数据</a><a>人工智能</a></div>
                    </li>
                  <c:set var="cc" value="${cc+1}"></c:set>
                 </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
     <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
       $("#so_bin").click(function(){
        $("#searchAll").submit();
       });
       
    </script>
    <script>
(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';        
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>