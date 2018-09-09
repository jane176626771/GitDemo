<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String msg = (String)request.getAttribute("msg");
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<script type="text/javascript">
    	window.onload=function(){
    		var msg = ${msg};
    		if(msg=="1"){
    			alert("用户名或密码错误");
    		}
    	};
</script>
</head>
<style type="text/css">
body{ background:url(images/login1_01.jpg)}
#user{ margin-top:300px; margin-left:600px;}
</style>
<body>
<div id="login">
	<div id="user">
	<s:form action="login">
		<div>
			选择用户：
			<s:radio list="#{'0':'管理员','1':'辅导员','2':'就业办','3':'学生' }" name="usertype" value="0"></s:radio>
			<%-- <select name="请选择用户" style="width:150px;">
			<option value="3">学生登录</option>
			<option value="1">辅导员登录</option>
			<option value="0">管理员登录</option>
			<option value="2">就业办登录</option>
			</select> --%>
		</div>
		<div>用&nbsp;户&nbsp;名：<s:textfield name="username" style="width:200px;"/></div>
		<div>密&nbsp;&nbsp;&nbsp;&nbsp;码：<s:password name="password" style="width:200px;"/></div>
		<div><s:submit value="提交" method="login"/><s:reset value="重置"></s:reset></div>
	</s:form>
	</div>

</div>


</body>
</html>
