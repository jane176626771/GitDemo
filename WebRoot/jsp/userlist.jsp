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
   			if(msg=="d1"){
   				alert("删除成功");
   			}
    	}
    }
	function del() {
		if (confirm("确定要删除吗？")) {
			return true;
		} else {
			return false;
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
	            <p class="fl">您当前的位置：<span id="location">用户管理>>用户浏览</span></p>
	            <p class="fr" style="margin-right:30px;"><%=time %></p>
	        	</div>
	        </div>
	        <div class="main">
				<table class="ctable" border="2" bordercolor="#CCECFF" cellpadding="0" cellspacing="0" style="word-break:break-all;">
					<tr class="ctr">
						<td style="width:500px;">用户名</td>
						<td style="width:400px;">身份</td>
						<td style="width:200px;">操作</td>
					</tr>
					<s:iterator value="userList">
						<tr class="ctr2">
							<td><s:property value="username" /></td>
							<td>
								<s:if test="usertype==0">
									管理员
								</s:if>
								<s:elseif test="usertype==1">
									辅导员
								</s:elseif>
								<s:elseif test="usertype==2">
									就业办
								</s:elseif>
								<s:elseif test="usertype==3">
									学生
								</s:elseif>
							</td>
							<td><s:form action="UserAction" style="display:inline;">
									<s:hidden name="id" value="%{id}" />
									<s:submit value="修改" method="preUpdate" />
								</s:form> <s:form action="UserAction" style="display:inline;">
									<s:hidden name="id" value="%{id}" />
									<s:submit value="删除" method="delete" onclick="return del();" />
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
