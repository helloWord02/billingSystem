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

<title>资费管理</title>

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
</style>

</head>
<body>
	<div class="divall">
		<div class="div_header">
			<h1>资费管理系统</h1>
		</div>

		<div class="div_content">

			<div class="panel-body">
				<!-- 查询 -->
				<div>
					<span>资费名称：</span> <input
						style="width: 140px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
						placeholder="资费名称" id="postageName" type="text">
						 <span>资费类型：</span>
					<select id="potageType" style="width: 100px;height: 30px">
						<option value="0" selected="selected"></option>
						<option value="1">计时</option>
						<option value="3">包月</option>
						<option value="2">套餐</option>
					</select> 

					<button type="button" class="btn btn-info" id="sel">查询</button>
				</div>
				<!-- 查询  -->

				<!-- 表格  -->
				<div class="dataTable_wrapper">

					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">

						<div class="row">
							<div class="col-sm-12">
								<table
									class="table table-striped table-bordered table-hover dataTable no-footer"
									id="dataTables-example" role="grid"
									aria-describedby="dataTables-example_info">

									<thead>
										<tr role="row">
											<th style="width: 10%;">资费名称</th>
											<th style="width: 10%;">资费类型</th>
											<th style="width: 20%;">基本时长(分钟)</th>
											<th style="width: 20%;">基本费用(元)</th>
											<th style="width: 20%;">单位费用(元/分钟)</th>
											<th style="width: 20%;">资费说明</th>
										</tr>
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

				<!-- 增删改查 -->
				<div style="text-align: left">
					<button type="button" id="add" class="btn btn-info"
						style="width: 100px; height: 40px">增加</button>
					<button type="button" id="del" class="btn btn-info"
						style="width: 100px; height: 40px">删除</button>
					<button type="button" id="find" class="btn btn-info"
						style="width: 100px; height: 40px">查询详情</button>
					<button type="button" id="upd" class="btn btn-info"
						style="width: 100px; height: 40px">修改</button>

				</div>
				<!-- 增删改查 -->

			</div>

		</div>

	</div>
	<script src="static/js/my.js" type="text/javascript"></script>
	<script>
	
	$("#sel").click(function () {
		alert("ddd")
		cutpage(firstPage);
		nowpage=1;
	})
	
		function cutpage(p) {
		
		var json={
				page:p,
				potageType:$("#potageType").val(),
				postageName:$("#postageName").val()
				
		}
			$.ajax({
				type : "POST",
				url : "postage/cutpage",
/* 				data : "page="+p+"&params['potageType']="+$("#potageType").val()+"&params['postageName']="+$("#postageName").val(), */

                data:json,
				success : function(msg) {
					alert(JSON.stringify(msg));
					lastPage = msg.totalPage;

					var str = "";
					for (var i = 1; i <= msg.datas.length; i++) {
						var obj = msg.datas[i - 1]
						str += " <tr class='gradeA odd' role='row'>"
								+ "<td class='sorting_1'>" + obj.postageName + "</td>"
						if (obj.type == '1') {
							str += "<td>计时</td>"
						}
						if (obj.type == '3') {
							str += "<td>包月</td>"
						}
						if (obj.type == '2') {
							str += "<td>套餐</td>"
						}

						/* 基本时长 1分钟  100分钟  一个月 */
						if (obj.baisetime == 0) {
							str += "<td>一个月</td>"
						} else {
							str += "<td>" + obj.baisetime + "</td>"
						}

						str += "<td>" + obj.baisecost + "</td>" + "<td>"
								+ obj.unitcost + "</td>" + "<td>"
								+ obj.costexplain + "</td></tr>"
					}
					$("#data").html(str);
					$("#span1").html(nowpage + "/" + lastPage);

				}
			});

		}

		$("#add").on("click", function() {
			window.open("view/operation/postage/page_postage_add.jsp", "_self")
		});
		$("#upd").on("click", function() {
			window.open("view/operation/postage/page_postage_upd.jsp", "_self")
		});
		$("#find").on(
				"click",
				function() {
					window.open("view/operation/postage/page_postage_info.jsp",
							"_self")
				});
	</script>


</body>
</html>