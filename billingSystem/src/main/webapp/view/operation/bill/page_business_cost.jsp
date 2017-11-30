<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>业务账号费用明细信息</title>

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
			<h1>业务账号费用明细信息</h1>
		</div>

		<div class="div_content">

			<div class="panel-body">


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
											<th style="width: 20%;">业务账号</th>
											<th style="width: 20%;">IP</th>
											<th style="width: 20%;">时长</th>
											<th style="width: 20%;">业务费用</th>
											<th style="width: 20%;">资费套餐</th>
									</thead>
									<tbody id="data">
		 						<%-- <c:forEach items="${ pager.datas} " var="BillBusinessBean">
											<tr class='gradeA odd' role='row'>
												<td>${BillBusinessBean.billAccount }</td>
												<td>${BillBusinessBean.service }</td>
												<td>${BillBusinessBean.timeLong }</td>
												<td>${BillBusinessBean.cost }</td>
												<td>${BillBusinessBean.postageName }</td>
											</tr> 
										</c:forEach>  --%>
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
	
	
	function cutpage(p){
		/*  alert($("tr").first().chiled().first().html())  */
		
		$.ajax({
			   type: "POST",
			   url: "bill/showBillBusinessData",
			   data: "page="+ p +"&billaccount=${acc}",
			   success: function(msg){
				//   alert(msg);
			     alert( JSON.stringify(msg));
			     lastPage=msg.totalPage;
			    
			     var str="";
			     for(var i=1;i<=msg.datas.length;i++){
			    	 
			    	 var obj=msg.datas[i-1]
			    	 alert("+++++++++++++"+obj)
						 str+=" <tr class='gradeA odd' role='row'>"+
			             "<td>"+obj.businessName+"</td>"+			             
			             "<td>"+obj.service+"</td>"+
			             "<td>"+obj.timeLong+"</td>"+
			             "<td>"+obj.cost+"</td>"+
			             "<td>"+obj.postageName+"</td>"+
			             "</tr>"					     
					}					
			     $("#data").html(str);
			     $("#span1").html(nowpage+"/"+lastPage);
				}
			});
		}
	</script> 

</body>
</html>