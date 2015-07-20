<meta name="decorator" content="doc" />
    <script>
      function getPlayTypeItem2(compoundValue,singleValue,danValue){ 
		    if ($("#dialogurl").length == 0) {  
		           $("body").append('<div id="dialogurl"></div>');
			       $("#dialogurl").dialog({
			            autoOpen: false,
			            title: '提示',
			            modal: true
			        });		    
		    }
		    
		    $("#dialogurl").dialog('option', 'width',600);
		    var html ="<table width='100%' border='0' cellpadding='0' cellspacing='0' class='tb1' style='line-height:28px;'>"+
		    			"<tr class=\"tdtitle\"> <td width=\"300\" class=\"doc_td_head_1\">复式</td> <td class=\"doc_td_other\">单式</td> <td class=\"doc_td_other\">胆拖</td></tr>"+
	       				"<tr class=\"tdwhitelist\" onmouseover=\"this.className='trhover'\" onmouseout=\"this.className='tdwhitelist'\">"+
	       				"<td class=\"doc_td_other\">"+compoundValue+"</td> <td class=\"doc_td_other\">"+singleValue+"</td><td class=\"doc_td_other\">"+danValue+"</td>"
     				    "</tr></table>";    
			$("#dialogurl").html(html);
			$("#dialogurl").dialog('open');//设置为‘open’时将显示对话框  	
      }    	
	</script>
<input type="hidden" id="lottery" value="${lottery}"/>
<div class="mright">
    <div class="bgtitlec">${lottery.lotteryName!}说明和格式</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="140" class="doc_title_td1"><font color="red">value</font>（投注内容）格式</td>
        <td class="doc_title_td2">${lottery.example}</td>
      </tr>
 
    </table>
    <div class="k10"></div>
     <div class="bgtitlec">玩法类型(<font color="red">playType</font>)</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">名称</td>
	        <td width="70" class="doc_td_other">复式0</td>
	        <td width="70" class="doc_td_other">单式1</td>
	        <td width="70" class="doc_td_other">胆拖0</td>
	        <td width="100" class="doc_td_other">投注选项</td>
      </tr>
      <#if lottery.playTypeItem??&& (lottery.playTypeItem![])?size gt 0>
	    	<#list lottery.playTypeItem as data>
	    	<#if data_index%2==0><#assign trColor="tdwhitelist" /><#else><#assign trColor="tdgraylist" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
	    	    <td class="doc_td_head_1">${data.typeName}</td>
		        <td class="doc_td_other"><#if data.compoundSupport??><#if data.compoundSupport==true>√<#else>暂不支持</#if><#else></#if></td>
		        <td class="doc_td_other"><#if data.singleSupport??><#if data.singleSupport==true>√<#else>暂不支持</#if><#else></#if></td>
		        <td class="doc_td_other"><#if data.danSupport??><#if data.danSupport==true>√<#else>暂不支持</#if><#else></#if></td>
		        <td class="doc_td_other"><a href="#" onclick="getPlayTypeItem2('${data.compoundValue!}','${data.singleValue!}','${data.danValue!}');">查看选项</a></td>
	    	</tr>
	   </#list>
	   <#else> 
		    <tr>
		      <td class="trw" align="center" colspan="4">此选项默认为0</td>
		    </tr>
	    </#if>
    </table>

     <div class="k10"></div>
     <div class="bgtitlec">投注方式(<font color="red">type</font>)</div>
     <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">名称</td>
	        <td width="100" class="doc_td_other">投注选项</td>
      </tr>
      <#if lottery.schemeTypeItem??&& (lottery.schemeTypeItem![])?size gt 0>
	    	<#list lottery.schemeTypeItem as data>
	    	<#if data_index%2==0><#assign trColor="tdwhitelist" /><#else><#assign trColor="tdgraylist" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
	    	    <td class="doc_td_head_1">${data.text!}</td>
		        <td class="doc_td_other">${data.value!}</td>
	    	</tr>
	   </#list>
	    <#else> 
		    <tr>
		      <td class="trw" align="center" colspan="2">此选项默认为0</td>
		    </tr>
	    </#if>
    </table>
     <div class="k10"></div>
     <div class="bgtitlec">过关方式(<font color="red">passType</font>)</div>
     <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">名称</td>
	        <td width="100" class="doc_td_other">投注选项</td>
      </tr>
      <#if lottery.passTypeItem??&& (lottery.passTypeItem![])?size gt 0>
	    	<#list lottery.passTypeItem as data>
	    	<#if data_index%2==0><#assign trColor="tdwhitelist" /><#else><#assign trColor="tdgraylist" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
	    	    <td class="doc_td_head_1">${data.text!}</td>
		        <td class="doc_td_other">${data.betValue!}</td>
	    	</tr>
	   </#list>
	    <#else> 
		    <tr>
		      <td class="trw" align="center" colspan="2">此选项默认为0</td>
		    </tr>
	    </#if>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>