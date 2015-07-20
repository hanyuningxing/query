<meta name="decorator" content="doc" />
<script>
      function getPlayTypeItem(playTypeItem){
        var lottery = $('input[id=lottery]').val();
        Miracle.getURL({
            url: '/doc/playTypeItem?lottery='+lottery+'&playTypeItem='+playTypeItem,
            width:200,
            title:'选项',
            modal:false
        });
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
      <tr class="tdgf5" >
        <td class="doc_title_td1">matchKey</td>
        <td class="doc_title_td2">场次所属赛程日（yyyyMMdd）+场次序号（3位）。</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">playTypeItem</td>
        <td class="doc_title_td2">投注值 参考下表playType 参数值.只在混合串关情况下有效</td>
       </tr>
        <tr class="tdgf5" >
        <td class="doc_title_td1">value</td>
        <td class="doc_title_td2">投注值 参考下表投注选项</td>
      </tr>
    </table>
    <div class="k10"></div>
     <div class="bgtitlec">玩法类型(<font color="red">playType</font>)</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">名称</td>
	        <td width="70" class="doc_td_other">参数值</td>
	        <td width="70" class="doc_td_other">最大场次</td>
	        <td width="100" class="doc_td_other">投注选项</td>
      </tr>
      <#if lottery.playTypeItem??&& (lottery.playTypeItem![])?size gt 0>
	    	<#list lottery.playTypeItem as data>
	    	<#if data_index%2==0><#assign trColor="tdwhitelist" /><#else><#assign trColor="tdgraylist" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trhover'" onmouseout="this.className='${trColor}'">
	    	    <td class="doc_td_head_1">${data.text!}</td>
		        <td class="doc_td_other">${data.value!}</td>
		        <td class="doc_td_other">${data.maxItemSize!}</td>
		        <td class="doc_td_other"><a href="#" onclick="getPlayTypeItem('${data.typeName!}');">查看选项</a></td>
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