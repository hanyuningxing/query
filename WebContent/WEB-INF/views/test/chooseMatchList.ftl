<meta name="decorator" content="doc" />
 <style>
 	.red{color:red;}
 </style>
<div class="mright">
    <div class="bgtitlec">赛事选择<#if rate??>${rate}</#if><#if orate??>(${orate})</#if></div>
    <table name="table0" width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      	<#if chooseMatchList?? && chooseMatchList?size gt 0>
      		<tr class="tdtitle">
	      			<td  class="doc_td_head_1">场次</td>
	      			<td class="doc_td_other">主/客比分</td>
	      			<td class="doc_td_other">选胜次数</td>
	      			<td class="doc_td_other">选平次数</td>
	      			<td class="doc_td_other">选负次数</td>
	      			<td class="doc_td_other">选让胜次数</td>
	      			<td class="doc_td_other">选让平次数</td>
	      			<td class="doc_td_other">选让负次数</td>
	      	</tr>  
	      	<#list  chooseMatchList as match>
	      		<#if (match_index+1)%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      		<#if match.homeScore??>
	      		<#assign spf=match.homeScore-match.guestScore />
	      		<#assign rspf=match.homeScore+match.lose-match.guestScore />
	      		
	      		<tr class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td class="doc_td_other"><#if match.matchId??>${match.matchId}</#if></td>
	      			<td class="doc_td_other"><#if match.homeScore??>${match.homeScore}</#if>-<#if match.guestScore??>${match.guestScore}</#if><#if match.lose??>(${match.lose})</#if></td>
	      			<td class="doc_td_other <#if (spf>0) >red</#if>"><#if match.spf3??>${match.spf3}</#if><#if match.ospf3??>(${match.ospf3})</#if></td>
	      			<td class="doc_td_other <#if (spf=0) >red</#if>"><#if match.spf1??>${match.spf1}</#if><#if match.ospf1??>(${match.ospf1})</#if></td>
	      			<td class="doc_td_other <#if (spf<0) >red</#if>"><#if match.spf0??>${match.spf0}</#if><#if match.ospf0??>(${match.ospf0})</#if></td>
	      			<td class="doc_td_other <#if (rspf>0) >red</#if>"><#if match.rspf3??>${match.rspf3}</#if><#if match.orspf3??>(${match.orspf3})</#if></td>
	      			<td class="doc_td_other <#if (rspf=0) >red</#if>"><#if match.rspf1??>${match.rspf1}</#if><#if match.orspf1??>(${match.orspf1})</#if></td>
	      			<td class="doc_td_other <#if (rspf<0) >red</#if>"><#if match.rspf0??>${match.rspf0}</#if><#if match.orspf0??>(${match.orspf0})</#if></td>
	      	   </tr>
	      	   <#else>
	      	   <tr class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td class="doc_td_other"><#if match.matchId??>${match.matchId}</#if></td>
	      			<td class="doc_td_other"><#if match.homeScore??>${match.homeScore}</#if>-<#if match.guestScore??>${match.guestScore}</#if></td>
	      			<td class="doc_td_other"><#if match.spf3??>${match.spf3}</#if><#if match.ospf3??>(${match.ospf3})</#if></td>
	      			<td class="doc_td_other"><#if match.spf1??>${match.spf1}</#if><#if match.ospf1??>(${match.ospf1})</#if></td>
	      			<td class="doc_td_other"><#if match.spf0??>${match.spf0}</#if><#if match.ospf0??>(${match.ospf0})</#if></td>
	      			<td class="doc_td_other"><#if match.rspf3??>${match.rspf3}</#if><#if match.orspf3??>(${match.orspf3})</#if></td>
	      			<td class="doc_td_other"><#if match.rspf1??>${match.rspf1}</#if><#if match.orspf1??>(${match.orspf1})</#if></td>
	      			<td class="doc_td_other"><#if match.rspf0??>${match.rspf0}</#if><#if match.orspf0??>(${match.orspf0})</#if></td>
	      	   </tr>
	      	   </#if>   	
	      	</#list>
      	</#if>    
    </table>
  </div>