<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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


    </style>

</head>
<body>
    <div class="divall">
        <div class = "div_header">
            <h1>角色管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  style="text-align:center;">
                    <h3>修改角色</h3><br><br>
                </div>
                <!-- 查询  -->

                 <div  >

                    <form role="form" style="text-align: center">

                        <span>角色名称：</span>
                        <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="角色名称"  type="text" id="name"><br><br>
                       <span>角色类型：</span>
                       <select name="roles" id="type"  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid">
                             <option value="2">普通管理员</option>
                             <option value="3">普通用户</option>     
                        </select>
                        <br><br>
                       <span id="pcheckbox">
                       
                       </span>

                        <button style="width: 100px;height: 40px" type="button" class="btn btn-info" id="add">修改</button>
                        <button style="width: 100px;height: 40px;margin-left: 80px" type="button" class="btn btn-info" id="cancel">取消</button>
						<input type="hidden" id="hid" value="${id }">
                    </form>

                 </div>
            </div>

        </div>

    </div>
<script >
function test(){
	$.ajax({
		type:"POST",
		url:"permission/permissions",
		async:true,
		success:function(data){
			
			var s="";
			for (var i = 0; i < data.length; i++) {
				s+="<input type='checkbox' name='pers[]' value='"+data[i].id+"'/> "+data[i].permissionName+"<br>"
			}
			$("#pcheckbox").html(s); 
		}
	});
}
test();
	$("#add").click(function(){
		
		var obox=document.getElementById("pcheckbox");
    	var oinp=obox.getElementsByTagName("input");
    	var pers = [];
		
    	for (var i = 0; i < oinp.length; i++) {
    		if(oinp[i].checked==true){
    			pers.push(oinp[i].value);
    			
    		}
    		
		}

		$.ajax({
			type:"post",
			url:"role/update",
			data: {id:$("#hid").val()+"",rolename:$("#name").val()+"",type:$("#type").val()+"","pers[]": pers},
			async:true,
			success:function(data){
				if(data=="0"){
					alert("修改成功！");
					window.location.href="view/operation/admin/page_role.jsp";
				}else{
					alert("网络异常！");
					window.location.reload(true);
				}
			}
		});
	
	});
	$("#cancel").click(function(){
		window.history.back(-1);	
	});


</script>
</body>
</html>