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
				okMatchTr.find("span[name='round']").text(match.round);
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
			   $("input[name='round']").val(match.round);
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
    	<form action="${base}/odds/matchList" method="get" name="queryForm">
    		日期:<input type="text" id="matchDate" name="matchDateStr"/>&nbsp;
    		<select name="type" >
    		     <option value="">联赛类型</option>
    			 <option value="0" <#if type??&&type==0>selected</#if>>联赛</option>
    			 <option value="1" <#if type??&&type==1>selected</#if>>杯赛</option>
    		</select>&nbsp;
    		<select name="sclass">
    		     <option value="">联赛</option>
    		     <#if mainSclassList??>
    		    	 <#list mainSclassList as mainSclass>
    		    	 	 <option value="${mainSclass.id}" <#if sclass??&&sclass?string==mainSclass.id?string>selected</#if>>${mainSclass.name!}</option>
    		     	 </#list>
    		     </#if>
    		</select>&nbsp;
    		<select name="round" >
    		     <option value="">轮次</option>
    			 <option value="0" <#if round??&&round==0>selected</#if>>无</option>
    			 <option value="1" <#if round??&&round==1>selected</#if>>有</option>
    		</select>&nbsp;
    		<select name="score" >
    		     <option value="">比分</option>
    			 <option value="0" <#if score??&&score==0>selected</#if>>无</option>
    			 <option value="1" <#if score??&&score==1>selected</#if>>有</option>
    		</select>&nbsp;
    		<select name="half_score" >
    		     <option value="">半场比分</option>
    			 <option value="0" <#if half_score??&&half_score==0>selected</#if>>无</option>
    			 <option value="1" <#if half_score??&&half_score==1>selected</#if>>有</option>
    		</select>&nbsp;
    		<select name="order">
    		 	 <option value="">排名</option>
    			 <option value="0" <#if order??&&order==0>selected</#if>>无</option>
    			 <option value="1" <#if order??&&order==1>selected</#if>>有</option>
    		</select>&nbsp;
    		<select name="time_order">
    		 	 <option value="">排序</option>
    			 <option value="0" <#if time_order??&&time_order==0>selected</#if>>时间倒序</option>
    			 <option value="1" <#if time_order??&&time_order==1>selected</#if>>时间顺序</option>
    		</select>
    		<input type="submit" name="submit" value="提交">
    	</form>
      	<#if matchList?? && matchList?size gt 0>
      			    <tr class="tdtitle">
	      			<td  class="doc_td_head_1">联赛</td>
	      			<td  class="doc_td_other">轮次</td>
	      			<td class="doc_td_other">时间</td>
	      			<td class="doc_td_other">主队</td>
	      			<td class="doc_td_other">比分</td>
	      			<td class="doc_td_other">客队</td>
	      			<td class="doc_td_other">半场</td>
	      			<td class="doc_td_other">天气</td>
	      			
	      			<td class="doc_td_other">赛季</td>
	      			<td class="doc_td_other">赔率</td>
	      			<td class="doc_td_other">立即投注</td>
	      		</tr>  
	      	<#list  matchList as match>
	      		<#if (match_index+1)%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      		<tr id="${match.fetchMatchId}_tr" class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td class="doc_td_other"  <#--onclick="updateOkMatch('${match.fetchMatchId}_sclass');return false;"-->  <#if match.sclass.color??>style="background:${match.sclass.color};color:#fff;"</#if>> ${match.sclass.name} </td>
	      			<td class="doc_td_other" ><span name="round"><#if match.round??>${match.round}</#if></span></td>
	      			<td class="doc_td_other"><span name="matchTime"><#if match.matchTime??>${match.matchTime?string("yyyy-MM-dd HH:mm")}</#if></span></td>
	      			<td class="doc_td_other" ><a href="#" <#--onclick="updateOkMatch('${match.fetchMatchId}_team_1');return false;"-->>${match.homeTeam.name}</a>[<span  name="homeOrder" ><#if match.homeOrder??>${match.homeOrder}</#if></span>]</td>
	      			<td class="doc_td_other"><#if match.homeScore??&&match.guestScore??><font color="f00000"><strong><span  name="homeScore" >${match.homeScore}</span>-<span  name="guestScore" >${match.guestScore}</span></strong></font></#if></td>
	      			<td class="doc_td_other">[<span  name="guestOrder" ><#if match.guestOrder??>${match.guestOrder}</#if></span>]<a href="#" <#--onclick="updateOkMatch('${match.fetchMatchId}_team_2');return false;"-->>${match.guestTeam.name}</a></td>
	      			<td class="doc_td_other"><span  name="homeHalfScore" ><#if match.homeHalfScore??>${match.homeHalfScore}</#if></span>-<span  name="guestHalfScore" ><#if match.guestHalfScore??>${match.guestHalfScore}</#if></span></td>
	      			
	      			<td class="doc_td_other"><span name="weather"><#if match.weather??>${match.weather}</#if></span></td>
	      			<td class="doc_td_other"><span name="season"><#if match.season??>${match.season}</#if></span></td>
	      			<td class="doc_td_other"><a href="${base}/odds/standardList?fetchMatchId=${match.fetchMatchId}">欧</a>/<a href="${base}/odds/asiaList?fetchMatchId=${match.fetchMatchId}">亚</a></td>
	      			<td class="doc_td_other">
	      					<#if match.jcKey?? && match.jcKey!=''>
	      								<a href="${base}/odds/standardOdds?matchType=0&key=${match.jcKey}"  style="color:blue">竞彩</a>
	      								<a href="${base}/odds/matchHis?matchType=0&key=${match.jcKey}"  style="color:blue">+</a>
	      								<#else>竞彩</#if>&nbsp;<#if match.dcKey?? && match.dcKey!=''><a href="${base}/odds/asiaOdds?matchType=1&key=${match.dcKey}"  style="color:blue">单场</a><#else>单场</#if>&nbsp;<#if match.zcKey?? && match.zcKey!=''><a href="${base}/odds/standardOdds?matchType=2&key=${match.zcKey}"  style="color:blue">足彩</a><#else>足彩</#if>&nbsp;<a href="http://www.okooo.com/soccer/match/${match.fetchMatchId!}/" target="_blank"  style="color:blue">澳客</a>&nbsp;<a href="#" style="color:blue" onclick="getMatchDetial('${match.fetchMatchId}');return false;">修正</a></td>
	      		</tr>   	
	      	</#list>
      	</#if>    
    </table>
  </div>