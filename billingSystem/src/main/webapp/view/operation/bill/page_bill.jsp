<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();//获取项目名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<base href="<%=basePath%>">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>账单查询</title>

<!-- Bootstrap Core CSS -->
<link
	href="static/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="static/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="static/dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="static/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="static/bower_components/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="static/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script src="static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>

<style>
body {
	/*iframe宽我设置为1000，网页body的宽度也应该设置为1000*/
	width: 1000px;
}

.div_header {
	width: 1000px;
	height: 100px;
	background-color: rgba(179, 227, 255, 0.5);
}

.div_content {
	width: 100%;
	height: 480px;
}

h1 {
	width: 100%;
	line-height: 100px;
	text-align: center;
}

td {
	text-align: center;
}

th {
	text-align: center;
}
.as {
	background-color: skyblue;
}
</style>

</head>
<body>
	<div class="divall">
		<div class="div_header">
			<h1>账单查询系统</h1>
		</div>

		<div class="div_content">

			<div class="panel-body">
				<!-- 查询 -->
				<div>
					<span>身份证：</span> <input
						style="width: 150px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
						placeholder="身份证" id="idcard" type="text"> <span>账务账号：</span>
					<input
						style="width: 110px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
						placeholder="账务账号" id="billAccount" type="text"> <span>用户名：</span>
					<input
						style="width: 110px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
						placeholder="用户名" id="userName" type="text"> <span>年：</span>
					<input
						style="width: 110px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
						placeholder="年份" id="year" type="text"><span>月：</span>
					<input
						style="width: 110px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
						placeholder="月份" id="month" type="text">
					<button type="button" class="btn btn-info" id = "sel">查询</button>
				</div>
				<!-- 查询  -->

				<!-- 表格  -->
				<div class="dataTable_wrapper">

					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">

						<div class="row">
							<div class="col-sm-12">
								<table
									class="table table-bordered dataTable no-footer"
									id="dataTables-example" role="grid"
									aria-describedby="dataTables-example_info">

									<thead>
										<tr role="row">
											<th style="width: 20%;">身份证</th>
											<th style="width: 20%;">账务账号</th>
											<th style="width: 10%;">用户名</th>
											<th style="width: 20%;">时间</th>
											<th style="width: 10%;">总费用</th>
											<th style="width: 10%;">支付方式</th>
											<th style="width: 10%;">支付状态</th>
									</thead>
									<tbody id="data">
										
									</tbody>
								</table>
							</div>
						</div>

						<!--翻页按钮-->
						<div class="row">
							<div class="col-sm-12">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTables-example_paginate">
									<ul class="pagination">
										<li class="paginate_button  "
											aria-controls="dataTables-example" tabindex="0" id="a1"><a>首页</a></li>
										<li class="paginate_button "
											aria-controls="dataTables-example" tabindex="1" id="a2"><a>上一页</a></li>
										<li class="paginate_button "
											aria-controls="dataTables-example" tabindex="2" id="a3"><a>下一页</a></li>
										<li class="paginate_button "
											aria-controls="dataTables-example" tabindex="3" id="a4"><a>尾页</a></li>
										<li class="paginate_button "
											aria-controls="dataTables-example" tabindex="4" id="a5"><a>跳转</a></li>
										<li aria-controls="dataTables-example" tabindex="4">
											<div class="form-group input-group">
												<span class="input-group-addon" id="span1"> </span> <input
													style="width: 70px" type="text" class="form-control"
													placeholder="跳转页" id="page">
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
		<script src="static/js/my.js" type="text/javascript"></script>
	<script>
	function dateFormat(time){
		var date = new Date(time);
		return date.toLocaleString();
	}
	function cutpage(p){
		var json = {
				page : p,
				idcard : $("#idcard").val(),
				billAccount : $("#billAccount").val(),
				userName : $("#userName").val(),
				year : $("#year").val(),
				month : $("#month").val(),
				
			}
		$.ajax({
			   type: "POST",
			   url: "bill/cutpage",
			   data: json,
			   success: function(msg){
			     alert( JSON.stringify(msg));
			     lastPage=msg.totalPage;
			    
			     var str="";
			     for(var i=1;i<=msg.datas.length;i++){
			    	 var obj=msg.datas[i-1]
						 str+=" <tr onclick='cke($(this))' ondblclick = 'dbck($(this))'>"+
			             "<td class='sorting_1'>"+obj.idcard+"</td>"+			             
			             "<td>"+obj.billAccount+"</td>"+
			             "<td>"+obj.userName+"</td>"+
			             "<td>"+dateFormat(obj.date)+"</td>"+
			             "<td>"+obj.allCost+"</td>"+
			             "<td>"+obj.payType+"</td>"+
			             "<td>"+obj.payState+"</td>"+
			             "</tr>"					     
					}					
			     $("#data").html(str);
			     $("#span1").html(nowpage+"/"+lastPage);
				}
			});
		}
	

	/*查询按钮绑定事件*/
		$("#sel").click(function() {
			alert("ddd")
			cutpage(firstPage);
			nowpage = 1;
		})
	
	/* 点击变色及获取当前行iD 注意table样式 */
		
		function cke(ck) {			
			ck.addClass("as").siblings().removeClass("as");
		}
		
	/* 给每行绑定双击跳转事件 */
		var billAccount
		function dbck(bill) {
		var billaccount = $(bill).children().eq(1).html();	
		alert(billaccount)
		var yearOfMonth = $(bill).children().eq(3).html();
		alert(yearOfMonth)
		alert(typeof(yearOfMonth))
		
		window.open("bill/showBillBusinessPage?billAccount=" + billaccount+"&yearOfMonth="+ yearOfMonth, "_self")
		
		}

	</script>
	

	
</body>
</html>