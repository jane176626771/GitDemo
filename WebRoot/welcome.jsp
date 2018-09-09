<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date date = new Date();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String time = df.format(date);
%>
<!doctype html>
<html>
<head>
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/nav.js"></script>

<script type="text/javascript">
function menu(location,str){
	$("#location").text(location);
	window.location.href = '<%=path%>/'+str;
}
</script>
</head>

<body>
<div id="wrap">
	<div id="top">
    <p class="title">哈尔滨学院毕业生信息管理系统</p>
    </div>
	<div id="content">
    	<div id="content_left">
        	<div id="content_left_top">
            	<p><span><s:property value="#session.username"/>&nbsp;</span>您好</p>
            	<p style="color:#cccccc">欢迎登陆！！</p>    
            </div> 
        	<div id="daohang">
            	<ul class="tabs">
                <li class="tabl2"><a href="#"><img src="images/ui_22.jpg">信息管理</a>
                   <ul class="nav2">
                   <li><a href="javascript:menu('信息浏览','StudentInfoAction!list')">信息浏览</a></li>
                   <li><a href="javascript:menu('信息录入','StudentInfoAction!preAddStu')">信息录入</a></li>
                   </ul>
                </li>
                <li class="tabl3"><a href="#"><img src="images/ui_28.jpg">查询管理</a>
                    <ul class="nav3">
                    <li><a href="javascript:menu('信息查找','QueryAction!preQuery')">信息查找</a></li>
                    </ul>
                </li>
                <li class="tabl4"><a href="#"><img src="images/ui_19.jpg">统计管理</a>
                <ul class="nav4">
                      <li><a href="javascript:menu('学校就业率','StateAction!preSchool')">学校就业率</a></li>
                      <li><a href="javascript:menu('就业地点','StateAction!preCity')">就业地点</a></li>
                      <li><a href="javascript:menu('专业就业率','StateAction!preMajor')">专业就业率</a></li>
                      <li><a href="javascript:menu('院系就业率','StateAction!preYx')">院系就业率</a></li>
                      </ul>
                </li>
                <li><a href="#"><img src="images/UI_03.png">用户管理</a>
               <ul class="nva5">
                <li><a href="javascript:menu('用户浏览','UserAction!list')">用户浏览</a></li>
               	<li><a href="javascript:menu('增加用户','UserAction!preAddUser')">增加用户</a></li>
               </ul>
               </li>
                <li><a href="#"><img src="images/ui_33.jpg">退出系统</a></li>
                </ul>
            </div>
        </div>
    	<div id="content_right">
        	<div id="content_right_top">
            <img src="images/uii_03.jpg">
            <p class="fl">您当前的位置：<span id="location">首页</span></p>
            <p class="fr" style="margin-right:30px;"><%=time %></p>
        	</div>
        
        </div>
    </div>
    <div id="foot"></div>

</div>


</body>
</html>
