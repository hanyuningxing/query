 var o_companyArr = {};
 o_companyArr[24] = '99家';
 o_companyArr[14] = '威廉';
 o_companyArr[82] = '立博';
 o_companyArr[27] = 'Bet365';
 o_companyArr[84] = '澳门';

var current_odds_company=82;
var current_eur_odds_company=82;

function changeAsiaCompany(obj){
	var company = obj.value;
	$(".odds_asia_div").hide();
	$(".odds_asia_div_"+company).show();
	current_odds_company=company;
}
function changeEuropeCompany(obj){
	var company = obj.value;
	$(".odds_eur_div").hide();
	$(".odds_eur_div_"+company).show();
	current_eur_odds_company=company;
}

var panluArr={};
panluArr[50]='<font style="color:red">赢</font>';
panluArr[25]='<font style="color:red">赢半</font>';
panluArr[0]='<font style="color:#111">走</font>';
panluArr[-25]='<font style="color:blue">输半</font>';
panluArr[-50]='<font style="color:blue">输</font>';
	var o_pankou = {};
	o_pankou[0]='平手';
	o_pankou[-2000]='两球';
	o_pankou[-1750]='球半/两';
	o_pankou[-1500]='球半';
	o_pankou[-1250]='一/球半';
	o_pankou[-1000]='一球';
	o_pankou[-750]='半/一';
	o_pankou[-500]='半球';
	o_pankou[-250]='平/半';	
	o_pankou[250]='受平/半';
	o_pankou[500]='受半球';
	o_pankou[750]='受半/一'; 	
	o_pankou[1000]='受一球';
	o_pankou[1250]='受一/球半';
	o_pankou[1500]='受球半';
	o_pankou[1750]='受球半/两';
	o_pankou[2000]='受球半/两';	
	o_pankou[2250]='受两/两半';
	o_pankou[2500]='受两半';
	o_pankou[2750]='受两球半/三球';
	o_pankou[3000]='受三球';	
	o_pankou[-3000] = "三球";
	o_pankou[-2750]='两球半/三球';
	o_pankou[-2500]='两半';	
	o_pankou[-2250]='两/两半';
	
