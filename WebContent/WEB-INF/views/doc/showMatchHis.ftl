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
<script src="${base}/scripts/lottery/match_history.js"></script>
<div class="mright">

    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      	<#if matchHisList?? && matchHisList?size gt 0>
	      	<#list  matchHisList as matchHis>
	      		<tr class="tdgraylist"><td>${matchHis}</td>
	      			<td><a  onclick="showMatchHisTips(this,'${matchHis}',0);return false;">主队主场</a></td>
	      			<td><a  onclick="showMatchHisTips(this,'${matchHis}',1);return false;">主队客场</a></td>
	      			<td><a  onclick="showMatchHisTips(this,'${matchHis}',2);return false;">客队主场</a></td>
	      			<td><a  onclick="showMatchHisTips(this,'${matchHis}',3);return false;">客队客场</a></td>
	      			<td><a  onclick="showMatchHisTips(this,'${matchHis}',4);return false;">主队交锋</a></td>
	      			<td><a  onclick="showMatchHisTips(this,'${matchHis}',5);return false;">客队交锋</a></td>
	      		</tr>
	      		<tr><td colspan="6" id="_${matchHis}_matchHis"></td></tr>
	      	</#list>
      	</#if>
       
    </table>
    <div><a onclick="saveToMatchHisFinal();" class="dicon3">确认</a></div>
      <#if matchHisList_errror?? >
      ${matchHisList_errror}
      </#if>
      <div class="alert-info">
      		<span>历史赔率没数据时，尝试按这个..比较耗时.</span>
      		<a href="#" onclick="fetchMatchHis();return false;" class="btn btn-primary">抓</a>
      </div>
  </div>