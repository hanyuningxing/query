<meta name="decorator" content="doc" />
<div class="mright">
    <div class="bgtitlec">彩票开售期号列表接口(购彩大厅)（103）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">103</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">查询在售的彩票期次列表以及详细数据。</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2">{"wLotteryId":"0"}</td>
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
	        <td class="doc_td_other"><a href="#" onclick="getSaleLottery();return false;">查看彩钟ID</a></td>
      </tr>
    </table>
     <div class="k10"></div>
    
    <div class="bgtitlec">返回处理结果说明(response)</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">格式</td>
        <td class="doc_title_td2"><font color="red">json数据格式</font></td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">例子</td>
        <td class="doc_title_td2">{"processId":"0","periodList":[{"endJoinTime_compound":"2012-07-30 19:50:00","endJoinTime_single":"2012-07-30 19:50:00","endedTime":"2012-07-30 19:50:00","lotteryType":"SSQ","periodNumber":"2012087","periodTitle":"","prizeTime":"2012-07-30 19:50:00","selfEndInitTime_compound":"2012-07-30 19:50:00","selfEndInitTime_single":"2012-07-30 19:50:00","shareEndInitTime_compound":"2012-07-30 19:50:00","shareEndInitTime_single":"2012-07-30 19:50:00","state":"Started",”playType”:””}]}</td>
      </tr>
    </table>
    <div class="k10"></div> 
     <div class="bgtitlec">结果参数说明参数</div>
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
	        <td class="doc_td_other">1-2</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">处理结果代号</td>
	        <td class="doc_td_other">0为成功 非0为失败<br/>
					1 = 用户错误/加密错误<br/>
					4 = 请求Id错误<br/>
					5 = 请求参数错误<br/>
					6 = 消息序号错误<br/>
					7 = 系统内部错误
	        </td>
      </tr>
     <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">errorMsg</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">0-200</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">错误日志</td>
	        <td class="doc_td_other">错误信息描述</td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">periodList</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">0-1000</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩期列表</td>
	        <td class="doc_td_other">彩期列表，json数组格式，每个数组元素为1个期次对象数据，格式为json</td>
      </tr>
    </table>
     <div class="k10"></div>
     <div class="bgtitlec">期次对象JSON参数</div>
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
	        <td class="doc_td_head_1">endJoinTime_compound</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">复式截至加入时间</td>
	        <td class="doc_td_other">yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">endJoinTime_single</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">单式截至加入时间</td>
	        <td class="doc_td_other">yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">endedTime</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">官方截至时间</td>
	        <td class="doc_td_other">yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">selfEndInitTime_compound</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">复式自购截至发起时间</td>
	        <td class="doc_td_other">yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">selfEndInitTime_single</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">单式自购截至发起时间</td>
	        <td class="doc_td_other">yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">shareEndInitTime_compound</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">复式合买截至发起时间</td>
	        <td class="doc_td_other">yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">shareEndInitTime_single</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">单式合买截至发起时间</td>
	        <td class="doc_td_other">yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">lotteryType</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">1-6</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩种编号</td>
	        <td class="doc_td_other"><a href="${base}/doc/lotterytype">附录-彩种编号-lotteryType</a></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">periodNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期号</td>
	        <td class="doc_td_other"></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">periodTitle</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩种简单描述</td>
	        <td class="doc_td_other">比如双色球：“每二，四，六开奖”</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">prizeTime</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">官方开奖时间</td>
	        <td class="doc_td_other"></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">periodNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期号</td>
	        <td class="doc_td_other"></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">state</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩期状态</td>
	        <td class="doc_td_other">Inited("初始"),Started("开售"),Paused("暂停"),SaleEnded("截止"),Finished("结束");</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">playType</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">排列三和排列五，任选9和胜负彩</td>
	        <td class="doc_td_other">SFZC9=任选9场<br/>SFZC14=胜负彩<br/>P3Direct=排列三<br/>P5Direct=排列五</td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>