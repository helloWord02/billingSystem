<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<title>添加资费</title>

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
				<div style="text-align: center;">
					<h3>添加新资费</h3>
					<br>
					<br>
				</div>
				<!-- 查询  -->

				<div>
					<form style="text-align: center" action="postage/add"
						method="post" onsubmit="return notnull()">
						 <span>资费名称：</span>
						<input
							style="margin-left: 20px; width: 200px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid;"
							placeholder="资费名称" name="postageName" type="text"><br>
						<br> <span style="margin-left: -100px">资费类型：</span> <select
							name="type" id="select_k1"
							style="margin-left: 20px; width: 100px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid">

							<option value=1 selected="selected">计时</option>
							<option value=2>套餐</option>
							<option value=3>包月</option>
						</select><br> <br id="location">
						<div id="timelongDIV">
							<span>基本时长：</span> <input
								style="margin-left: 20px; width: 200px; height: 30px;  border:  1px rgba(105, 99, 70, 0.5) solid"
								placeholder="基本时长" name="baisetime" type="text" value="-1">
							<br>
							<br>
						</div>
						<div id="unitPayDIV">
							<span>单位费用：</span> <input
								style="margin-left: 20px; width: 200px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
								placeholder="单位费用" name="unitcost" type="text" value="-1">
							<br>
							<br>
						</div>
						<div id="payDIV">
							<span>基本费用：</span> <input
								style="margin-left: 20px; width: 200px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
								placeholder="基本费用" name="baisecost" type="text" value="-1">
							<br>
							<br>
						</div>

						<span>资费说明：</span> <input
							style="margin-left: 20px; width: 200px; height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid"
							placeholder="资费说明" name="costexplain" type="text"><br>
						<br>
						<button style="width: 100px; height: 40px" type="submit"
							class="btn btn-info">确定</button>
						<button id="cancel"
							style="width: 100px; height: 40px; margin-left: 80px"
							type="button" class="btn btn-info">取消</button>
					</form>

				</div>
			</div>

		</div>

	</div>
	<script>
	$(function(){
		showDiv();
	})
	
	/* 表单验证 不为空*/
	function notnull(){
		var flag=true
		$("input").each(function(){
			if($(this).val()==''){
				/* alert($(this).val()) */
				$(this).css("border-color", "red");
				flag=false
			}else{
				$(this).css("border-color", "gray");
				}
		})
		return flag
	}

	
	$("#select_k1").change(
			function(){
				showDiv()	
			})
	function showDiv(){
		if($("#select_k1").val()==1){
			$("#timelongDIV").hide();
			$("#payDIV").hide();
			$("#unitPayDIV").show();
		}
		if($("#select_k1").val()==2){
			$("#timelongDIV").show();
			$("#payDIV").show();
			$("#unitPayDIV").hide();
		}
		if($("#select_k1").val()==3){
			$("#timelongDIV").hide();
			$("#payDIV").show();
			$("#unitPayDIV").hide();
		}
	}
		$("#cancel").on("click", function() {
			window.open("view/operation/postage/page_postage.jsp", "_self")
		});
	</script>

</body>
</html>