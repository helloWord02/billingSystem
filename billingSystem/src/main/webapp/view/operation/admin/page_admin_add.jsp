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
        td{
            align:left;
            height: 50px;
        }


    </style>

</head>
<body>
    <div class="divall">
        <div class = "div_header">
            <h1>管理员管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  style="text-align:center;">
                    <h3>添加管理员</h3><br><br>
                </div>
                <!-- 查询  -->

                <div  >

                    <form id="formtest" style="text-align: center">
                        <table style="margin-left:  200px">
                            <tr>
                                <td>
                                    <span>管理员名称:</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="名称" name="realName" type="text" >
                                </td>
                                <td>
                                    <span  >性&nbsp&nbsp 别&nbsp&nbsp&nbsp:</span>
                                    <input style="margin-left: 20px;" type="radio" checked="checked" name="gender" value="1"/>男 &nbsp;&nbsp;&nbsp;&nbsp;<input  type="radio"   name="gender" value="0"/>女

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>&nbsp;&nbsp;&nbsp;管理账号:</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="账号" name="billAccount" type="text" >
                                </td>
                                <td>
                                    <span style="margin-left: 120px">密&nbsp&nbsp 码&nbsp&nbsp&nbsp :</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="密码" name="password" type="text" >

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>&nbsp;&nbsp;身份证&nbsp&nbsp&nbsp:</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="身份证" name="idCard" type="text" >

                                </td>
                                <td>
                                    <span style="margin-left: 120px">联系电话:</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="联系电话" name="phoneNumber" type="text" >

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>邮&nbsp&nbsp 编 &nbsp&nbsp&nbsp:</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="邮编" name="cord" type="text" >

                                </td>
                                <td>
                                    <span style="margin-left: 120px">通讯地址:</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="通讯地址" name="address" type="text" ><br><br>

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span style="margin-left: 30px">QQ :</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="QQ号码" name="qq" type="text" ><br><br>

                                </td>
                                <td>
                                    <span style="margin-left:  120px">角色:</span>
                                    <select name="roles" id="roleoption"  style="margin-left: 50px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid">
                                        <option value="1">数据假造中~~</option>     
                                    </select><br><br>
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <span style="margin-left: 20px">邮箱 :</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="邮箱信息" name="mail" type="text" ><br><br>

                                </td>


                            </tr>

                        </table>

                        <button id="add" style="width: 100px;height: 40px;margin-left: 50px" type="button" class="btn btn-info">添加</button>
                        <button id="cancel" style="width: 100px;height: 40px;margin-left: 80px" type="button" class="btn btn-info">取消</button>
						
                    </form>
					
                </div>
                 </div>
            </div>

        </div>
<script >
function test(){
	$.ajax({
		type:"POST",
		url:"role/roles",
		async:true,
		success:function(data){
			console.info(data);
			
			var s="";
			for (var i = 0; i < data.length; i++) {
				s+="<option value='"+data[i].id+"'>"+data[i].roleName+"</option>";
			}
			$("#roleoption").html(s); 
		}
	});
}
test();
	function notnull(){
		var flag=true
		$("input").each(function(){
			if($(this).val()==''){
				/* alert($(this).val()) */
				$(this).css("border-color", "red");
				console.info("no");
				flag=false
			}else{
				$(this).css("border-color", "gray");
				console.info("ok");
				}
		})
		return flag
	}
	
	$("#add").click(function(){
		var boo=notnull();
		
		if(boo==true){
			console.info("okajax");
			var fields = $("#formtest").serializeArray();
			$.ajax({
				type:"post",
				url:"admin/add",
				data: {realName:fields[0].value,gender:fields[1].value,billAccount:fields[2].value,password:fields[3].value,idCard:fields[4].value,phoneNumber:fields[5].value,cord:fields[6].value,address:fields[7].value,qq:fields[8].value,roles:fields[9].value,mail:fields[10].value},
				async:true,
				success:function(data){
					if(data=="0"){
						alert("添加成功！");
						window.location.href="view/operation/admin/page_admin.jsp";
					}else{
						alert("网络异常！");
						window.location.reload(true);
					}
				}
			});
			
			
		}
		
	
	});
	$("#cancel").click(function(){
		window.location.href="view/operation/admin/page_admin.jsp";	
	});


</script>
</body>
</html>