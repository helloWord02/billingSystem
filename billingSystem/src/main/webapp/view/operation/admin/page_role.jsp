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
<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="<%=basePath%>static/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath%>static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<%=basePath%>static/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

   <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
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
		.as{
			background-color: rgba(179, 227, 255, 0.5);
			
		}

    </style>

</head>
<body>
    <div class="divall">
        <div class = "div_header">
            <h1>角色管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">


                <!-- 表格  -->
                <div class="dataTable_wrapper">

                    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">

                        <div class="row" style="height: 225px">
                            <div class="col-sm-12">
                                <table class="table  table-bordered  dataTable no-footer" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info">

                                <thead>
                                    <tr role="row">
                                        <th style="width: 50%;">角色名称</th>
                                        <th style="width: 50%;">角色类型</th>
                                    </thead>
                                    <tbody id="tbody">
                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">数据假造中》》》</td>
                                        <td>数据假造中》》》</td>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <!--翻页按钮-->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button  " aria-controls="dataTables-example" tabindex="0" id="f1"><a>首页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="1" id="f2"><a>上一页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="2" id="f3"><a>下一页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="3" id="f4"><a>尾页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="4" id="f5"><a >跳转</a></li>
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
                        <div style="text-align: left" >
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px" id="add">增加角色</button>
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px" id="del">删除角色</button>
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px" id="upd">修改信息</button>
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px" id="get">角色信息</button>
							<input type="hidden" id="hid" value="0">
                        </div>

                    </div>

                </div>
                <!-- 表格 -->

            </div>

        </div>

    </div>
<script>
    var maxpage=0;
    function test(page,rows){
		$.ajax({
			type:"POST",
			url:"role/main",
			data:{page:page,rows:rows},
			async:true,
			success:function(data){
				var mes=data.datas;
				var s="";
				for (var i = 0; i < mes.length; i++) {
					
					s+="<tr index='"+mes[i].id+"' class='gradeA odd' role='row'><td class='sorting_1'>"+mes[i].roleName+"</td><td>"+format(mes[i].type)+"</td>";
					
				}
				for (var i = 0; i <5- mes.length; i++) {
					
					s+="<tr class='gradeA odd' role='row'><td class='sorting_1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td>";
					
				}
				$("#span1").html(data.page+"/"+data.totalPage);
				$("#tbody").html(s);
				maxpage=data.totalPage;
				var otable=document.getElementById("tbody");
	        	var otrr=otable.getElementsByTagName("tr");
				setclick(otrr,mes.length);
				
			}
		});
	}
	test(1,5);
	
	var page=1;
	var pagesize=5;
	$("#f1").click(function(){
		page=1;
		test(1,pagesize);	
	});
	$("#f2").click(function(){
		if(page>1){
    		page--;
    		test(page,pagesize);	
		}
	});
	$("#f3").click(function(){
		
		if(page<maxpage){
    		page++;
    		test(page,pagesize);	
    	}
		
	});
	$("#f4").click(function(){
		page=maxpage
		test(maxpage,pagesize);	
	});
	$("#f5").click(function(){
			var inp=$("#page").val();
		
		if(inp<=maxpage&&inp>0&&inp!=null&&inp!=""){
    		page=inp;
    		test(inp,pagesize);
		}else{
			alert("没有这一页");
		}
		
		
	});
	function setclick(otrr,num){
		for(var i=0;i<num;i++){
			
		otrr[i].onclick=function(){
			
			$("#hid").val(this.getAttribute("index"));
			
			for(var j=0;j<otrr.length;j++){
				otrr[j].className="";
			}
			this.className="as";
			
			
		}
	
	}
	}
	$("#add").click(function(){
		window.location.href="view/operation/admin/page_role_add.jsp";
	});
	$("#del").click(function(){
		if($("#hid").val()=="0"){
			alert("请先选择一行数据！");
		}else{
			var id=$("#hid").val();
			console.info(id);
			$.ajax({
				type:"POST",
				url:"role/delete",
				data:{id:id},
				async:true,
				success:function(mesg){
					if(mesg=="0"){
						alert("删除成功!");
						window.location.reload(true);
					}else{
						alert("网络异常，请稍后重试!");
						window.location.reload(true);
					}
					
				}
				
			});
		}
		
	});
	$("#upd").click(function(){
		if($("#hid").val()=="0"){
			alert("请先选择一行数据！");
		}else{
			window.location.href="role/upd?id="+$("#hid").val();	
		}
		
	});
	$("#get").click(function(){
		if($("#hid").val()=="0"){
			alert("请先选择一行数据！");
		}else{
			window.location.href="role/checkinfo?id="+$("#hid").val();
		}
		
	});
	
	function format (s){
		if(s=="2"){
			return "普通管理员";
		}else if(s=="3"){
			return "普通用户";
		}
		
		
		
	}
    </script>
</body>
</html>