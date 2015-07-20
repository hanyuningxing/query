<meta name="decorator" content="doc" />
 	<style>
 		.time_0{background-color:red;display: inline-block;width: 10px;height: 10px;overflow: hidden;}
 		.time_1{background-color:orange;display: inline-block;width: 10px;height: 10px;overflow: hidden;}
 		.time_2{background-color:yellow;display: inline-block;width: 10px;height: 10px;overflow: hidden;}
 		.time_3{background-color:green;display: inline-block;width: 10px;height: 10px;overflow: hidden;}
 		.time_4{background-color:blue;display: inline-block;width: 10px;height: 10px;overflow: hidden;}
 		.time_5{background-color:#ccc;display: inline-block;width: 10px;height: 10px;overflow: hidden;}
 	</style>
 	<script src="${base}/scripts/lottery/odds.js"/></script>
 
<div class="mright">
	
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;" id="odds_table">
 
      	<#if standardList?? && standardList?size gt 0>
	      	<tr class="tdtitle">
	      			     <td class="doc_td_other"></td>
		      			 <td class="doc_td_other" colspan="3">初始指数</td>
		      			 <td class="doc_td_other" colspan="4">最新指数</td>
		      			 <td class="doc_td_other" colspan="3">概率</td>
		      			 <td class="doc_td_other" colspan="3">凯利指数</td>      		 
		      			 <td class="doc_td_other"></td>
		      </tr>  
      		  <tr class="tdtitle">
      			     <td class="doc_td_other">公司</td>
	      			 <td class="doc_td_other">胜</td>
	      			 <td class="doc_td_other">平</td>
	      			 <td class="doc_td_other">负</td>
	      			 <td class="doc_td_other">胜</td>
	      			 <td class="doc_td_other">平</td>
	      			 <td class="doc_td_other">负</td>
	      			 <td class="doc_td_other">更新</td>
	      			 <td class="doc_td_other">胜</td>
	      			 <td class="doc_td_other">平</td>
	      			 <td class="doc_td_other">负</td>
	      			 <td class="doc_td_other">胜</td>
	      			 <td class="doc_td_other">平</td>
	      			 <td class="doc_td_other">负</td>
	      			 <td class="doc_td_other">反还率</td>
	      		</tr>  
	      	<#list  standardList as odds>
	      	 	<#if (odds_index+1)%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      		<tr name="odds_${odds.fetchOddsKey}" <#if odds.company?? && odds.company.fetchCompanyId=24>id="odds_99" <#if odds.match??> time="${odds.match.matchTime?string("yyyy-MM-dd HH:mm:ss")}"</#if></#if> class="${classStr}"  onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td  name="company"><#if odds.company??>${odds.company.name}</#if></td>
	      			<td><#if odds.firstHome??><span name="firstHome">${odds.firstHome}</span></#if></td>
	      			<td><#if odds.firstOff??><span name="firstOff">${odds.firstOff}</span></#if></td>
	      			<td><#if odds.firstGuest??><span name="firstGuest">${odds.firstGuest}</span></#if></td>
	      			<td><#if odds.home??><#if odds.homeCompare??><#if (odds.homeCompare<0) ><span name="home" style="color:blue">${odds.home}</span><i style="color:blue">↓</i><#elseif (odds.homeCompare>0) ><span name="home" style="color:red">${odds.home}</span><i style="color:red">↑</i><#else><span name="home">${odds.home}</span></#if></#if></#if></td>
	      			<td><#if odds.off??> <#if odds.offCompare??><#if (odds.offCompare<0) ><span name="off" style="color:blue">${odds.off}</span><i style="color:blue">↓</i><#elseif (odds.offCompare>0) ><span name="off" style="color:red">${odds.off}</span><i style="color:red">↑</i><#else><span name="off">${odds.off}</span></#if></#if> </#if></td>
	      			<td><#if odds.guest??><#if odds.guestCompare??><#if (odds.guestCompare<0) ><span name="guest" style="color:blue">${odds.guest}</span><i style="color:blue">↓</i><#elseif (odds.guestCompare>0) ><span style="color:red" name="guest">${odds.guest}</span><i style="color:red">↑</i><#else><span name="guest">${odds.guest}</span></#if></#if> </#if></td>
	      			<td><span  onmouseover="showTimeTips(this);"  name="lastModifyTime" tips="" data="" <#if odds.lastModifyTime??>time="${odds.lastModifyTime?string("yyyy-MM-dd HH:mm:ss")}"</#if>><a href="${base}/odds/standOddsDetail?oddsId=${odds.id}"><em class="time_5"></em></a></span></td>
	      			<td><span name="gWin"></span></td>
	      			<td><span name="gDraw"></span></td>
	      			<td><span name="gLose"></span></td>
	      			<td><span name="kWin"></span></td>
	      			<td><span name="kDraw"></span></td>
	      			<td><span name="kLose"></span></td>
	      			<td><span name="fanhuan"></span></td>
	      		</tr>     	
	      		
	      	</#list>
	      	<tr id="ave_odds"  class="tdwhitelist"  onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	      			<td><span>平均值</span></td>
	      			<td><span name="firstHome"></span></td>
	      			<td><span name="firstOff"></span></td>
	      			<td><span name="firstGuest"></span></td>
	      			<td><span name="home"></span></td>
	      			<td><span name="off"></span></td>
	      			<td><span name="guest"></span></td>
	      			<td>-</td>
	      			<td><span name="gWin"></span></td>
	      			<td><span name="gDraw"></span></td>
	      			<td><span name="gLose"></span></td>
	      			<td><span name="kWin"></span></td>
	      			<td><span name="kDraw"></span></td>
	      			<td><span name="kLose"></span></td>
	      			<td><span name="fanhuan"></span></td>
	      		</tr> 
	      		<tr id="big_odds"  class="tdwhitelist"  onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	      			<td><span>最大值</span></td>
	      			<td><span name="firstHome"></span></td>
	      			<td><span name="firstOff"></span></td>
	      			<td><span name="firstGuest"></span></td>
	      			<td><span name="home"></span></td>
	      			<td><span name="off"></span></td>
	      			<td><span name="guest"></span></td>
	      			<td>-</td>
	      			<td><span name="gWin"></span></td>
	      			<td><span name="gDraw"></span></td>
	      			<td><span name="gLose"></span></td>
	      			<td><span name="kWin"></span></td>
	      			<td><span name="kDraw"></span></td>
	      			<td><span name="kLose"></span></td>
	      			<td><span name="fanhuan"></span></td>
	      		</tr>   
	      			<tr id="small_odds"  class="tdwhitelist"  onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	      			<td><span>最小值</span></td>
	      			<td><span name="firstHome"></span></td>
	      			<td><span name="firstOff"></span></td>
	      			<td><span name="firstGuest"></span></td>
	      			<td><span name="home"></span></td>
	      			<td><span name="off"></span></td>
	      			<td><span name="guest"></span></td>
	      			<td>-</td>
	      			<td><span name="gWin"></span></td>
	      			<td><span name="gDraw"></span></td>
	      			<td><span name="gLose"></span></td>
	      			<td><span name="kWin"></span></td>
	      			<td><span name="kDraw"></span></td>
	      			<td><span name="kLose"></span></td>
	      			<td><span name="fanhuan"></span></td>
	      		</tr>     
      	</#if>    
    </table>
  </div>