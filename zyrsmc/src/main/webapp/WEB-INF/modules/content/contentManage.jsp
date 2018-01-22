<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/modules/sys/common.jsp"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctxStatic }/content/css/common.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic }/content/css/content.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic }/content/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic }/content/layer-v3.1.0/layui-master/dist/css/layui.css">
<style type="text/css">
.add_btn{float:right;margin-right:10px;}
table{border-collapse: collapse;width:100%;}
table thead{width:99%;}
table thead tr{width:100%;border-bottom: 1px solid #ccc;border-top: 1px solid #ccc;}
table thead th{background-color:#f2f2f2;width:auto;padding-left:10px;padding-right:10px;text-align: center;line-height:30px;height:30px;}
table tbody tr{    border-bottom: 1px solid #e7eaec;}
table tbody td{width:auto;padding-left:10px;padding-right:10px;line-height:40px;height:40px; white-space: nowrap;overflow: hidden;text-overflow: ellipsis;margin:auto;text-align: center;}
.ztree li span.button.add {
    margin-left: 2px;
    margin-right: -1px;
    background-position: -144px 0;
    vertical-align: top;
}

</style>

<title></title>
</head>
<body>
<div class="main_col">
     <div class="lefttree fl">
          <ul id="treeDemo" class="ztree"></ul>
     </div>
     <div class="rightcon fr">
     	          
     </div>
</div>
<script type="text/javascript" src="${ctxStatic }/content/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${ctxStatic }/content/zTree_v3/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="${ctxStatic }/content/layer-v3.1.0/layer/layer.js"></script>
<script type="text/javascript" src="${ctxStatic}/content/layer-v3.1.0/layui-master/dist/layui.js"></script>
<script type="text/javascript">

$(".rightcon").load("${ctx}/content/getContentList",function(){});
function search(params){
	$(".rightcon").load("${ctx}/content/getContentList?"+params,function(){});
}
var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename,
				onClick:onClick
			}
		};

		var zNodes =[
		];
		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeEditName(treeId, treeNode) {
			var id=treeNode.id;
			var pid=treeNode.pId;
			if(pid==null)
				pid=0;
			parent.layer.open({
				  type: 2,
				  area: ['800px', '600px'],
				  fixed: false, //不固定
				  maxmin: true,
				  content: "${ctx}/content/getColumn?id="+id+"&pid="+pid
				});
			return false;
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 [ " + treeNode.name + "] 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			var id=treeNode.id;
			$.ajax({  
                type : "POST",  //提交方式  
                url : "${ctx}/content/delColumn",//路径  
                data:{"id":id},
                dataType: "JSON", 
                success : function(result) {//返回数据根据结果进行相应的处理  
					$("#addBtn_"+treeNode.tId).unbind().remove();
                }
            }); 
		}
		function beforeRename(treeId, treeNode, newName, isCancel) {
			return true;
		}
		function onRename(e, treeId, treeNode, isCancel) {
			
		}
		
		function onClick(e, treeId, treeNode){
			 $(".rightcon").load("${ctx}/content/getContentList?columnId="+treeNode.id,function(){});

		}
		
		function showRemoveBtn(treeId, treeNode) {
			if(treeNode.level==0)
				return false;
			return true;
		}
		function showRenameBtn(treeId, treeNode) {
			if(treeNode.level==0)
				return false;
			return true;
		}
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			if(treeNode.level<2)
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var id=treeNode.id;
				parent.layer.open({
					  type: 2,
					  area: ['800px', '600px'],
					  fixed: false, //不固定
					  maxmin: true,
					  shadeClose:true,
					  content: "${ctx}/content/getColumn?id=0&pid="+id
					});
				//var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				//zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
		};
		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
		}
		
		$(document).ready(function(){
			$.ajax({  
                type : "POST",  //提交方式  
                url : "${ctx}/content/columnTree",//路径  
                async:false,
                dataType: "JSON", 
                success : function(result) {//返回数据根据结果进行相应的处理  
                	zNodes=result; 
                }
            }); 
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			$("#selectAll").bind("click", selectAll);
		});
</script>
  
</body>
</html>

