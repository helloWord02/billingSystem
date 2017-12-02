<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作日志</title>

  <meta charset="UTF-8">
    <title>操作日志</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>professor-1</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="<%=basePath%>static/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath%>static/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<%=basePath%>static/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="<%=basePath%>static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
        <h1>操作日志</h1>
    </div>

    <div class="div_content">

        <div class="panel-body">

		 <!-- 查询 -->
                <div  >
                    <span>管理员：</span>
                    <input  style="width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="用户名" id="magName" type="text" >
                    <span>开始时间：</span>
                    <input  style=" width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="操作时间" id="beginTime" type="text" >
                     <span>结束时间：</span>
                    <input  style=" width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="结束时间" id="endTime" type="text" >
                 <button type="button" class="btn btn-info" id="find">查询</button>
                </div>
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
                                    <th style="width: 10%;">管理员名称</th>
                                    <th style="width: 10%;">操作时间</th>
                                    <th style="width: 15%;">操作方法</th>
                                    <th style="width: 15%;">操作参数</th>

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
                  
                </div>

            </div>
          

        </div>

    </div>

</div>

<script src="static/js/my.js" type="text/javascript"></script>

<script>
 
function cutpage(p){
	var json={
			pageNum:p,
			magName:$("#magName").val(),
			endTime:$("#beginTime").val(),  			 
			beginTime:$("#endTime").val()
			
	}
	
	$.ajax({
		   type: "POST",
		   url: "log2/handLog",
		   data: json,
		   success: function(msg){
		   
			  alert( JSON.stringify(msg));
		     lastPage=msg.totalPage;
		    
		     var str="";
		     for(var i=1;i<=msg.datas.length;i++){
		    	 var obj=msg.datas[i-1]
					 str+=" <tr  onclick='cke($(this)>"+	             
		             "<td>"+obj.magName+"</td>"+
		             "<td>"+obj.handTime+"</td>"+
		             "<td>"+obj.handMethod+"</td>"+
		             "<td>"+obj.handArgs+"</td>"+
		             "</tr>"					     
				}					
		     $("#data").html(str);
		     $("#span1").html(nowpage+"/"+lastPage);
			}
		});
	}
	$("#find").on("click",function(){
		 
		cutpage(1);
		 nowpage = 1;
	   });
</script>


</body>
</html>