<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">返回码</td>
	        <td class="doc_td_other">对应</td>
      </tr>
      <#if processIdType??&& (processIdType![])?size gt 0>
	    	<#list processIdType as data>
	    	<#if data_index%2==0><#assign trColor="tdwhitelist" /><#else><#assign trColor="tdgraylist" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
		        <td class="doc_td_other">${data.value!}</td>
		        <td class="doc_td_other">${data.typeName!}</td>
	    	</tr>
	   </#list>
	   </#if>
    </table>