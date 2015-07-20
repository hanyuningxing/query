<meta name="decorator" content="doc" />
<div class="mright">
    <div class="bgtitlec">足彩,北单,竞彩开售场次查询接口（104）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">104</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">查询足彩,北单,竞彩开售场次。</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2">{"wLotteryId":17,"periodNumber":"","playType":"0","type":"0"}</td>
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
	        <td class="doc_td_head_1">playType</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-2</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">玩法</td>
	        <td class="doc_td_other">参考左侧菜单《彩种说明和格式》</td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">type</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-2</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">投注方法</td>
	        <td class="doc_td_other">参考左侧菜单《彩种说明和格式》</td>
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
        <td class="doc_title_td2">{"processId":"0","match":[{"cancel":false,"ended":false,"gameColor":"#004488","gameName":"瑞典超级联赛","guestTeamName":"松兹瓦尔","handicap":-1,"homeTeamName":"马尔默","matchKey":"20120827-001","matchTime":"2012-08-28 00:59:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":6.02},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":3.16},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":3.96}}"},{"cancel":false,"ended":false,"gameColor":"#004488","gameName":"瑞典超级联赛","guestTeamName":"叙利亚人","handicap":0,"homeTeamName":"米亚尔比","matchKey":"20120827-002","matchTime":"2012-08-28 00:59:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":4.12},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":3.8},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":4.36}}"},{"cancel":false,"ended":false,"gameColor":"#666666","gameName":"挪威超级联赛","guestTeamName":"奥勒松","handicap":0,"homeTeamName":"腓特烈斯塔","matchKey":"20120827-003","matchTime":"2012-08-28 00:59:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":2.82},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":4.7},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":5.94}}"},{"cancel":false,"ended":false,"gameColor":"#004488","gameName":"瑞典超级联赛","guestTeamName":"北雪平","handicap":0,"homeTeamName":"奥特维达堡","matchKey":"20120827-004","matchTime":"2012-08-28 01:04:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":4.96},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":3.36},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":4.24}}"},{"cancel":false,"ended":false,"gameColor":"#006633","gameName":"西班牙甲级联赛","guestTeamName":"莱万特","handicap":0,"homeTeamName":"巴利亚多利德","matchKey":"20120827-005","matchTime":"2012-08-28 01:59:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":4.66},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":2.66},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":6.92}}"},{"cancel":false,"ended":false,"gameColor":"#BE2B8F","gameName":"荷兰乙级联赛","guestTeamName":"多德勒支","handicap":0,"homeTeamName":"登博思","matchKey":"20120827-006","matchTime":"2012-08-28 01:59:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":5.88},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":3.26},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":3.86}}"},{"cancel":false,"ended":false,"gameColor":"#DB31EE","gameName":"德国乙级联赛","guestTeamName":"科隆","handicap":0,"homeTeamName":"奥厄","matchKey":"20120827-007","matchTime":"2012-08-28 02:14:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":2.82},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":4.82},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":5.74}}"},{"cancel":false,"ended":false,"gameColor":"#5BC992","gameName":"法国乙级联赛","guestTeamName":"勒芒","handicap":0,"homeTeamName":"南特","matchKey":"20120827-008","matchTime":"2012-08-28 02:29:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":8.08},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":2.64},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":4.28}}"},{"cancel":false,"ended":false,"gameColor":"#008888","gameName":"葡萄牙超级联赛","guestTeamName":"里奥阿维","handicap":0,"homeTeamName":"里斯本竞技","matchKey":"20120827-009","matchTime":"2012-08-28 03:14:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":14.92},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":2},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":14.5}}"},{"cancel":false,"ended":false,"gameColor":"#006633","gameName":"西班牙甲级联赛","guestTeamName":"毕尔巴鄂竞技","handicap":0,"homeTeamName":"马德里竞技","matchKey":"20120827-010","matchTime":"2012-08-28 03:59:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":9.74},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":2.2},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":5.68}}"},{"cancel":false,"ended":false,"gameColor":"#0CB9E4","gameName":"阿根廷甲级联赛","guestTeamName":"科隆竞技","handicap":0,"homeTeamName":"拉普拉塔大学生","matchKey":"20120827-011","matchTime":"2012-08-28 06:14:00","open":true,"sp":"{\\"LOSE\\":{\\"chg\\":0,\\"key\\":\\"LOSE\\",\\"value\\":6.3},\\"WIN\\":{\\"chg\\":0,\\"key\\":\\"WIN\\",\\"value\\":2.4},\\"DRAW\\":{\\"chg\\":0,\\"key\\":\\"DRAW\\",\\"value\\":6.3}}"}]}</td>
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
	        <td class="doc_td_head_1">endSaleTime</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">20</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">截至日期</td>
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
	        <td class="doc_td_head_1">open</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">是否结束销售</td>
	        <td class="doc_td_other">true/false</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">sp</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">即时sp</td>
	        <td class="doc_td_other">Json格式</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">mixOpen</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">是否结束销售</td>
	        <td class="doc_td_other">Json格式（混合串的时候会返回）</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">mixSp</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">即时sp</td>
	        <td class="doc_td_other">Json格式</td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>