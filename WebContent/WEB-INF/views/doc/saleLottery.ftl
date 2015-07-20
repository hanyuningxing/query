<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="100" class="doc_td_head_1">彩种</td>
	        <td class="doc_td_other">对应wLotteryId值</td>
      </tr>
      <#if saleLottery??&& (saleLottery![])?size gt 0>
	    	<#list saleLottery as data>
	    	<#if data_index%2==0><#assign trColor="tdwhitelist" /><#else><#assign trColor="tdgraylist" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
		        <td class="doc_td_other">${data.lotteryName!}</td>
		        <td class="doc_td_other">${data.lotteryOrdinal!}</td>
	    	</tr>
	   </#list>
	    <#else> 
		    <tr>
		      <td class="trw" align="center" colspan="2">无记录</td>
		    </tr>
	    </#if>
    </table>
   