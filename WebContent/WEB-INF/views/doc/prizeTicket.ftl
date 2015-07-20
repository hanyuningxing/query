<meta name="decorator" content="doc" />
<div>
</div>
<div class="mright">
    <div class="bgtitlec">开奖查询接口（108）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">108</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">提供给网站票务处理中心使用，用于查询网站票务处理中心发送的彩票的出票状态。</td>
      </tr>
           <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam</td>
        <td class="doc_title_td2">JSON格式的字符串（<font color="red">对于非必需字段，在彩种格式中没有提及到时均可置空</font>）参考下表</td>
        </tr>
         <tr class="tdgf5">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2">{"orderId":"102,103","wLotteryId":"0"}</td>
      </tr>
        
    </table>
    <div class="k10"></div>
     <div class="bgtitlec">wParam请求参数</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">参数</td>
	        <td width="70" class="doc_td_other">类型</td>
	        <td width="70" class="doc_td_other">长度</td>
	        <td width="100" class="doc_td_other">是否必须</td>
	        <td width="100" class="doc_td_other">名称</td>
	        <td class="doc_td_other">说明</td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">wLotteryId</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-2</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩种ID</td>
	        <td class="doc_td_other"><a href="#" onclick="getSaleLottery();return false;">查看彩钟ID</a></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">orderId</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">订单号字符串</td>
	        <td class="doc_td_other">最多查询100张彩票(多张彩票用,分隔.如1014,1013)</td>
      </tr>
    </table>
     <div class="k10"></div>
     <div class="bgtitlec">返回参数</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">参数</td>
	        <td width="70" class="doc_td_other">类型</td>
	        <td width="70" class="doc_td_other">长度</td>
	        <td width="100" class="doc_td_other">是否必须</td>
	        <td width="100" class="doc_td_other">名称</td>
	        <td class="doc_td_other">说明</td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">processId</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">4</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">处理结果</td>
	        <td class="doc_td_other">返回处理结果代号。<a href="#" onclick="getError()">查看</a></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">ticket</td>
	        <td class="doc_td_other">JSON</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">处理返回实体</td>
	        <td class="doc_td_other">参考下面例子</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">ticket例子</td>
	        <td class="doc_td_other" colspan="5"   style="text-align: left;word-break:break-all">{"ticket":[{"orderId":"1379147342235","printState":"SUCCESS","prizeAfterTax":0,"prizeDetail":"","prizeSended":false,"winningUpdateStatus":"NONE","won":false},{"orderId":"ninhao","printState":"FAILD","prizeAfterTax":0,"prizeDetail":"","prizeSended":false,"winningUpdateStatus":"NONE","won":false}],"processId":"0"}</td>
      </tr>
      
    </table>
    
    <div class="k10"></div>
     <div class="bgtitlec">返回参数ticket对象JSON参数</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">参数</td>
	        <td width="70" class="doc_td_other">类型</td>
	        <td width="70" class="doc_td_other">长度</td>
	        <td width="100" class="doc_td_other">是否必须</td>
	        <td width="100" class="doc_td_other">名称</td>
	        <td class="doc_td_other">说明</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">orderId</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">1-32</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">订单号</td>
	        <td class="doc_td_other"></td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">printState</td>
	         <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">1-15</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">出票状态</td>
	        <td class="doc_td_other" style="text-align: left">
				FULL=委托中
				SUCCESS=成功
				FAILD=失败
	        </td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	       <td class="doc_td_head_1">winningUpdateStatus</td>
	         <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">1-15</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">派奖状态</td>
	        <td class="doc_td_other" style="text-align: left">
				NONE=未更新中奖
				WINNING_UPDATED=已更新中奖
				PRICE_UPDATED=已更新奖金
	        </td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">prizeAfterTax</td>
	         <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">税后奖金</td>
	        <td class="doc_td_other" style="text-align: left">
				当字段winningUpdateStatus等于WINNING_UPDATED或者等于PRICE_UPDATED时,本字段才会返回值
	        </td>
      </tr>
       <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">prizeSended</td>
	        <td class="doc_td_other">true/false</td>
	        <td class="doc_td_other">4-5</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">是否派发奖金</td>
	        <td class="doc_td_other"  style="text-align: left">当字段winningUpdateStatus等于NONE或者等于WINNING_UPDATED时。本字段都是返回false</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">won</td>
	        <td class="doc_td_other">true/false</td>
	        <td class="doc_td_other">4-5</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">是否中奖</td>
	        <td class="doc_td_other"  style="text-align: left">当字段winningUpdateStatus等于NONE时。本字段都是返回false</td>
      </tr>
       <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">prizeDetail</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">奖金详情</td>
	        <td class="doc_td_other"  style="text-align: left">当字段winningUpdateStatus等于WINNING_UPDATED或者等于PRICE_UPDATED时,本字段才会返回值</td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>