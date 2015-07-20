<meta name="decorator" content="doc" />
 
 <style>
 	.hideDiv{display:none;}
 </style>
  
 <script>
 	function upOrDown($tr,name){
 		try{
 				var i = $tr.attr("i"); 
 				$span = $tr.find("span[name='"+name+"']");
 				var value= parseFloat($span.text()) -parseFloat($("tr[name='tr_"+i+"']").find("span[name='"+name+"']").text());
 				if(value>0){
 					$span.css({"color":"red"});
 					$span.html($span.html()+"<i>↑</i>");
 				}else if(value<0){
 					$span.css({"color":"blue"});
 					$span.html($span.html()+"<i>↓</i>");
 				}
 			}catch(e){
 			}
 	}
 
 	function formatOdds(){
 		var $tr = $("tr[name]");
 		var homeWin,standoff,guestWin;
 		$tr.each(function(){
 			try{
 				homeWin =parseFloat($(this).find("span[name='homeWin']").text())/1000;	
 				$(this).find("span[name='homeWin']").text(toDecimal(homeWin));
 				
 				standoff =parseFloat($(this).find("span[name='standoff']").text())/1000;
 				$(this).find("span[name='standoff']").text(toDecimal(standoff));
 				
 				guestWin =parseFloat($(this).find("span[name='guestWin']").text())/1000;
 				$(this).find("span[name='guestWin']").text(toDecimal(guestWin));
 			}catch(e){
 			
 			}
 		});
 		var $span ;
 		$tr.each(function(){
 		 
 				upOrDown($(this),"homeWin");
 				upOrDown($(this),"standoff");
 				upOrDown($(this),"guestWin");
 				 
 		});
 	}
 	
 	$(function(){
 		formatOdds();
 	});
 	
 	
 </script>
  
<div class="mright">
	
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
    	 
      		<#if oddsList?? && oddsList?size gt 0>
      		   <tr class="tdtitle">
	      			<td  class="doc_td_head_1">时间</td>
	      			<td  class="doc_td_other">胜</td>
	      			<td class="doc_td_other">平</td>
	      			<td class="doc_td_other">负</td>
	      	 </tr>  
	      	<#list  oddsList as odds>
	      		<#if (odds_index+1)%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      		<tr  name="tr_${odds_index}" i="${odds_index+1}" class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td class="doc_td_other"><#if odds.createTime??>${odds.createTime?string("yyyy-MM-dd HH:mm")}</#if></td>
	      			<td class="doc_td_other"><span name="homeWin"><#if odds.homeWin??>${odds.homeWin}</#if></span></td>
	      			<td class="doc_td_other"><span name="standoff"><#if odds.standoff??>${odds.standoff}</#if></span></td>
	      			<td class="doc_td_other"><span name="guestWin"><#if odds.guestWin??>${odds.guestWin}</#if></span></td>
	      		 </tr>   	
	      	</#list>
      	</#if>    
    </table>
  </div>