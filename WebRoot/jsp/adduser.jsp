<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date date = new Date();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String time = df.format(date);
String flag = (String) request.getAttribute("flag");
%>
<!doctype html>
<html>
<head>
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link href="css/news.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/nav.js"></script>

<script type="text/javascript">
function menu(location,str){
	$("#location").text(location);
	window.location.href = '<%=path%>/'+str;
}
function doAdd(){
		
			if(document.getElementById("username").value==""){
				alert("用户名不能为空，请输入。");
			}else if(document.getElementById("password").value==""){
				alert("密码不能为空，请输入。");
			}else{
				var flag = "<%=flag%>";
				if(flag=="add"){
					document.getElementById("add_form").action="UserAction!add";
		    		document.getElementById("add_form").submit();
				}
				if(flag=="update"){
					document.getElementById("add_form").action="UserAction!update";
	    			document.getElementById("add_form").submit();
				}
			}
    	}
    	function back(){
    		document.getElementById("add_form").action="UserAction!list";
    		document.getElementById("add_form").submit();
    	}
</script>
</head>
<body>
	<div id="wrap">
		<div id="top">
	    <p class="title">哈尔滨学院毕业生信息管理系统</p>
	    </div>
	    <div id="content">
	    	<%@ include file="menu.jsp" %>
	    	<div id="content_right">
	        	<div id="content_right_top">
	            <img src="images/uii_03.jpg">
	            <p class="fl">您当前的位置：
	            	<span id="location">用户管理>>
	            		<s:if test="flag=='add'">增加用户</s:if>
	            		<s:else>修改用户</s:else>
	            	</span>
	            </p>
	            <p class="fr" style="margin-right:30px;"><%=time %></p>
	        	</div>
	        </div>
	        <div class="main">
				<s:form id="add_form" action="UserAction" method="post" >
				<table class="ctable" border="1" bordercolor="#84A6D3"  cellpadding="6" cellspacing="0">
	     			<tr>
	     				<td class="addtd" >用户名:</td>
	     				<td class="addtdinput"><s:textfield id="username" name="user.username" style="width:360px;" /><font style="color: red;">*</font></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >密码:</td>
	     				<td class="addtdinput"><s:textfield id="password" name="user.password" style="width:360px;" /><font style="color: red;">*</font></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >身份:</td>
	     				<td class="addtdinput">
	     					<s:if test="flag=='update'" >
	     						<s:radio id="usertype" list="#{'0':'管理员','1':'辅导员','2':'就业办','3':'学生' }" name="user.usertype" value="#{user.usertype}"></s:radio>
	     					</s:if>
	     					<s:elseif test="flag=='add'">
	     						<s:radio id="usertype" list="#{'0':'管理员','1':'辅导员','2':'就业办','3':'学生' }" name="user.usertype" value="1"></s:radio>
	     					</s:elseif>
	     				<font style="color: red;">*</font></td>
	     				
	     			</tr>
	     			<tr>
						<td class="addtdinput" colspan="2">
							<input type="hidden" name="id" value="${id}" />
							<input type="button" value="提交" onclick="doAdd();" />
							<input type="button" value="返回" onclick="back();"/>				
						</td>
					</tr>
     			</table>
     			</s:form>
			</div>
    	</div>
	    <div id="foot">
	    </div>
	</div>
</body>
</html>
