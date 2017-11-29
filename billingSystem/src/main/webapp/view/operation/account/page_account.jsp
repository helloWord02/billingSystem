<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();//获取项目名称
	String basePath = request.getScheme() +"://" + request.getServerName() + ":" + 
	request.getServerPort() + path + "/";
%>  

<head>
	<base href="<%=basePath%>">
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> 账务账号管理</title>
 
    <link href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/dist/css/timeline.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/dist/css/sb-admin-2.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/bower_components/morrisjs/morris.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="<%=basePath%>static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>
     
    <style>

        body{
            /*iframe宽我设置为1000，网页body的宽度也应该设置为1000*/
            width: 1000px;
        }

        .div_header{
            width: 1000px;
            height: 100px;
            background-color: rgba(179, 227, 255, 0.5);
        }

        .div_content{

            width: 100%;
            height: 480px;

        }

        h1{
            width: 100%;
            line-height: 100px;
            text-align: center;
        }
        td
        {
            text-align:center;
        }
        th{
            text-align:center;
        }


    </style>

</head>
<body>
    <div class="divall">
        <div class = "div_header">
            <h1>账务查询系统</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  >
                    <span>年：</span>
                    <input  style="width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="年" name="year" type="text" >
                    <span>月：</span>
                    <input  style=" width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="月" name="month" type="text" >
                    <button type="button" class="btn btn-info">查询</button>
                </div>
                <!-- 查询  -->

                <!-- 表格  -->
                <div class="dataTable_wrapper">

                    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">

                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-striped table-bordered table-hover dataTable no-footer" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info">

                                <thead>
                                    <tr role="row">
                                        <th style="width: 10%;">编号</th>
                                        <th style="width: 20%;">业务名称</th>
                                        <th style="width: 20%;">实验室IP</th>
                                        <th style="width: 20%;">总时长</th>
                                    </thead>
                                    <tbody>
                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">1</td>
                                        <td>服务器1租赁</td>
                                        <td>221.237.44.152</td>
                                        <td>111</td>

                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">2</td>
                                        <td>服务器2租赁</td>
                                        <td>221.237.44.152</td>
                                        <td>122</td>


                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">3</td>
                                        <td>服务器3租赁</td>
                                        <td>221.237.44.152</td>
                                        <td>1515</td>

                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">4</td>
                                        <td>服务器4租用</td>
                                        <td>221.237.44.152</td>
                                        <td>1515</td>


                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">5</td>
                                        <td>服务器5租用</td>
                                        <td>221.237.44.152</td>
                                        <td>111</td>

                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <!--翻页按钮-->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button  " aria-controls="dataTables-example" tabindex="0" id="a1"><a>首页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="1" id="a2"><a>上一页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="2" id="a3"><a>下一页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="3" id="a4"><a>尾页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="4" id="a5"><a >跳转</a></li>
                                        <li aria-controls="dataTables-example" tabindex="4">
                                            <div class="form-group input-group">
	                                                <span class="input-group-addon" id="span1">
	                                                </span>
                                                <input style="width: 70px" type="text" class="form-control" placeholder="跳转页" id="page">
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- /翻页按钮-->
                    </div>

                </div>
                <!-- 表格 -->

            </div>

        </div>

    </div>
<script >

	var nowpage=1;
	var firstPage=1;
	var lastPage=0;
	var year="";
	var reg = new RegExp("^[0-9]*$");
	$(function(){
		cutpage(firstPage);
		
	})
	
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
					cutpage(lastPage);
					nowpage=$("#page").val(); 
				}
				else{
					alert("请输入正确的页码");
				}
				 	 
			 }
	
	)
		
	function cutpage(p){
		$.ajax({
			   type: "POST",
			   url: "postage/cutpage",
			   data: "pageNum="+p,
			   success: function(msg){
			     alert( JSON.stringify(msg));
			     lastPage=msg.totalPage;
			    
			     var str="";
			     for(var i=1;i<=msg.datas.length;i++){
			    	 var obj=msg.datas[i-1]
			      str+=" <tr class='gradeA odd' role='row'>"+
	             "<td class='sorting_1'>"+i+"</td>"
	             if(obj.type=='1'){
	            	 str+= "<td>计时</td>"
	             }
			    	 if(obj.type=='0'){
		            	 str+= "<td>包月</td>"
		             }
			    	 if(obj.type=='2'){
		            	 str+= "<td>套餐</td>"
		             }
			    	 
			    	 /* 基本时长 1分钟  100分钟  一个月 */
				    	 if(obj.baisetime==0){
			            	 str+= "<td>一个月</td>"
			             }else{
			            	 str+= "<td>"+obj.baisetime+"</td>"
			             }
				    
			str+="<td>"+obj.baisecost+"</td>"+
	             "<td>"+obj.unitcost+"</td>"+
	             "<td>"+obj.costexplain+"</td></tr>"
			     }
			     $("#data").html(str);
			     $("#span1").html(nowpage+"/"+lastPage);
			    
			     
			   }
			});
		
	}



</script>

</body>
</html>