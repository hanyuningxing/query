//Date.prototype.format = function(format) {
//	var o = {
//		"M+" : this.getMonth() + 1, // month
//		"d+" : this.getDate(), // day
//		"h+" : this.getHours(), // hour
//		"m+" : this.getMinutes(), // minute
//		"s+" : this.getSeconds(), // second
//		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
//		"S" : this.getMilliseconds()
//	// millisecond
//	};
//	if (/(y+)/.test(format))
//		format = format.replace(RegExp.$1, (this.getFullYear() + "")
//				.substr(4 - RegExp.$1.length));
//	for ( var k in o)
//		if (new RegExp("(" + k + ")").test(format))
//			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
//					: ("00" + o[k]).substr(("" + o[k]).length));
//	return format;
//};
/**
	 * 格式化日期
	 */
	Date.prototype.format = function(formatStr) {
		var str = formatStr;
		var Week = ['日', '一', '二', '三', '四', '五', '六'];
		str = str.replace(/yyyy|YYYY/, this.getFullYear());
	    str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));
		str = str.replace(/MM/, (this.getMonth() + 1) > 9 ? (this.getMonth() + 1).toString() : '0' + (this.getMonth() + 1));
		str = str.replace(/M/g, (this.getMonth() + 1));
		str = str.replace(/w|W/g, Week[this.getDay()]);
	    str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
		str = str.replace(/d|D/g, this.getDate());
		str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
		str = str.replace(/h|H/g, this.getHours());
		str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
		str = str.replace(/m/g, this.getMinutes());
		str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
		str = str.replace(/s|S/g, this.getSeconds());
		return str;
	};	

/**
 * 获取本周、本季度、本月、上月的开始日期、结束日期
 */
var now = new Date(); // 当前日期
var nowDayOfWeek = now.getDay(); // 今天本周的第几天
var nowDay = now.getDate(); // 当前日
var nowMonth = now.getMonth(); // 当前月
var nowYear = now.getYear(); // 当前年
nowYear += (nowYear < 2000) ? 1900 : 0; //   
var lastMonthDate = new Date(); // 上月日期
lastMonthDate.setDate(1);
lastMonthDate.setMonth(lastMonthDate.getMonth() - 1);
var lastYear = lastMonthDate.getYear();
var lastMonth = lastMonthDate.getMonth();
// 格式化日期：yyyy-MM-dd
function formatDate(date) {
	var myyear = date.getFullYear();
	var mymonth = date.getMonth() + 1;
	var myweekday = date.getDate();
	if (mymonth < 10) {
		mymonth = "0" + mymonth;
	}
	if (myweekday < 10) {
		myweekday = "0" + myweekday;
	}
	return (myyear + "-" + mymonth + "-" + myweekday);
}
// 获得某月的天数
function getMonthDays(myMonth) {
	var monthStartDate = new Date(nowYear, myMonth, 1);
	var monthEndDate = new Date(nowYear, myMonth + 1, 1);
	var days = (monthEndDate - monthStartDate) / (1000 * 60 * 60 * 24);
	return days;
}
// 获得本季度的开始月份
function getQuarterStartMonth() {
	var quarterStartMonth = 0;
	if (nowMonth < 3) {
		quarterStartMonth = 0;
	}
	if (2 < nowMonth && nowMonth < 6) {
		quarterStartMonth = 3;
	}
	if (5 < nowMonth && nowMonth < 9) {
		quarterStartMonth = 6;
	}
	if (nowMonth > 8) {
		quarterStartMonth = 9;
	}
	return quarterStartMonth;
}
// 获得本周的开始日期
function getWeekStartDate() {
	var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
	return formatDate(weekStartDate);
}
// 获得本周的结束日期
function getWeekEndDate() {
	var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
	return formatDate(weekEndDate);
}
// 获得上周的开始日期
function getLastWeekStartDate() {
	var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek - 7);
	return formatDate(weekStartDate);
}
// 获得上周的结束日期
function getLastWeekEndDate() {
	var weekEndDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek - 1);
	return formatDate(weekEndDate);
}
// 获得本月的开始日期
function getMonthStartDate() {
	var monthStartDate = new Date(nowYear, nowMonth, 1);
	return formatDate(monthStartDate);
}
// 获得本月的结束日期
function getMonthEndDate() {
	var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));
	return formatDate(monthEndDate);
}
// 获得上月开始时间
function getLastMonthStartDate() {
	var lastMonthStartDate = new Date(nowYear, lastMonth, 1);
	return formatDate(lastMonthStartDate);
}
// 获得上月结束时间
function getLastMonthEndDate() {
	var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));
	return formatDate(lastMonthEndDate);
}
// 获得本季度的开始日期
function getQuarterStartDate() {
	var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1);
	return formatDate(quarterStartDate);
}
// 或的本季度的结束日期
function getQuarterEndDate() {
	var quarterEndMonth = getQuarterStartMonth() + 2;
	var quarterStartDate = new Date(nowYear, quarterEndMonth,
			getMonthDays(quarterEndMonth));
	return formatDate(quarterStartDate);
}