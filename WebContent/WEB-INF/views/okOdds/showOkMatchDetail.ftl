						<div id="${match.fetchMatchId}_okMatch">
		      					<form action="${base}/odds/updateMatch" method="post" id="${match.fetchMatchId}_form">
		      						<table>	
		      						
		      							<tr><td>比赛时间</td><td><input name="matchTimeStr" type="text" value="<#if match.matchTime??>${match.matchTime?string("yyyy-MM-dd HH:mm")}</#if>"/></td></tr>		
		      							<tr><td>主队</td><td> ${match.homeTeam.name}</td></tr>
		      							<tr><td>主队排名</td><td><input name="homeOrder" type="text"  value="<#if match.homeOrder??>${match.homeOrder}</#if>"/></td></tr>
			      						<tr><td>比分</td><td><input name="homeScore"  type="text" value="<#if match.homeScore??>${match.homeScore}</#if>"/>-<input name="guestScore"  type="text"  value="<#if match.guestScore??>${match.guestScore}</#if>"/></td></tr>
			      				   		<tr><td>客队</td><td> ${match.guestTeam.name}</td></tr>
			      						<tr><td>客队排名</td><td><input name="guestOrder" type="text"  value="<#if match.guestOrder??>${match.guestOrder}</#if>"/></td></tr>
			      						<tr><td>半场比分</td><td><input name="homeHalfScore" type="text"  value="<#if match.homeHalfScore??>${match.homeHalfScore}</#if>"/>-<input name="guestHalfScore" type="text"  value="<#if match.guestHalfScore??>${match.guestHalfScore}</#if>"/></td></tr>	 
			      		 				<tr><td>天气</td><td><input name="weather" type="text"  value="<#if match.weather??>${match.weather}</#if>"/></td></tr>	      		 				
			      		 				<tr><td>赛季</td><td><input name="season" type="text"  value="<#if match.season??>${match.season}</#if>"/>	</td></tr>
			      						<tr><td>竞彩</td><td><input name="jcKey" type="text"  value="<#if match.jcKey??>${match.jcKey}</#if>"/></td></tr>
			      						<tr><td>北单</td><td><input name="dcKey"  type="text" value="<#if match.dcKey??>${match.dcKey}</#if>"/></td></tr>
			      						<tr><td>足彩</td><td><input name="zcKey" type="text"  value="<#if match.zcKey??>${match.zcKey}</#if>"/></td></tr>
			      						<tr><td>matchDate</td><td><input name="matchDate" type="text"  value="<#if match.matchDate??>${match.matchDate}</#if>"/></td></tr>
			      						<tr><td>isJc</td><td>yes:<input name="isJc" type="radio"  value="true" <#if match.isJc==true>checked</#if>/>no:<input name="isJc" type="radio"  value="false" <#if match.isJc==false>checked</#if>/></td></tr>
			      						<tr><td>isDc</td><td>yes:<input name="isDc" type="radio"  value="true" <#if match.isDc==true>checked</#if>/>no:<input name="isDc" type="radio"  value="false" <#if match.isDc==false>checked</#if>/></td></tr>
			      						<tr><td>isZc</td><td>yes:<input name="isZc" type="radio"  value="true" <#if match.isZc==true>checked</#if>/>no:<input name="isZc" type="radio"  value="false" <#if match.isZc==false>checked</#if>/></td></tr>		      				
			      						<tr><td><input type="hidden" name="objectId" value="${match.id}"><input type="hidden" name="fetchMatchId" value="${match.fetchMatchId}"></td><td><input type="button" value="确定" onclick="sumbitOkMatch(${match.fetchMatchId});return false;"/></td></tr>	
		      						</table>
		      					</form>
		      					<a href="#" onclick="autoUpdateOkMatch(${match.fetchMatchId});return false;">重捉</a>
		      				</div>