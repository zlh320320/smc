<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
     	          <form method="post" id="searchForm" class="searchform" action="${ctx}/content/getContentList">
					 <input type="hidden" name="pageNo" value="${page.page }">
					  <input type="hidden" name="pageSize" value="${page.limit }">
					  <input type="hidden" name="columnId" value="${columnId}">
					  <input type="hidden" name="totalPage" value="${page.totalPages }">
              		      标题 :<input name="title" type="text" value="${title }">
                       <a class="search_btn"  >查询</a>
                       <a class="add_btn" data-id="-1"  >新增新闻</a>
                     </form>
      
           <table>
           	  <thead>
                 <tr>
                    <th style="width:200px">标题</th>
                    <th style="width:80px">分类</th>
                    <th style="width:80px">作者</th>
                    <th style="width:80px">创建时间</th>
                    <th style="width:80px">排序</th>
                    <th style="width:80px">点击量</th>
                    <th style="width:80px">操作</th>
                 </tr>
           	  </thead>
              <tbody>
                  <c:forEach items="${contentList }" var="content">
					      <tr>
					         <td>${content.title }</td>
					         <td>【${fns:getColumnById(content.columnId).columnName}】</td>
					         <td>${content.editor}</td>
					         <td><fmt:formatDate value="${content.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					         <td>${content.orderFlag}</td>
					         <td>${content.clickNum}</td>
					         <td>
					         <a  class="edit_btn" data-id="${content.id}" >编辑</a>
                       		 <a  class="del_btn" data-id="${content.id}" >删除</a>
					         </td>
					      </tr>
					   	</c:forEach>
              </tbody>
           </table>
           <div class="page" id="page"></div>
<script type="text/javascript">
$(".search_btn").click(function(){
	 search();
});
   $(".edit_btn,.add_btn").click(function(){
         var id=$(this).attr("data-id");
         parent.layer.open({
		  type: 2,
		  area: ['800px', '600px'],
		  fixed: false, //不固定
		  maxmin: true,
		  content: "${ctx}/content/getContent?id="+id
		});
   });

   $(".del_btn").click(function(){
	   var id=$(this).attr("data-id");
       layer.confirm('确认删除该新闻吗？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			$.ajax({
	               url:'${ctx}/content/delContent',
	               type:"POST",
	               data:{"id":id},
	               dataType:"json",
	               success:function(data){
	                 if(data=="success")
	                   {
	                    alert("删除成功!");
	                    search();
	                   }
	               }
	           });
		   layer.closeAll();
		}, function(){
		});
   });
$(function(){
	   layui.use('laypage', function(){
	  	  var laypage = layui.laypage;
	  //执行一个laypage实例
		 laypage.render({
		  elem: 'page'
		  ,curr:"${page.page }"
		  ,count: "${page.totalCount }" //数据总数，从服务端得到
		  ,jump: function(obj, first){
		    if(!first){
		      //do something
		   	  $("#input[name='pageNo']").val(obj.curr);
		   	  search("columnId=${columnId}&pageNo="+obj.curr);
		    }
		  }
		});
	});
	
});
   
  
</script>