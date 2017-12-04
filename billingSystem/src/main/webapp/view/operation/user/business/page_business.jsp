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

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

<title>业务账号管理</title>

<!-- Bootstrap Core CSS -->
    <link href="static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="static/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="static/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>

   
   <style>

        body{
            /*iframe宽我设置为1000，网页body的宽度也应该设置为1000*/
            width: 1100px;
        }

        .div_header{
            width: 1100px;
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
        
        .as {
		background-color: skyblue;
		}


    </style>
</head>
<body>
 <div class="divall">
        <div class = "div_header">
            <h1>业务账号管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  >
                    <span>账务账号：</span>
                    <input id="businessAccount" style="width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="账务账号" name="year" type="text" >
                    <span>业务账号：</span>
                    <input id="billAccount"  style=" width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="业务账号" name="month" type="text" >
                    <button id="sel" type="button" class="btn btn-info">查询</button>
                </div>
                <!-- 查询  -->


                <!-- 表格  -->
                <div class="dataTable_wrapper">

                    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">

                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-bordered  dataTable no-footer"
									id="dataTables-example" role="grid"
									aria-describedby="dataTables-example_info">
                                <thead>
                                    <tr role="row">
                                        <th style="width: 10%;">账务账号</th>
                                        <th style="width: 10%;">密码</th>
                                        <th style="width: 20%;">业务账户</th>
                                        <th style="width: 20%;">实验室IP</th>
                                        <th style="width: 20%;">资费名称</th>
                                    </thead>
                                  	<tbody id="data">

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

                <!-- 增删改查 -->
                <div style="text-align: left" >
                    <button type="button" id="add" class="btn btn-info" style="width: 100px;height: 40px" >增加</button>
                    <button type="button" id="del" class="btn btn-info" style="width: 100px;height: 40px">删除</button>
                    <button type="button" id="find" class="btn btn-info" style="width: 100px;height: 40px">查询详情</button>
                    <button type="button" id="upd" class="btn btn-info" style="width: 100px;height: 40px">修改</button>

                </div>
                <!-- 增删改查 -->

            </div>

        </div>

    </div>
	<script>
	
	
	$("#sel").click(function() {
		alert("跳转")
		cutpage(firstPage);
		nowpage = 1;
	})


	function cutpage(p){
		
		var json={
				page:p,
				businessAccount:$("#businessAccount").val(),
				billAccount:$("#billAccount").val()
		}
		
		
		$.ajax({
			type:"POST",
			 url:"business/buspage",
			 data: json,
			 success: function(msg){
			   		alert( JSON.stringify(msg)); 
			     lastPage=msg.totalPage;
		 	var str="";
			for(var i=1;i<=msg.datas.length;i++){
				var obj=msg.datas[i-1]   
				
				str+="<tr onclick='cke($(this))'><td hidden>"+ obj.id +" </td><td>"
		    	
				+obj.account.billAccount+"</td>"+
				"<td>"+obj. password+"</td>"+
				"<td>"+obj.businessAccount+"</td>"+
		    	"<td>"+obj. ip+"</td>"+
		    	"<td>"+obj.postage.postageName+"</td></tr>"
	
			  }
			  $("#data").html(str);
			  $("#span1").html(nowpage+"/"+lastPage);
			    
			 }
		});	
	
}
	
	
	var nowID
	function cke(ck) {
		nowID = ck.children().first().html();
		ck.addClass("as").siblings().removeClass("as");
		

	}
	
	$("#find").click(function(){
		   if(nowID != null){
			   window.open("business/findInfo?nowId=" + nowID, "_self")
			   
		   }
		   else {
			   alert("请选择一行，才能操作")
		}
	
	});
	
	
	$("#del").click(function(){
		   if(nowID != null){
			   window.open("business/delt?nowId=" + nowID, "_self")
			   
		   }
		   else {
			   alert("选择要慎重")
		}
		  
});
	
	$("#upd").click(function(){
		   if(nowID != null){
			   window.open("business/updatefind?nowId=" + nowID, "_self")
			   
		   }
		   else {
			   alert("请选择一行，才能操作")
		}
		  
});
	
	
	
	

    $("#add").on("click",function(){
        window.open("view/operation/postage/page_postage_add.jsp ","_self")
    });
   
   


</script>

<script src="static/js/my.js" type="text/javascript"></script>

</body>
</html>