<meta name="decorator" content="doc" />
<div class="mright">
    <div class="bgtitlec">查询彩票接口（107）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">107</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">提供给网站票务处理中心使用，用于核对网站票务处理中心发送的彩票的奖金。</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2"></td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam</td>
        <td class="doc_title_td2">JSON格式的字符串（<font color="red">对于非必需字段，在彩种格式中没有提及到时均可置空</font>）参考下表</td>
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
	        <td class="doc_td_other"><a href="#">查看彩钟ID</a></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">periodNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">期号</td>
	        <td class="doc_td_other">竞彩足球，竞彩蓝球留空,其他彩种非空</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">createDate</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">8</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩票发起日期</td>
	        <td class="doc_td_other">彩票发起日期，格式yyyyMMdd,例如20120507,查询结果为当天发起的所有彩票。竞彩玩法此项为非空,非竞彩类玩法如果留空则返回该期所有中奖彩票</td>
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
	        <td class="doc_td_head_1">award</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">5000行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">中奖字符串</td>
	        <td class="doc_td_other">格式为:订单号:奖金;订单号:奖金 例如:39920580:120.25;39920587:4.48; 表示订单号39920580税后奖金为120.25元,订单号39920587税后奖金为4.48元</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">total</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-32</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">总奖金</td>
	        <td class="doc_td_other"></td>
      </tr>
       <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">例子</td>
	        <td class="doc_td_other" colspan="5">{"total":124.73,"award":"39920580:120.25;39920587:4.48","processId":"0"}</td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>