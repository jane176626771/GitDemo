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
<style type="text/css">  
   .nobr br{display: none}  
</style>
<script type="text/javascript">
function menu(location,str){
	$("#location").text(location);
	window.location.href = '<%=path%>/'+str;
}
function doAdd(){
		
			if(document.getElementById("xuehao").value==""){
				alert("学号不能为空，请输入。");
			}else if(document.getElementById("xm").value==""){
				alert("姓名不能为空，请输入。");
			}else if(document.getElementById("syd").value==""){
				alert("生源地不能为空，请输入。");
			}else if(document.getElementById("bysj").value==""){
				alert("毕业时间不能为空，请输入。");
			}else if(document.getElementById("zy").value==""){
				alert("专业不能为空，请输入。");
			}else if(document.getElementById("yx").value==""){
				alert("院系不能为空，请输入。");
			}else{
				var flag = "<%=flag%>";
				if(flag=="add"){
					document.getElementById("add_form").action="StudentInfoAction!add";
		    		document.getElementById("add_form").submit();
				}
				if(flag=="update"){
					document.getElementById("add_form").action="StudentInfoAction!update";
	    			document.getElementById("add_form").submit();
				}
			}
    	}
    	function back(){
    		document.getElementById("add_form").action="StudentInfoAction!list";
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
	            	<span id="location">信息管理>>
	            		<s:if test="flag=='add'">信息录入</s:if>
	            		<s:else>信息修改</s:else>
	            	</span>
	            </p>
	            <p class="fr" style="margin-right:30px;"><%=time %></p>
	        	</div>
	        </div>
	        <div class="main">
				<s:form id="add_form" name="add_form" action="StudentInfoAction" method="post" >
				<table class="ctable" border="1" bordercolor="#84A6D3"  cellpadding="6" cellspacing="0">
	     			<tr>
	     				<td class="addtd" >学号:</td>
	     				<td class="addtdinput">
	     				<s:textfield id="xuehao" name="stu.xuehao" style="width:360px;" /><font style="color: red;">*</font></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >姓名:</td>
	     				<td class="addtdinput"><s:textfield id="xm" name="stu.xm" style="width:360px;" /><font style="color: red;">*</font></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >性别:</td>
	     				<td class="addtdinput">
	     					<s:if test="flag=='update'" >
	     						<s:radio id="xb" list="#{'男':'男','女':'女'}" name="stu.xb" value="#{stu.xb}"></s:radio>
	     					</s:if>
	     					<s:elseif test="flag=='add'">
	     						<s:radio id="xb" list="#{'男':'男','女':'女'}" name="stu.xb" value="男"></s:radio>
	     					</s:elseif>
	     				</td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >民族:</td>
	     				<td class="addtdinput"><s:textfield id="mz" name="stu.mz" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >生日:</td>
	     				<td class="addtdinput"><s:textfield id="sr" name="stu.sr" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >政治面貌:</td>
	     				<td class="addtdinput"><s:textfield id="zzmm" name="stu.zzmm" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >身份证号:</td>
	     				<td class="addtdinput"><s:textfield id="idcard" name="stu.idcard" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >联系电话:</td>
	     				<td class="addtdinput"><s:textfield id="lxdh" name="stu.lxdh" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >电子邮箱:</td>
	     				<td class="addtdinput"><s:textfield id="dzyx" name="stu.dzyx" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >生源地:</td>
	     				<td class="addtdinput"><s:textfield id="syd" name="stu.syd" style="width:360px;" /><font style="color: red;">*</font></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >就业地:</td>
	     				<td class="addtdinput"><s:textfield id="jyd" name="stu.jyd" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >是否就业:</td>
	     				<td class="addtdinput">
	     					<s:if test="flag=='update'" >
	     						<s:radio id="sfjy" list="#{'是':'是','否':'否'}" name="stu.sfjy" value="#{stu.sfjy}"></s:radio>
	     					</s:if>
	     					<s:elseif test="flag=='add'">
	     						<s:radio id="sfjy" list="#{'是':'是','否':'否'}" name="stu.sfjy" value="是"></s:radio>
	     					</s:elseif>
	     				<font style="color: red;">*</font></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >院系(专业):</td>
	     				<td class="addtdinput"><div class="nobr"><s:doubleselect  
				            id="yx"  
				            name="stu.yx"   
				            list="list"  
				            doubleId="zy"  
				            doubleName="stu.zy"   
				            doubleList="map.get(top)" 
				            theme="simple" 
				        /> <font style="color: red;">*</font></div></td>
	     			</tr>
	     			
	     			<tr>
	     				<td class="addtd" >班级:</td>
	     				<td class="addtdinput"><s:textfield id="bj" name="stu.bj" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >班级职务:</td>
	     				<td class="addtdinput"><s:textfield id="bjzw" name="stu.bjzw" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >学生会职务:</td>
	     				<td class="addtdinput"><s:textfield id="xshzw" name="stu.xshzw" style="width:360px;" /></td>
	     			</tr>
	     			
	     			<tr>
	     				<td class="addtd" >班级名称:</td>
	     				<td class="addtdinput"><s:textfield id="bjmc" name="stu.bjmc" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >班主任:</td>
	     				<td class="addtdinput"><s:textfield id="bzr" name="stu.bzr" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >班主任联系电话:</td>
	     				<td class="addtdinput"><s:textfield id="bzrlxdh" name="stu.bzrlxdh" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >毕业时间:</td>
	     				<td class="addtdinput"><s:textfield id="bysj" name="stu.bysj" style="width:360px;" /><font style="color: red;">*</font></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >学制:</td>
	     				<td class="addtdinput"><s:textfield id="xz" name="stu.xz" style="width:360px;" /></td>
	     			</tr>
	     			<tr>
	     				<td class="addtd" >是否师范:</td>
	     				<td class="addtdinput">
	     					<s:if test="flag=='update'" >
	     						<s:radio id="sfsf" list="#{'是':'是','否':'否'}" name="stu.sfsf" value="#{stu.sfsf}"></s:radio>
	     					</s:if>
	     					<s:elseif test="flag=='add'">
	     						<s:radio id="sfsf" list="#{'是':'是','否':'否'}" name="stu.sfsf" value="是"></s:radio>
	     					</s:elseif>
	     				</td>
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
