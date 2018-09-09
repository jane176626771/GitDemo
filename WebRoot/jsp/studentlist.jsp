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

<script type="text/javascript">
function menu(location,str){
	$("#location").text(location);
	window.location.href = '<%=path%>/'+str;
}
window.onload=function(){
    	var msg = "<%=msg%>";
    	if(msg!=null){
   			if(msg=="a1"){
   				alert("添加成功");
   			}
   			if(msg=="a0"){
   				alert("添加失败");
   			}
   			if(msg=="u1"){
   				alert("修改成功");
   			}
   			if(msg=="u0"){
   				alert("修改失败");
   			}
    	}
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
	            <p class="fl">您当前的位置：<span id="location">信息管理>>信息浏览</span></p>
	            <p class="fr" style="margin-right:30px;"><%=time %></p>
	        	</div>
	        </div>
	        <div class="main">
				<table class="ctable" border="2" bordercolor="#CCECFF" cellpadding="0" cellspacing="0" style="word-break:break-all;">
					<tr class="ctr">
						<td style="width:15%">学号</td>
						<td style="width:15%">姓名</td>
						<td style="width:20%">院系</td>
						<td style="width:25%">专业</td>
						<td style="width:10%">就业地</td>
						<td style="width:10%">毕业时间</td>
						<td style="width:5%">操作</td>
					</tr>
					<s:iterator value="studentList">
						<tr class="ctr2">
							<td><s:property value="xuehao" /></td>
							<td><s:property value="xm" /></td>
							<td><s:property value="yx" /></td>
							<td><s:property value="zy" /></td>
							<td><s:property value="jyd" /></td>
							<td><s:property value="bysj" /></td>
							<td><s:form action="StudentInfoAction" style="display:inline;">
									<s:hidden name="id" value="%{id}" />
									<s:submit value="修改" method="preUpdate" />
								</s:form> 
							</td>
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
