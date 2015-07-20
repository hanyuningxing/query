<meta name="decorator" content="doc" />
<div class="mright">
    <div class="bgtitlec">足彩,北单,竞彩开奖场次查询接口（105)</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">105</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">足彩,北单,竞彩开售场次查询接口。</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2">{"wLotteryId":17,"periodNumber":"20121128"}</td>
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
	        <td class="doc_td_head_1">periodNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期号</td>
	        <td class="doc_td_other">竞彩足球，竞彩蓝球可以留空</td>
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
        <td class="doc_title_td2">{"processId":"0","match":[{"cancel":true,"ended":false,"gameColor":"#57A87B","gameName":"苏超","guestHalfScore":3,"guestScore":4,"guestTeamName":"凯尔特人","handicap":0,"homeHalfScore":0,"homeScore":0,"homeTeamName":"哈茨","matchKey":"20121128-022","matchTime":"2012-11-29 03:30:00","result":"","sp":"1.0|1.0|1.0|1.0"},{"cancel":false,"ended":false,"gameColor":"#FF3333","gameName":"英超","guestHalfScore":1,"guestScore":1,"guestTeamName":"诺维奇","handicap":0,"homeHalfScore":1,"homeScore":1,"homeTeamName":"南安普敦","matchKey":"20121128-023","matchTime":"2012-11-29 03:45:00","result":"","sp":""},{"cancel":false,"ended":true,"gameColor":"#57A87B","gameName":"苏超","guestHalfScore":0,"guestScore":1,"guestTeamName":"希伯尼安","handicap":0,"homeHalfScore":0,"homeScore":0,"homeTeamName":"圣约翰斯通","matchKey":"20121128-031","matchTime":"2012-11-29 03:45:00","result":"负|1|0:1|平负","sp":"4.36|0.0|19.0|0.0"},{"cancel":false,"ended":true,"gameColor":"#FF3333","gameName":"英超","guestHalfScore":0,"guestScore":0,"guestTeamName":"西汉姆联","handicap":-1,"homeHalfScore":1,"homeScore":1,"homeTeamName":"曼彻斯特联","matchKey":"20121128-032","matchTime":"2012-11-29 04:00:00","result":"平|1|1:0|胜胜","sp":"4.56|15.12|17.0|2.88"},{"cancel":false,"ended":true,"gameColor":"#FF3333","gameName":"英超","guestHalfScore":0,"guestScore":2,"guestTeamName":"曼彻斯特城","handicap":0,"homeHalfScore":0,"homeScore":0,"homeTeamName":"维冈竞技","matchKey":"20121128-033","matchTime":"2012-11-29 04:00:00","result":"负|2|0:2|平负","sp":"2.0|9.92|14.0|8.84"}]}</td>
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
						7 = 系统内部错误<br/>
						//提示性错误<br/>
						8-期数据不存在.<br/>
						9 =对阵不存在<br/>
						10-彩种为空<br/>
						11-期号为空<br/>
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
	        <td class="doc_td_head_1">match</td>
	        <td class="doc_td_other">json字符串</td>
	        <td class="doc_td_other">0-1000</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">返回开售的场次列表</td>
	        <td class="doc_td_other">场次具体属性参考下表</td>
      </tr>
    </table>
     <div class="k10"></div>
     <div class="bgtitlec">场次具体属性</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">参数</td>
	        <td width="70" class="doc_td_other">类型</td>
	        <td width="70" class="doc_td_other">长度</td>
	        <td width="100" class="doc_td_other">是否必须</td>
	        <td width="100" class="doc_td_other">名称</td>
	        <td class="doc_td_other">说明</td>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">matchKey</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">场次序号</td>
	        <td class="doc_td_other">格式<br/>北单，足彩：<br/>场次序号 如 1，2，3，4<br/>竞彩：<br/>yyyyMMdd-序号，例如20120602-065</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">gameName</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">比赛名字</td>
	        <td class="doc_td_other">如：欧洲杯</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">matchTime</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">比赛日期</td>
	        <td class="doc_td_other">格式yyyy-MM-dd hh：mm,例如2012-06-03 01:59</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">gameColor</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">比赛颜色</td>
	        <td class="doc_td_other">例如#660000</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">homeTeamName</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">比赛主队</td>
	        <td class="doc_td_other"></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">guestTeamName</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">比赛客队</td>
	        <td class="doc_td_other"></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">handicap</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">1-6</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">比赛让分</td>
	        <td class="doc_td_other">竞彩篮球的预设总分	指的是主队让客队的分数值如-1表示主队让客队一球。总分如：如195.5</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">cancel</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">是否取消</td>
	        <td class="doc_td_other">true/false</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">ended</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">是否结束比赛</td>
	        <td class="doc_td_other">true/false</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">homeHalfScore</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">上半场主队比分</td>
	        <td class="doc_td_other">篮球为空</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">guestHalfScore</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">上半场客队比分</td>
	        <td class="doc_td_other">篮球为空</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">homeScore</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">全场主队比分</td>
	        <td class="doc_td_other"></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">guestScore</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">全场客队比分</td>
	        <td class="doc_td_other"></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">totalScore</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">竞彩蓝球预设总分</td>
	        <td class="doc_td_other">如195.5</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">result</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">比赛的结果</td>
	        <td class="doc_td_other">竞彩足球：<br/>
				胜平负结果|进球数结果|比分结果|半全场结果<br/>
				如 ：平|1|1:0|胜胜
			</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">resultSp</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">比赛的最终sp</td>
	        <td class="doc_td_other">用|分隔	竞彩足球：<br/>
					胜平负sp|进球数sp|比分sp|半全场sp<br/>
					如2.28|5.7|9.94|8.96
			</td>
      </tr>
      
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>