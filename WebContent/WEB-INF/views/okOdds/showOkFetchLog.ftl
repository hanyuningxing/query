<meta name="decorator" content="doc" />
 
 <style>
 	.hideDiv{display:none;}
 </style>
 
<script type="text/javascript">
 
	 
$(function() {
 
	
      function fetchLogHtml(id){ 
		    if ($("#dialogurl").length == 0) {  
		           $("body").append('<div id="dialogurl" style="background-color:white"></div>');
			       $("#dialogurl").dialog({
			            autoOpen: false,
			            title: 'update',
			            modal: true
			        });		    
		    }	    
	
		    $("#dialogurl").dialog('option', 'width',600);
      	
		    var html = document.getElementById(id).innerHTML;   
			$("#dialogurl").html(html);
			$("#dialogurl").dialog('open');//设置为‘open’时将显示对话框  	
	 
		    
      } 

</script>
<div class="mright">
	<form action="${base}/odds/fetchLogList" method="get">
    		fetchId:<input type="text" name="fetchId"/>
    		 
    		<select name="fetchType"> <option value ="StardardList" <#if fetchType?? && fetchType=='StardardList'>selected</#if>/>欧赔</option><option value ="AsiaList" <#if fetchType?? && fetchType=='AsiaList'>selected</#if> >亚赔</option></select>
     		<select name="isComplete"> <option value ="true" <#if isComplete?? && isComplete==true>selected</#if>>已完成</option><option value ="false"  <#if isComplete?? && isComplete==false>selected</#if>>没有完成</option></select>
 
    		fetchCount:<input name="fetchCount" type="text" <#if fetchCount?? >value="${fetchCount}"</#if>/>
    		<input name="search" value="1" type="hidden">
    		<input type="submit" name="submit" value="submit">
    </form>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
    
      	<#if fetchLogList?? && fetchLogList?size gt 0>
      			    <tr class="tdtitle">
	      			<td  class="doc_td_head_1">捉取标识</td>
	      			<td class="doc_td_other">fetchType</td>
	      			<td class="doc_td_other">解析前的条数</td>
	      			<td class="doc_td_other">解析后的obj条数</td>
	      			<td class="doc_td_other">插入的条数</td>
	      			<td class="doc_td_other">捉取次数</td>
	      			<td class="doc_td_other">是否完成捉取</td>	
	 
	      		</tr>  
	      	<#list  fetchLogList as fetchLog>
	      		<#if (fetchLog_index+1)%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      		<tr class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      	 		<td class="doc_td_other"> <#if fetchLog.fetchId??>${fetchLog.fetchId}</#if></td>
		 			<td class="doc_td_other"> <#if fetchLog.fetchType??>${fetchLog.fetchType}</#if></td>
		 			<td class="doc_td_other"> <#if fetchLog.countUnParse??>${fetchLog.countUnParse}</#if></td>
		 			<td class="doc_td_other"> <#if fetchLog.countUnSave??>${fetchLog.countUnSave}</#if></td>
		 			<td class="doc_td_other"> <#if fetchLog.countAfterSave??>${fetchLog.countAfterSave}</#if></td>
		 			<td class="doc_td_other"> <#if fetchLog.fetchCount??>${fetchLog.fetchCount}</#if></td>
		 			<td class="doc_td_other"> <#if fetchLog.isComplete??><#if fetchLog.isComplete==true>完成<#else>没完成</#if></#if></td>
		 			<td class="doc_td_other"><a href="#" onclick="fetchLogHtml('${fetchLog.fetchId}_${fetchLog.fetchType}_log');return false;"></a></td>
	      		</tr> 
	      		<tr style="display:none">
	      			<td colspan="9">   
		      				<div id="${fetchLog.fetchId}_${fetchLog.fetchType}_log">
		      					 		      				</div>
	      			</td>
	      		</tr>    	
	      	</#list>
      	</#if>    
    </table>
  </div>