<meta name="decorator" content="doc" />
 
 <style>
 	.hideDiv{display:none;}
 </style>
 
<script type="text/javascript">
 function sumbitOkMatch(fetchMatchId){
	 $("#"+fetchMatchId+"_form").ajaxSubmit({
	     type: "post",
	     url: window.BASESITE+"/odds/updateMatch",
	     success: function(match){
	     		var okMatchTr = $("#"+fetchMatchId+"_tr");
	     	   	okMatchTr.find("span[name='matchTime']").text(new Date(match.matchTime).format("yyyy-MM-dd hh:mm"));
				okMatchTr.find("span[name='homeOrder']").text(match.homeOrder);
				okMatchTr.find("span[name='homeScore']").text(match.homeScore);
				okMatchTr.find("span[name='guestScore']").text(match.guestScore);
				okMatchTr.find("span[name='guestOrder']").text(match.guestOrder);
				okMatchTr.find("span[name='homeOrder']").text(match.homeOrder);
				okMatchTr.find("span[name='homeHalfScore']").text(match.homeHalfScore);
				okMatchTr.find("span[name='guestHalfScore']").text(match.guestHalfScore);
				okMatchTr.find("span[name='weather']").text(match.weather);
				okMatchTr.find("span[name='season']").text(match.season);
				okMatchTr.find("span[name='jcKey']").text(match.jcKey);
				okMatchTr.find("span[name='dcKey']").text(match.dcKey);
				okMatchTr.find("span[name='zcKey']").text(match.zcKey);
				okMatchTr.find("span[name='season']").text(match.season);
				$("#dialogurl").dialog('close');
	          	window.alert("更新成功");
	     },
	     error:function(){
	     		window.alert("更新失败");
	     }
 	});
 	
}
function getMatchDetial(fetchMatchId){ 
	 var url =  window.BASESITE+"/odds/getMatchDetial?fetchMatchId="+fetchMatchId; 	
	 Miracle.getURL({
            url: url,
            width:600,
            title:'处理比赛',
            modal:false
    });
		
}
$(function() {
	   $("#matchDate").datepicker({
	        currentText: '现在',
			closeText: '完成',
	        dateFormat: 'yy-mm-dd',
		    monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    monthNamesShort: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    dayNamesMin: ['日','一','二','三','四','五','六'],
			defaultDate: "+1w",
			changeMonth: true,
			changeYear: true,
		  });
});
function autoUpdateOkMatch(fetchMatchId){
  		var url =  window.BASESITE+"/odds/autoUpdateMatch?fetchMatchId="+fetchMatchId;
  		Miracle.getData({
            url: url,
            callBack:function(match){
               $("input[name='matchTimeStr']").val(new Date(match.matchTime).format("yyyy-MM-dd hh:mm"));
			   $("input[name='homeOrder']").val(match.homeOrder);
			   $("input[name='homeScore']").val(match.homeScore);
			   $("input[name='guestScore']").val(match.guestScore);
			   $("input[name='guestOrder']").val(match.guestOrder);
			   $("input[name='homeOrder']").val(match.homeOrder);
			   $("input[name='homeHalfScore']").val(match.homeHalfScore);
			   $("input[name='guestHalfScore']").val(match.guestHalfScore);
			   $("input[name='weather']").val(match.weather);
			   $("input[name='season']").val(match.season);
			   $("input[name='jcKey']").val(match.jcKey);
			   $("input[name='dcKey']").val(match.dcKey);
			   $("input[name='zcKey']").val(match.zcKey);
			   $("input[name='season']").val(match.season);
			   $("input[name='isJc']").val(match.isJc);
			   $("input[name='isDc']").val(match.isDc);
			   $("input[name='isZc']").val(match.isZc);
            }
        });
}	
	


</script>
<div class="mright">
	
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
    	<form action="${base}/odds/failMatchDateList" method="get" name="queryForm">
    		日期:<input type="text" id="matchDate" name="matchDateStr"/>&nbsp;
    		<select name="isCheck" onchange="document.forms['queryForm'].submit();return false;" >
    		     <option value="">是否检查</option>
    			 <option value="true" <#if isCheck?? && isCheck==true>selected</#if>>已检查</option>
    			 <option value="false" <#if isCheck?? && isCheck==false>selected</#if>>未检查</option>
    	 
    		<input type="submit" name="submit" value="提交">
    	</form>
      	<#if failMatchDateList?? && failMatchDateList?size gt 0>
      			    <tr class="tdtitle">
	      			<td  class="doc_td_head_1">赛事日期</td>
	      			<td  class="doc_td_other">应有条目</td>
	      			<td  class="doc_td_other">实际条目</td>
	      			<td class="doc_td_other">解释失败的ID</td>
	      			<td class="doc_td_other">是否已检查</td>
	      		 	<td class="doc_td_other">更新</td>
	      		</tr>  
	      	<#list  failMatchDateList as match>
	      		<#if (match_index+1)%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      		<tr id="${match.matchDate}_tr" class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td class="doc_td_other" ><span name="matchDate">${match.matchDate}</span>  </td>
	      			<td class="doc_td_other" ><span name="fetchCount"><#if match.fetchCount??>${match.fetchCount} </#if></span></td>
	      			<td class="doc_td_other" ><span name="matchCount"><#if match.matchCount??>${match.matchCount} </#if></span></td>
	      			<td class="doc_td_other" ><span name="failId"><#if match.failId??>${match.failId} </#if></span></td>
	      			<td class="doc_td_other" ><span name="isCheck"><#if match.isCheck?? && match.isCheck==false>X</#if></span></td>
	      			<td class="doc_td_other">更新</td>
	      		</tr>   	
	      	</#list>
      	</#if>    
    </table>
  </div>