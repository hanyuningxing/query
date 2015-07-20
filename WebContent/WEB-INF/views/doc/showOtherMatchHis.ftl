<meta name="decorator" content="doc" />
<script>
      function getMD5(){
        var wAction = $('input[id=wAction]').val();
        var wAgent = $('input[id=wAgent]').val();
        var wParam = $('textarea[id=wParam]').val();
        var wKey = $('input[id=wKey]').val();
        Miracle.ajaxData({
            url: '/test/md5',
            data:{
               md5:wAction+wParam+wAgent+wKey
            },
            callBack:function(jsonObj){
               
               $('input[id=wSign]').val(jsonObj.md5);
            }
        });
      }
      function getError(){
        Miracle.getURL({
            url: '/doc/error',
            width:300,
            title:'处理结果',
            modal:false
        });
      }
      var fetchMatchHisFlag= true;
      function fetchMatchHis(){
      	var url = window.BASESITE+"/matchHis/fetchMatchHis";
      	if(fetchMatchHisFlag){
      		fetchMatchHisFlag = false;
	      	$.ajax({
	      		type : "GET", 
	      		url:url,
	      		success:function(json){
	      					alert(json[0]);
	      					fetchMatchHisFlag=true;
	      				},
	      		error:function(){
	      					fetchMatchHisFlag=true;
	      					alert("error");
	      				}
	      	});
      	}
      }
</script>
<style>
	.alert-info{
		background-color:#3a87ad;
		padding:20px;
		width:98%;
	}
</style>
<link href="${base}/styles/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="${base}/scripts/lottery/other_match_history.js"></script>
<div class="mright">
	<div class="alert alert-info" style="float:left">
		<#if dateTimeList?? && dateTimeList?size gt 0>
			<#list dateTimeList as date>
				<a href="${base}/matchHis/showOtherMatchHis?dateTime=${date}" class="btn btn-primary">${date}</a>
			</#list>
		</#if>
	</div>
    <table class="table">
      	<#if matchList?? && matchList?size gt 0>
	      	<#list  matchList as matchHis>
	      		${matchHis} 
	      	</#list>
      	</#if>
       
    </table>
    <#if errorMsg ??>
    	<div class="alert alert-error">${errorMsg}</div>
    </#if>
  </div>