<meta name="decorator" content="doc" />
 
 <script src="${base}/scripts/lottery/ok_match_his.js"/></script>
 <style>
 	.hideDiv{display:none;}
 </style>
 
 
<div class="mright">
	<#if key??>
    	 	<div class="hideDiv" id="matchKey">${key}</div>
    	 	<div class="hideDiv" id="matchType">${matchType}</div>
    </#if>
    <div class="bgtitlec">主队历史</div>
    <table name="table0" width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
    	 
    	 
      	<#if matchHisMap?? && matchHisMap?size gt 0>
      		<tr class="tdtitle">
	      			<td  class="doc_td_head_1">联赛</td>
	      			<td class="doc_td_other">时间</td>
	      			<td class="doc_td_other">主队</td>
	      			<td class="doc_td_other">比分</td>
	      			<td class="doc_td_other">客队</td>
	      			<td class="doc_td_other">半场</td>
	      			<td class="doc_td_other">欧赔<select onchange="changeCompany(this,'table0','odds_eur_div')"><option value="24">99家</option<option value="14">立博</option>><option value="82">立博</option><option value="27">Bet365</option></select></td>
	      			<td class="doc_td_other">亚赔<select onchange="changeCompany(this,'table0','odds_asia_div')"><option value="82">立博</option><option value="27">Bet365</option><option value="84">澳门</option></select></td>
	      	</tr>  
	      	<#assign index=0 >
	      	<#list  matchHisMap ?keys as itemKey>
	      		<#assign match = matchHisMap[itemKey] >
	      		<#assign index=index+1>
	      		<#if index%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      		<tr id="${match.fetchId}_tr" class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td class="doc_td_other"><#if match.sclassName??>${match.sclassName}</#if></td>
	      			<td class="doc_td_other"><#if match.matchTime??>${match.matchTime?string("yyyy-MM-dd HH:mm")}</#if></td>
	      			<td class="doc_td_other"><#if match.homeTeamName??>${match.homeTeamName}</#if></td>
	      			<td class="doc_td_other"><#if match.homeScore??>${match.homeScore}</#if>-<#if match.guestScore??>${match.guestScore}</#if></td>
	      			<td class="doc_td_other"><#if match.guestTeamName??>${match.guestTeamName}</#if></td>
	      			<td class="doc_td_other"><#if match.homeHalfScore??>${match.homeHalfScore}</#if>-<#if match.guestHalfScore??>${match.guestHalfScore}</#if></td>
	      			<td class="doc_td_other">
	      				<#assign oddsList = match.okStandardOdds>
	      				<#list oddsList as odds>
	      					<#if odds.fetchCompanyId??>
		      					<div id="${match.fetchId}_${odds.fetchCompanyId}}" class='odds_eur_div odds_eur_div_${odds.fetchCompanyId}' <#if odds.fetchCompanyId!=24>style="display:none"</#if>>
		      						<span><#if odds.homeWin??>${odds.homeWin}</#if>(<#if odds.homeWin??>${odds.firstHomeWin}</#if>)</span>
		      						<span><#if odds.standoff??>${odds.standoff}</#if>(<#if odds.firstStandoff??>${odds.firstStandoff}</#if>)</span>
		      						<span><#if odds.guestWin??>${odds.guestWin}</#if>(<#if odds.firstGuestWin??>${odds.firstGuestWin}</#if>)</span>  						
		   						</div>
	   						</#if>
	      				</#list>
	      			</td> 
	      		     <td class="doc_td_other">
	      				<#assign oddsAsiaList = match.okAsiaOdds>
	      				<#list oddsAsiaList as odds>
	      					<#if odds.fetchCompanyId??>
		      					<div id="${match.fetchId}_${odds.fetchCompanyId}}"  class="odds_asia_div odds_asia_div${odds.fetchCompanyId}" <#if odds.fetchCompanyId!=84>style="display:none"</#if>>
		      						<span><#if odds.homeWin??>${odds.homeWin}</#if>(<#if odds.firstHomeWin??>${odds.firstHomeWin}</#if>)</span>
		      						<span><#if odds.standoff??>${odds.standoff}</#if>(<#if odds.firstStandoff??>${odds.firstStandoff}</#if>)</span>
		      						<span><#if odds.guestWin??>${odds.guestWin}</#if>(<#if odds.firstGuestWin??>${odds.firstGuestWin}</#if>)</span>  						
		   						</div>
	   						</#if>
	      				</#list>
	      			</td> 
	      	   </tr>   	
	      	</#list>
      	</#if>    
    </table>
    <div class="bgtitlec">客队历史</div>
    <div id="matchHis1"></div>
    <div class="bgtitlec">交锋历史</div>
    <div id="matchHis2"></div>
  </div>