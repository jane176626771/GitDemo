<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date date = new Date();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String time = df.format(date);
String msg = (String) request.getAttribute("msg");
%>
<!doctype html>
<html>
<head>
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link href="css/news.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/nav.js"></script>
<style type="text/css">  
   .nobr br{display: none}  
</style>  
<script type="text/javascript">
function menu(location,str){
	$("#location").text(location);
	window.location.href = '<%=path%>/'+str;
}
function queryInfo(){
	document.getElementById("add_form").action="QueryAction!queryInfo";
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
	            <p class="fl">您当前的位置：<span id="location">查询管理>>信息查找</span></p>
	            <p class="fr" style="margin-right:30px;"><%=time %></p>
	        	</div>
	        </div>
	        <div class="main">
	        	
	        	<table style="margin:0px auto;width: 1024px;">
	        	<s:form id="add_form" name="add_form" action="QueryAction" method="post" theme="simple">
	        		<tr>
	     				<td class="addtd" >学号:</td>
	     				<td class="addtdinput">
	     				<s:textfield id="xuehao" name="stu.xuehao" style="width:300px;" /></td>
	     				<td class="addtd" >毕业时间:</td>
	     				<td class="addtdinput"><s:textfield id="bysj" name="stu.bysj" style="width:300px;" /></td>
	     				</tr>
	     			<tr>
	     				<td class="addtd" >生源地:</td>
	     				<td class="addtdinput"><s:textfield id="syd" name="stu.syd" style="width:300px;" /></td>
	     				<td class="addtd" >就业地:</td>
	     				<td class="addtdinput"><s:textfield id="jyd" name="stu.jyd" style="width:300px;" /></td>
	     			
	     			<tr>
	     				<td class="addtd" >院系(专业):</td>
	     				<td class="addtdinput" colspan="2"><div class="nobr"> <s:doubleselect  
				            id="yx"  
				            name="stu.yx"   
				            list="list"  
				            doubleId="zy"  
				            doubleName="stu.zy"   
				            doubleList="map.get(top)" 
				            theme="simple" 
				        /> </div></td>
	     				<td ><input type="button" value="查询" onclick="queryInfo();" /></td>
	     			</tr>
	     			</s:form>
	        	</table>
	        	
				<table class="ctable" border="2" bordercolor="#CCECFF" cellpadding="0" cellspacing="0" style="word-break:break-all;">
					<tr class="ctr">
						<td style="width:15%">学号</td>
						<td style="width:10%">姓名</td>
						<td style="width:5%">性别</td>
						<td style="width:20%">院系</td>
						<td style="width:20%">专业</td>
						<td style="width:10%">就业地</td>
						<td style="width:10%">生源地</td>
						<td style="width:10%">毕业时间</td>
					</tr>
					<s:iterator value="resultList">
						<tr class="ctr2">
							<td><s:property value="xuehao" /></td>
							<td><s:property value="xm" /></td>
							<td><s:property value="xb" /></td>
							<td><s:property value="yx" /></td>
							<td><s:property value="zy" /></td>
							<td><s:property value="jyd" /></td>
							<td><s:property value="syd" /></td>
							<td><s:property value="bysj" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
			</div>
    	</div>
	    <div id="foot">
	    </div>
</body>
</html>
