 		
 	 function dateDiff(str1,str2,$obj){
 			var date1 = new Date(Date.parse(str1.replace(/-/g,"/")));
 			var date2 = new Date(Date.parse(str2.replace(/-/g,"/")));
			var time = Math.abs(date1.getTime()-date2.getTime());
			var h = parseInt(time/1000/60/60);
			var m = parseInt((time-h*1000*3600)/1000/60);
 			$obj.attr("tips","<span style='background-color:white;padding:5px 10px 5px 10px;'>最新:"+h+"时 "+m+"分</span>");
 			if(h<=4){
 		 		$obj.find("em").attr("class","time_"+h);
 		 	}
 		}
 	
 		function showOdds(){
 			var odds_99 = $("#odds_99");		 
 			var h = odds_99.find("span[name='home']").text();
 			var o = odds_99.find("span[name='off']").text();
 			var g = odds_99.find("span[name='guest']").text();		
			var F99 = toDecimal(1/(1/h+1/o+1/g));				 
 			var tr= $("tr[name^='odds_']");	 
 			var lastModifyTime_99 = odds_99.attr("time");
 			var firstHome,firstOff,firstGuest,home,off,guest,kWin,kDraw,kLose,fanhuan,gWin,gDraw,gLose,count=0,ave_fh=0,ave_fo=0,ave_fg=0,ave_h=0,ave_o=0,ave_g=0,ave_kw=0,ave_kd=0,ave_kl=0;
 			var ave_gw=0,ave_gd=0,ave_gl=0,ave_fanhuan=0,lastModifyTime;
 			var list_h = new Array();
 			var list_o = new Array();
 			var list_g = new Array();
 			var list_fh = new Array();
 			var list_fo = new Array();
 			var list_fg = new Array();
 			var list_kw = new Array();
 			var list_kd = new Array();
 			var list_kl = new Array();
 			var list_gw = new Array();
 			var list_gd = new Array();
 			var list_gl = new Array();
 			var list_fanhuan = new Array();
 			tr.each(function(){
 				try{
 					 count=count+1;
	 				 home = parseFloat($(this).find("span[name='home']").text());
	 				 off = parseFloat($(this).find("span[name='off']").text());
	 				 guest = parseFloat($(this).find("span[name='guest']").text());
	 				 list_h.push(home);
	 				 list_o.push(off);
	 				 list_g.push(guest);
	 				 ave_h = ave_h+home;
	 				 ave_o = ave_o+off;
	 				 ave_g = ave_g+guest; 				 
	 				 firstHome = parseFloat($(this).find("span[name='firstHome']").text());
	 				 firstOff = parseFloat($(this).find("span[name='firstOff']").text());
	 				 firstGuest = parseFloat($(this).find("span[name='firstGuest']").text());
	 		  		 list_fh.push(firstHome);
	 				 list_fo.push(firstOff);
	 				 list_fg.push(firstGuest);
	 				 ave_fh = ave_fh+firstHome;
	 				 ave_fo = ave_fo+firstOff;
	 				 ave_fg = ave_fg+firstGuest;
	 				 kWin = parseFloat((home/h)*F99);
	 				 kDraw = parseFloat((off/o)*F99);
	 				 kLose = parseFloat((guest/g)*F99);
	 				 ave_kw = ave_kw+kWin;
	 				 ave_kd = ave_kd+kDraw;
	 				 ave_kl = ave_kl+kLose;
	 	 			 list_kw.push(kWin);
	 				 list_kd.push(kDraw);
	 				 list_kl.push(kLose);
	 				 fanhuan =1/(1/home+1/off+1/guest);	 				 
	 				 ave_fanhuan = ave_fanhuan+ fanhuan;	
	 				 list_fanhuan.push(fanhuan);			 
	 				 gWin = parseFloat(fanhuan/home*100);
	 				 gDraw = parseFloat(fanhuan/off*100);
	 				 gLose = parseFloat(fanhuan/guest*100);
	 				 ave_gw = ave_gw+gWin;
	 				 ave_gd = ave_gd+gDraw;
	 				 ave_gl = ave_gl+gLose;
	 				 list_gw.push(gWin);
	 				 list_gd.push(gDraw);
	 				 list_gl.push(gLose);
	 				 $(this).find("span[name='kWin']").text(toDecimal(kWin));
	 				 $(this).find("span[name='kDraw']").text(toDecimal(kDraw));
	 				 $(this).find("span[name='kLose']").text(toDecimal(kLose));
	 				 $(this).find("span[name='gWin']").text(toDecimal(gWin));
	 				 $(this).find("span[name='gDraw']").text(toDecimal(gDraw));
	 				 $(this).find("span[name='gLose']").text(toDecimal(gLose));
	 				 $(this).find("span[name='fanhuan']").text(toDecimal(fanhuan));				 
		 			 lastModifyTime = $(this).find("span[name='lastModifyTime']").attr("time");				
		 			 dateDiffStr = dateDiff(lastModifyTime,lastModifyTime_99,$(this).find("span[name='lastModifyTime']"));
		 			 
 				 }catch(e){
 				 	
 				 }
 			});
 
 			 $("#ave_odds").find("span[name='firstHome']").text(toDecimal(ave_fh/count));
	 		 $("#ave_odds").find("span[name='firstOff']").text(toDecimal(ave_fo/count));
	 		 $("#ave_odds").find("span[name='firstGuest']").text(toDecimal(ave_fg/count));
	 		 $("#ave_odds").find("span[name='home']").text(toDecimal(ave_h/count));
	 		 $("#ave_odds").find("span[name='off']").text(toDecimal(ave_o/count));
	 		 $("#ave_odds").find("span[name='guest']").text(toDecimal(ave_g/count));
	 		 $("#ave_odds").find("span[name='gWin']").text(toDecimal(ave_gw/count));
	 		 $("#ave_odds").find("span[name='gDraw']").text(toDecimal(ave_gd/count));
	 		 $("#ave_odds").find("span[name='gLose']").text(toDecimal(ave_gl/count));
	 		 $("#ave_odds").find("span[name='kWin']").text(toDecimal(ave_kw/count));
	 		 $("#ave_odds").find("span[name='kDraw']").text(toDecimal(ave_kd/count));
	 		 $("#ave_odds").find("span[name='kLose']").text(toDecimal(ave_kl/count));
	 		 $("#ave_odds").find("span[name='fanhuan']").text(toDecimal(ave_fanhuan/count));
	 		 
	 		 list_h.sort(); 
 			 list_o.sort();
 			 list_g.sort();
 			 list_fh.sort();
 			 list_fo.sort();
 			 list_fg.sort();
 			 list_kw.sort();
 			 list_kd.sort();
 			 list_kl.sort();
 			 list_gw.sort();
 			 list_gd.sort();
 			 list_gl.sort();
 			 list_fanhuan.sort();
 			 
 		 	 var small_h = list_h[0],big_h=	list_h[list_h.length-1];
 		 	 var small_o = list_o[0],big_o=	list_o[list_o.length-1];
 		 	 var small_g = list_g[0],big_g=	list_g[list_g.length-1];
 		 	 var small_fh = list_fh[0],big_fh= list_fh[list_fh.length-1];
 		 	 var small_fo = list_fo[0],big_fo= list_fo[list_fo.length-1];
 		 	 var small_fg = list_fg[0],big_fg= list_fg[list_fg.length-1];
 		 	 var small_kw = list_kw[0],big_kw=list_kw[list_kw.length-1];
 		 	 var small_kd = list_kd[0],big_kd=list_kd[list_kd.length-1];
 		 	 var small_kl = list_kl[0],big_kl=list_kl[list_kl.length-1];
 		 	 var small_gw = list_gw[0],big_gw=list_gw[list_gw.length-1];
 		 	 var small_gd = list_gd[0],big_gd=list_gd[list_gd.length-1];
 		 	 var small_gl = list_gl[0],big_gl=list_gl[list_gl.length-1];
 		 	 var small_fanhuan = list_fanhuan[0],big_fanhuan=list_fanhuan[list_fanhuan.length-1];
 		 	 
 		 	 $("span[name='firstHome']:contains('"+toDecimal(small_fh)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='firstOff']:contains('"+toDecimal(small_fo)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='firstGuest']:contains('"+toDecimal(small_fg)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='home']:contains('"+toDecimal(small_h)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='off']:contains('"+toDecimal(small_o)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='guest']:contains('"+toDecimal(small_g)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='gWin']:contains('"+toDecimal(small_gw)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='gDraw']:contains('"+toDecimal(small_gd)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='gLose']:contains('"+toDecimal(small_gl)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='kWin']:contains('"+toDecimal(small_kw)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='kDraw']:contains('"+toDecimal(small_kd)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='kLose']:contains('"+toDecimal(small_kl)+"')").css({"color":"green","font-weight":"bold"});
 			 $("span[name='fanhuan']:contains('"+toDecimal(small_fanhuan)+"')").css({"color":"green","font-weight":"bold"});
 			 
 			 $("span[name='firstHome']:contains('"+toDecimal(big_fh)+"')").css({"font-weight":"bold"});
 			 $("span[name='firstOff']:contains('"+toDecimal(big_fo)+"')").css({"font-weight":"bold"});
 			 $("span[name='firstGuest']:contains('"+toDecimal(big_fg)+"')").css({"font-weight":"bold"});
 			 $("span[name='home']:contains('"+toDecimal(big_h)+"')").css({"font-weight":"bold"});
 			 $("span[name='off']:contains('"+toDecimal(big_o)+"')").css({"font-weight":"bold"});
 			 $("span[name='guest']:contains('"+toDecimal(big_g)+"')").css({"font-weight":"bold"});
 			 $("span[name='gWin']:contains('"+toDecimal(big_gw)+"')").css({"font-weight":"bold"});
 			 $("span[name='gDraw']:contains('"+toDecimal(big_gd)+"')").css({"font-weight":"bold"});
 			 $("span[name='gLose']:contains('"+toDecimal(big_gl)+"')").css({"font-weight":"bold"});
 			 $("span[name='kWin']:contains('"+toDecimal(big_kw)+"')").css({"font-weight":"bold"});
 			 $("span[name='kDraw']:contains('"+toDecimal(big_kd)+"')").css({"font-weight":"bold"});
 			 $("span[name='kLose']:contains('"+toDecimal(big_kl)+"')").css({"font-weight":"bold"});
 			 $("span[name='fanhuan']:contains('"+toDecimal(big_fanhuan)+"')").css({"font-weight":"bold"});
 		 	 
 		 	 $("#big_odds").find("span[name='firstHome']").text(toDecimal(big_fh));
	 		 $("#big_odds").find("span[name='firstOff']").text(toDecimal(big_fo));
	 		 $("#big_odds").find("span[name='firstGuest']").text(toDecimal(big_fg));
	 		 $("#big_odds").find("span[name='home']").text(toDecimal(big_h));
	 		 $("#big_odds").find("span[name='off']").text(toDecimal(big_o));
	 		 $("#big_odds").find("span[name='guest']").text(toDecimal(big_g));
	 		 $("#big_odds").find("span[name='gWin']").text(toDecimal(big_gw));
	 		 $("#big_odds").find("span[name='gDraw']").text(toDecimal(big_gd));
	 		 $("#big_odds").find("span[name='gLose']").text(toDecimal(big_gl));
	 		 $("#big_odds").find("span[name='kWin']").text(toDecimal(big_kw));
	 		 $("#big_odds").find("span[name='kDraw']").text(toDecimal(big_kd));
	 		 $("#big_odds").find("span[name='kLose']").text(toDecimal(big_kl));
	 		 $("#big_odds").find("span[name='fanhuan']").text(toDecimal(big_fanhuan));
	 		 
	 		 $("#small_odds").find("span[name='firstHome']").text(toDecimal(small_fh));
	 		 $("#small_odds").find("span[name='firstOff']").text(toDecimal(small_fo));
	 		 $("#small_odds").find("span[name='firstGuest']").text(toDecimal(small_fg));
	 		 $("#small_odds").find("span[name='home']").text(toDecimal(small_h));
	 		 $("#small_odds").find("span[name='off']").text(toDecimal(small_o));
	 		 $("#small_odds").find("span[name='guest']").text(toDecimal(small_g));
	 		 $("#small_odds").find("span[name='gWin']").text(toDecimal(small_gw));
	 		 $("#small_odds").find("span[name='gDraw']").text(toDecimal(small_gd));
	 		 $("#small_odds").find("span[name='gLose']").text(toDecimal(small_gl));
	 		 $("#small_odds").find("span[name='kWin']").text(toDecimal(small_kw));
	 		 $("#small_odds").find("span[name='kDraw']").text(toDecimal(small_kd));	 		 
	 		 $("#small_odds").find("span[name='kLose']").text(toDecimal(small_kl));
	 		 $("#small_odds").find("span[name='fanhuan']").text(toDecimal(small_fanhuan));
 			 
 			
 			 
 		}
 		$(function(){
 			showOdds();
 		});
 		function showTimeTips(obj) {
 		    tip.show3(obj);
 		}