<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
<title>账务账号管理</title>

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
            <h1>账务账号管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  style="text-align:center;">
                    <h3>修改新账务账号</h3><br><br>
                </div>
                <!-- 查询  -->

                 <div  >

                    <form style="text-align: center" action="account/update" method="post" onsubmit="return notnull()"/>
                    	
                       <table style="margin-left:  200px">
                       
                            <tr>
                                <td>
                                	 <input type="hidden" name="id" value=${Accountfind.id }>
                                    <span>姓&nbsp&nbsp 名&nbsp&nbsp&nbsp ：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="姓名" name="realName" disabled="" type="text" 
                                 value="${Accountfind.realName}"  ><br><br>
                                </td>
                                <td>
                                    <span  >性&nbsp&nbsp 别&nbsp&nbsp&nbsp ：</span>
                                    
                                    <c:if test="${Accountfind.gender==0}">
                                     <input type="radio" disabled=""   name="gender"  checked="checked"  />女&nbsp;&nbsp;&nbsp;&nbsp;
                                     <input style="margin-left: 20px;" type="radio"  disabled="" name="gender"   />男 <br><br>
                                    </c:if>
                                    <c:if test="${Accountfind.gender==1}">
                                   <input  style="margin-left: 20px;" type="radio" checked="checked" disabled="" name="gender"   />男 &nbsp;&nbsp;&nbsp;&nbsp;
									<input   type="radio" disabled=""   name="gender"   />女<br><br>
									</c:if>
                                </td> 
                           </tr>
                            <tr>
                                <td>
                                    <span>账务账号 ：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" name="billAccount" placeholder="账务账号" name="basicTime" disabled="" type="text" value="${Accountfind.billAccount}"  ><br><br>
                                </td>
                                <td>
                                    <span style="margin-left: 120px">密&nbsp&nbsp 码&nbsp&nbsp&nbsp ：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="密码" name="password" disabled="" type="text" value="${Accountfind.password}"  ><br><br>

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>身份证&nbsp&nbsp&nbsp：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="身份证" name="idCard" disabled="" type="text" value="${Accountfind.idCard}"><br><br>

                                </td>
                                <td>
                                    <span style="margin-left: 120px">联系电话：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="联系电话" name="phoneNumber" type="text" value="${Accountfind.phoneNumber}"  ><br><br>

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>邮&nbsp&nbsp 编 &nbsp&nbsp&nbsp：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="邮编" name="cord" type="text" value="${Accountfind.cord}" ><br><br>

                                </td>
                                <td>
                                    <span style="margin-left: 120px">通讯地址 ：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="通讯地址" name="address" type="text" value="${Accountfind.address}"  ><br><br>

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>QQ信息&nbsp&nbsp ：</span>
                                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="QQ信息" name="qq" type="text" value="${Accountfind.qq}" ><br><br>

								</td>
								<td>
                                    <span  style="margin-left: 30px">状&nbsp&nbsp态&nbsp&nbsp&nbsp：</span> 
									  <select   name="state" id="select_k1"  style="margin-left: 20px;width: 100px;height: 30px; border: 1px rgba(100, 99, 70, 0.5) solid  ">
										<c:if test="${Accountfind.state==0}">
										<option value=0 selected="selected">开通</option>
										<option value=1>关闭</option>
										</c:if>
										<c:if test="${Accountfind.state==1}">
										<option value=1 selected="selected">关闭</option>
										<option value=0>开通</option>
										</c:if>
                            </td>
                            </tr>
						
                        </table>
                         
						
			
                        <button id="upd" style="width: 100px;height: 40px" type="submit" class="btn btn-info">更改</button>
                        <button id="cancel" style="width: 100px;height: 40px;margin-left: 80px" type="button" class="btn btn-info">取消</button>


					
                  	

                 </div>
            </div>
			 </form>
        </div>

    </div>
    
	    <script>
	    
	    $("#cancel").on("click",function(){
            window.open("view/operation/user/account/page_account_number.jsp","_self")
        });
	  
		
	
    </script>
	
</body>
</html>