
$(document).ready(function(){
	page();
});

function page(){
	var pageNo=parseInt($("input[name='pageNo']").val());
	var totalPage=parseInt($("input[name='totalPage']").val());
	var html="";
	
	if(pageNo<=1){
		html+="<a style='width:50px;'>上一页</a>";
	}else{
		html+="<a style='width:50px;' onclick='prePage()'>上一页</a>";
	}
	
	if(pageNo<=5){
		var tp=pageNo;
		if(totalPage<=5){
			tp=totalPage;
		}
		
		for(var i=1;i<=tp;i++){
			var activeClass="";
			if(pageNo==i){
				activeClass="cur";
			}
			html+="<span  class='"+activeClass+"'><a onclick='goToPage("+i+")' >"+i+"</a></span>";
		}
	}
	
	if(pageNo>5){
		var tp=pageNo+3;
		if(totalPage<=tp){
			tp=totalPage;
		}
		for(var i=pageNo-2;i<=tp;i++){
			if(pageNo==i){
				activeClass="active";
			}
			html+="<span  class='"+activeClass+"'><a onclick='goToPage("+i+")' >"+i+"</a></span>";
		}
	}
	
	if(pageNo>=totalPage){
		html+="<a class='disabled' style='width:50px;'>下一页</a>";
	}else{
		html+="<a onclick='nextPage()' style='width:50px;'>下一页</a>";
	}
	$(".page").append(html);
}

function goToPage(pageNo){
	$("input[name='pageNo']").val(parseInt(pageNo));
	search();
}

function prePage(){
	var pageNo=$(".page").find(".cur").find("a").html();
	goToPage(parseInt(pageNo)-1);
}

function nextPage(){
	var pageNo=$(".page").find(".cur").find("a").html();
	goToPage(parseInt(pageNo)+1);
}

function search(){
	$("#searchForm").submit();
}