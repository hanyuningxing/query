<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">选项参数值</td>
	        <td class="doc_td_other">对应投注</td>
      </tr>
      <#if item??&& (item![])?size gt 0>
	    	<#list item as data>
	    	<#if data_index%2==0><#assign trColor="tdwhitelist" /><#else><#assign trColor="tdgraylist" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
		        <td class="doc_td_other">${data.value!}</td>
		        <td class="doc_td_other">${data.text!}</td>
	    	</tr>
	   </#list>
	    <#else> 
		    <tr>
		      <td class="trw" align="center" colspan="2">无记录</td>
		    </tr>
	    </#if>
    </table>
   <#if item?? && item?size gt 0>
   	<#list item as data>
   	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
   	  
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">场次序号</td>
	        <td class="doc_td_other">球队${data.matchItem?size}</td>
      </tr>
      <#list data.matchItem  as data2>
      	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
		        <td class="doc_td_other">${data2.match!}</td>
		        <td class="doc_td_other">${data2.team!}</td>
	    	</tr>
      </#list>
  </#list>
	   
	 
    </table>
   
   </#if>