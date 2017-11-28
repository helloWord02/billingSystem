var nowpage=1;
var firstPage=1;
var lastPage=0;
var reg = new RegExp("^[0-9]*$");

/* 首页  */

$("#a1").click(
		 function(){
				cutpage(firstPage);
				nowpage=1;  
				
		 }

) 

/* 上一页 */
$("#a2").click(
		 function(){
			 if(nowpage!=1){
					nowpage--;
					cutpage(nowpage)
					} 
		 }
		
		) 
		
		
		/* 下一页 */
$("#a3").click(function(){
	
				if(nowpage!=lastPage){
				nowpage++;
				cutpage(nowpage)
				}
		}
				)
/* 最后一页 */				
$("#a4").click(
		 function(){
				cutpage(lastPage);
				nowpage=lastPage; 
		 }

)
/*  选页  */
$("#a5").click(
		 function(){
			if(reg.test($("#page").val())&&$("#page").val()<=lastPage&&$("#page").val()>0){
				cutpage($("#page").val());
				nowpage=$("#page").val(); 
			}
			else{
				alert("请输入正确的页码");
			}
			 	 
		 }

)

$(function(){
	cutpage(firstPage);
})