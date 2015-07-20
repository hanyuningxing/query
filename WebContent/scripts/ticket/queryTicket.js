$(document).ready(function (){
	$('#searchBtn').bind('click',queryLsit);
});

function queryLsit(){
	var url = "/ticket/query";
	var formObj = $("#searchForm");
	formObj.attr("action",url);
	formObj.submit();
}


//function ajaxSubmit(){
//	jQuery("#searchResult").jqGrid({
//		url : "/ticket/query",
//		datatype: "json",
//		colNames:['订单号'],
//		colModel:[  
//		            {name:'orderNo', index:'orderNo', width:80}
//        ],  
//		rowNum:10,
//	   	rowList:[10,20,30]
//	}
//	$("#searchResult").grid({
//		url : "/ticket/query",
//		method : "get",
//		pageSize : 10,
//		isREST : false,
//		root : "orderList",
//		pageTheme : 'Theme1',
//		defaultParams : $("#searchForm").serialize(),
//			fields : [
//			{
//				name : "订单号",
//				id : "orderNo",
//				render : function(data) {
//					return $('<span />').addClass(
//							'cor2')
//							.html(data.orderNo);
//				}
//			}
//        ],
//        callback : function(data, start, end) {
//			total = data.total;
//			if (data.orderList == ''
//					|| data.orderList.length == 0) {
//				$("#searchResult").html('没有符合条件的交易记录。');
//			}
//
//		},
//		error : function(data) {
//			$("#searchResult").html('没有符合条件的交易记录.');
//		}
//	}
//);
//}