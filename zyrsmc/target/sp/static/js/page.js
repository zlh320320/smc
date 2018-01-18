
$(document).ready(function(){
	page();
});

function page(){
	var pageNo=parseInt($("input[name='pageNo']").val());
	var totalPage=parseInt($("input[name='totalPage']").val());
	
	var html="<nav><ul class='pagination pagination-lg'>";
	
	if(pageNo<=1){
		html+="<li class='disabled'><a aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
	}else{
		html+="<li><a aria-label='Previous' onclick='prePage()'><span aria-hidden='true'>&laquo;</span></a></li>";
	}
	
	if(pageNo<=5){
		var tp=pageNo;
		if(totalPage<=5){
			tp=totalPage;
		}
		
		for(var i=1;i<=tp;i++){
			var activeClass="";
			if(pageNo==i){
				activeClass="active";
			}
			html+="<li class='"+activeClass+"'><a href='#' onclick='goToPage("+i+")'>"+i+"</a></li>";
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
			html+="<li class='"+activeClass+"'><a href='#' onclick='goToPage("+i+")'>"+i+"</a></li>";
		}
	}
	
	if(pageNo>=totalPage){
		html+="<li class='disabled'><a aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
	}else{
		html+="<li><a href='#' aria-label='Next' onclick='nextPage()'><span aria-hidden='true'>&raquo;</span></a></li>";
	}
	html+="</ul></nav>";
	$("#pageId").append(html);
}

function goToPage(pageNo){
	$("input[name='pageNo']").val(parseInt(pageNo));
	search();
}

function prePage(){
	var pageNo=$(".pagination").find(".active").find("a").html();
	goToPage(parseInt(pageNo)-1);
}

function nextPage(){
	var pageNo=$(".pagination").find(".active").find("a").html();
	goToPage(parseInt(pageNo)+1);
}