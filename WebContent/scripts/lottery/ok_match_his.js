function changeCompany(obj,tableName,className){
	var company = obj.value;
	var $table = $("table[name='"+tableName+"']"); 
	$table.find("."+className).hide();
	$table.find("."+className+"_"+company).show();
	current_odds_company=company;
}

var current_odds_company=82;
var current_eur_odds_company=82;

$(function(){
	var key = document.getElementById("matchKey").innerHTML;
	var matchType = document.getElementById("matchType").innerHTML;
	showMatchHis(key,matchType,1);
	showMatchHis(key,matchType,2);
});


function showMatchHis(key,matchType,t){
	var div = document.createElement("div");
    
    div.setAttribute("class","match_history_tr");
   
	var url =  window.BASESITE+"/odds/matchHisAj?key="+key+"&matchType="+matchType+"&t="+t;
	$.ajax({
    type : "GET", 
    url : url,
	   cache:true,
	   dataType:"json", 
	   success : function(json){ 	  
		   var html =' <table width="790" name="table'+t+'" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;"  id="_'+key+'_'+matchType+'_'+t+'mh'+'">'+
		   			 '<tr class="tdtitle"><td  class="doc_td_head_1">联赛</td><td class="doc_td_other">时间</td><td class="doc_td_other">主队</td><td class="doc_td_other">比分</td><td class="doc_td_other">客队</td><td class="doc_td_other">半场</td><td class="doc_td_other">欧赔<select onchange="changeCompany(this,\'table'+t+'\',\'odds_eur_div\')"><option value="24">99家</option<option value="14">威廉</option>><option value="82">立博</option><option value="27">Bet365</option></select></td>'+
      			     '<td class="doc_td_other">亚赔<select onchange="changeCompany(this,\'table'+t+'\',\'odds_asia_div\')"><option value="82">立博</option><option value="27">Bet365</option><option value="84">澳门</option></select></td></tr>';
		   html+=buildMatchHis(json[0],t)+'</table>';
		   var mh_tr =document.getElementById("matchHis"+t);
		   div.innerHTML=html;
		   mh_tr.appendChild(div);
	 		},
		error:function(){
			 alert(22222);
		}
	 });
}

function buildMatchHis(jsonData,t){
	var html ="";
	 var matchArr;
	 var data_arr=[];
	 try{
	   data_arr = eval(jsonData);
	 }catch(e){
		 
	 }
	 for(var i=0;i<data_arr.length;i++){	
		 try{
			 	matchArr=data_arr[i]; 						   
				var odds_arr,asia_odds_arr;
		 
				odds_arr= matchArr[9];	
		 
				asia_odds_arr= matchArr[10] ;	
		 	
 
				var asisSpan='';var europeSpan='';	
				var display='';
				var trClass='';
				
				for(var j=0;j<odds_arr.length;j++){
					display='style="display:none;"'; 					
					var odds= odds_arr[j]; 		 
					if(odds[0]==current_odds_company){
						display='';
					}		
					europeSpan+='<div class="odds_eur_div odds_eur_div_'+odds[0]+'" '+display+'><span class="odds_span d_yel_left1">'+odds[4]+'('+odds[1]+')</span><span class="odds_span d_yel_left1" style="width:50px;">'+
									odds[5]+'('+odds[2]+')</span><span class="odds_span d_yel_left1">'+ odds[6]+'('+odds[3]+'</span><span class="odds_span d_yel_leftrig1" ></span>'+
					'</div>';
				}
				
				for(var j=0;j<asia_odds_arr.length;j++){
					display='style="display:none;"'; 					
					var odds= odds_arr[j]; 
				 
					if(odds[0]==current_odds_company){
						display='';
					}
					asisSpan+='<div class="odds_asia_div odds_asia_div_'+odds[0]+'" '+display+'><span class="odds_span d_yel_left1">'+odds[4]+'('+odds[1]+')</span><span class="odds_span d_yel_left1" style="width:50px;">'+
							odds[5]+'('+odds[2]+')</span><span class="odds_span d_yel_left1">'+ odds[6]+'('+odds[3]+'</span><span class="odds_span d_yel_leftrig1" ></span>'+
					'</div>';
				}
				
				if(i%2==0){
					trClass='tdwhitelist';
				}else{
					trClass='tdgraylist';
				}
			  html+='<tr  id="match_history_'+i+'_'+t+'" class="'+trClass+'"><td class="doc_td_other">'+matchArr[1]+'</td><td class="doc_td_other">'+matchArr[2]+'</td>'+ 
			  			'<td class="doc_td_other">'+matchArr[3]+'</td>'+
			  			'<td class="doc_td_other"><b>'+matchArr[4]+'-'+matchArr[5]+'</b></td><td class="doc_td_other">'+matchArr[6]+'</td>'+
			  			'<td class="doc_td_other">'+matchArr[7]+'-'+matchArr[8]+'</td>'+
			  			'<td class="doc_td_other">'+europeSpan+'</td>'+'<td class="doc_td_other">'+asisSpan+'</td>'+
			  		'</tr>';
		 }catch(b){
			 
		 }
 
	 } 
	 return html;
}