function showMatchHisTips(obj,okId,t){
	$(".match_history_tr").hide(0);
	var match_history = document.getElementById("_"+okId+"_"+t+"mh");
	if(!match_history){
		var div = document.createElement("div");
		div.setAttribute("class","match_history_tr");
		div.setAttribute("id","_"+okId+"_"+t+"mh");
		var url = window.BASESITE+"/odds/otherMatchHis?okId="+okId+"&t="+t;
		$.ajax({
			type:"GET",
			url:url,
			dataType:"json",
			success:function(json){
				try{
					  var html =' <table width="100%"  class="table">' +
					   			'  <tr height="24"> <th width="80" height="38">时间</th><th width="60">联赛</th> <th width="93">主队</th><th width="38">比分</th> <th width="93">客队 </th><th width="175">亚赔<select id="_'+okId+'_'+t+'sa" onchange="changeAsiaCompany(this)"><option value="82">立博</option><option value="27">Bet365</option><option value="84">澳门</option></select></th><th width="199">欧终赔(初赔)<select  id="_'+okId+'_'+t+'se"  onchange="changeEuropeCompany(this)" class="selectEurope"><option value="82">立博</option><option value="27">Bet365</option><option value="24">99家</option><option value="14">威廉</option></select></td><td>&nbsp;</th></tr>';
					
					   html+=buildMatchHis(json[0],t)+'</table>';  
					   var mh_tr =document.getElementById("_"+okId+"_matchHis");
					   div.innerHTML=html;
					   mh_tr.appendChild(div);		
					   document.getElementById('_'+okId+'_'+t+'sa').value= current_odds_company;
					   document.getElementById('_'+okId+'_'+t+'se').value= current_eur_odds_company;
				}catch(e){
					alert(e);
				}
			},
			error:function(){
				alert("error");
			}	
		});
	}	
}
function buildMatchHis(jsonData,t){
	var html ="";
	 var matchArr,homeScore,guestScore;
	 var data_arr = eval(jsonData);
	 for(var i=0;i<data_arr.length;i++){		   			   
		   matchArr=data_arr[i]; 				
		   homeScore=matchArr[3];
		   if(homeScore!=null){
				guestScore=matchArr[4]==null?"":matchArr[4];
				var odds_data=matchArr[10]+"";
				var odds_arr;
				try{
					odds_arr=eval(odds_data);	
				}catch(e){
					odds_arr=[];
				}		 
				var asiaHomeWin,asiaStandoff,asiaGuestWin,homeWin,standoff,guestwin,firstHomeWin,firstStandoff,firstGuestWin;
				var asisSpan='';var europeSpan='';	
				var display='';
				var trClass='';
				for(var j=0;j<odds_arr.length;j++){
					display='style="display:none;"'; 					
					var odds= odds_arr[j]; 
					asiaHomeWin=(odds[1])?odds[1]:'-';
					asiaStandoff=(odds[2]!=null)?odds[2]:'';
					asiaStandoffStr=(odds[2]!=null)?o_pankou[odds[2]]:'-';
					asiaGuestWin=(odds[3])?odds[3]:'-';
					homeWin=(odds[4])?odds[4]:'-';standoff=(odds[5])?odds[5]:'-';guestwin=(odds[6])?odds[6]:'-';
					firstHomeWin=(odds[7])?'('+odds[7]+')':'';firstStandoff=(odds[8])?'('+odds[8]+')':'';firstGuestWin=(odds[9])?'('+odds[9]+')':'';
					var panlu='';					 
						try{ 
							var pan = homeScore-guestScore+asiaStandoff/1000 ;						 
							if(asiaStandoff==0){
								 pan = homeScore-guestScore ;
							}	
							if((typeof(homeScore)=='string'&& homeScore=="")||(typeof(asiaStandoff)=='string'&& asiaStandoff=="")){
								panlu='-';
							}else{							
								if(pan==0){
									panlu=panluArr[0] ;
								}
								if(t==1||t==3){
									pan=-pan;
								}					
								if(pan==0.25){
									panlu=panluArr[25] ;
								}else if(pan==-0.25){
									panlu=panluArr[-25] ;
								}else if(pan>0.25){
									panlu=panluArr[50] ;
								}else if(pan<-0.25){
									panlu=panluArr[-50];
								}
							}		
						}catch(ee){
							
						}
				 
					if(odds[0]==current_odds_company){
						display='';
					}
					asisSpan+='<div class="odds_asia_div odds_asia_div_'+odds[0]+'" '+display+'><span class="odds_span d_yel_left1">'+asiaHomeWin+'</span><span class="odds_span d_yel_left1" style="width:50px;">'+asiaStandoffStr+'</span><span class="odds_span d_yel_left1">'+asiaGuestWin+'</span><span class="odds_span d_yel_leftrig1" style="width:28px;border-right:0px" >'+panlu+'</span>'+
								'</div>';
					europeSpan+='<div class="odds_eur_div odds_eur_div_'+odds[0]+'" '+display+'><span class="odds_span d_blue_left1"><font style="color:#0ca3d2;">'+homeWin+'</font>'+firstHomeWin+'</span><span class="odds_span d_blue_left1"><font style="color:#0ca3d2;">'+ standoff +'</font>'+firstStandoff+'</span><span class="odds_span d_blue_leftrig1"><font style="color:#0ca3d2;">'+guestwin+'</font>'+firstGuestWin+'</span></div>';
				}
				if(i%2==0){
					trClass='tdlist';
				}else{
					trClass='tdlist1';
				}
			  html+='<tr  align="center" id="match_history_'+i+'" class="'+trClass+'"><td height="30" width="76">'+matchArr[7]+'</td><td width="57">'+matchArr[6]+'</td>'+
			  			'<td  align="right" width="87">'+matchArr[2]+'</td><td width="38"><b>'+homeScore+'-'+guestScore+'</b></td><td  align="left" width="87">'+matchArr[5]+'</td>'+
			  			'<td  width="160">'+asisSpan+'</td>'+'<td  width="190">'+europeSpan+'</td>'+
			  		'</tr>';
		   }
	 }
	 return html;
}

 
function hideMatchHisTips(){
	$('.match_history_tr').hide(0);
}

	