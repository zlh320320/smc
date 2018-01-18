<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/modules/sys/common.jsp"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>编辑栏目</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="java学习 Java开发 软件开发 大数据 java论坛" />
    <meta name="description" content="旨在为大家建议一个java学习的社区。" />
    <link type="text/css" href="${ctx}/static/css/index.css" rel="stylesheet" />
    <link type="text/css" href="${ctx}/static/front/css/topic.css" rel="stylesheet" />

</head>
<body id="index">
    <!-- top -->
    <!-- content -->
    <div class="w-content m-center">
       <form action="${ctx }/content/saveColumn" method="post" id="inputForm">
        <input type="hidden" name="id" value="${column.id }"/>
         <div class="content">
             <div class="control">
               <label>父栏目:</label>
               <span class="inp">
                <select name="parentId" style="width:300px;height:30px;">
                   <option value="0">根目录</option>
                     <c:forEach items="${fns:getColumnList(1)}" var="col">
                       <c:if test="${col.parentId ==0 }">
	                       <option value="${col.id}" ${col.id eq pcolumn.id?'selected=selected':'' }>
	                       ${col.columnName}</option>
                       </c:if>
                     </c:forEach>
                   </select>
                
               </span>
             </div>
             <div class="control">
               <label>栏目名称:</label>
               <span class="inp"><input class="width300" type="text" value="${column.columnName }" name="columnName"/></span>
             </div>
             <div class="control">
               <label>排序</label>
               <span class="inp"><input class="width300" type="text" value="${column.orderFlag }" name="orderFlag"/></span>
             </div>
             <div class="control">
               <label>是否显示:</label>
               <span class="inp">
                <select name="isShow" style="width:300px;height:30px;">
                  <option value="1" ${column.isShow eq 1?'selected=selected':'' }>是</option>
                  <option value="0" ${column.isShow==null||column.isShow eq 0?'selected=selected':'' }>否</option>
               </select>
               </span>
             </div>
             <div class="control">
               <label>是否菜单:</label>
               <span class="inp">
               <select name="isMenu" style="width:300px;height:30px;">
                  <option value="1" ${column.isMenu eq 1?'selected=selected':'' }>是</option>
                  <option value="0" ${column.isMenu==null||column.isMenu eq 0?'selected=selected':'' }>否</option>
               </select>
               </span>
             </div>
             
             <div class="operation">
                 <input type="button" id="saveBtn" value="保存"/>
             </div>
         </div>
         </form>
    </div>
    <!-- foot -->
        <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/index.js"></script>
     <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
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
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭 
                    }  
                });  
		});
	</script>
</body>
</html>
