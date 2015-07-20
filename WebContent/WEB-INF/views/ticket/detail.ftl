<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="100" class="doc_td_head_1">名称</td>
	        <td class="doc_td_other"></td>
      </tr>
      <#if ticketDatail??>
	    	<tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'">
		        <td class="doc_td_other">彩票内容</td>
		        <td class="doc_td_other">${ticketDatail.content!}</td>
	    	</tr>
	    	<tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'">
		        <td class="doc_td_other">彩票出票SP</td>
		        <td class="doc_td_other">${ticketDatail.printAwards!}</td>
	    	</tr>
	   </#if>
	   <#if ticketThen??>
	   		<tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'">
		        <td class="doc_td_other">出票时间</td>
		        <td class="doc_td_other"><#if ticketThen.ticketTime??>${ticketThen.ticketTime?string("yyyy-MM-dd HH:mm")}</#if></td>
	    	</tr>
	    	 <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'">
		        <td class="doc_td_other">结算时间</td>
		        <td class="doc_td_other"><#if ticketThen.prizeTime??>${ticketThen.prizeTime?string("yyyy-MM-dd HH:mm")}</#if></td>
	    	</tr>
	   </#if>	
    </table>