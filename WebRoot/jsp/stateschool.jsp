<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page import="org.jfree.data.general.DefaultPieDataset"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%>
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@ page import="java.io.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date date = new Date();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String time = df.format(date);
String msg = (String) request.getAttribute("msg");
int stateresult = (Integer) request.getAttribute("stateresult");
int total = (Integer) request.getAttribute("total");
/* 
	DefaultPieDataset data = new DefaultPieDataset(); 
    //数据初始化
    data.setValue("就业人数",stateresult); 
    data.setValue("学生总数",total);
    PiePlot3D plot = new PiePlot3D(data);//生成一个3D饼图 
    JFreeChart chart = new JFreeChart("",JFreeChart.DEFAULT_TITLE_FONT, plot, true); 
    chart.setBackgroundPaint(java.awt.Color.white);//可选，设置图片背景色 
    chart.setTitle("学生就业人数统计图");//可选，设置图片标题 
    plot.setToolTipGenerator(new StandardPieToolTipGenerator()); 
    StandardEntityCollection sec = new StandardEntityCollection(); 
    ChartRenderingInfo info = new ChartRenderingInfo(sec); 
    PrintWriter w = new PrintWriter(out);//输出MAP信息 
    //500是图片长度，300是图片高度
    //String filename = ServletUtilities.saveChartAsPNG(chart,500,300,info,session); 
    String filename = ServletUtilities.saveChartAsJPEG(chart,500,300,info,session); 
    ChartUtilities.writeImageMap(w,"map0",info,false); 
    String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename; */
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
function state(){
	document.getElementById("add_form").action="StateAction!stateschool";
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
	            <p class="fl">您当前的位置：<span id="location">统计管理>>学校就业率统计</span></p>
	            <p class="fr" style="margin-right:30px;"><%=time %></p>
	        	</div>
	        </div>
	        <div class="main">
	        	
	        	<table style="margin:0px auto;width: 1024px;">
	        	<s:form id="add_form" name="add_form" action="QueryAction" method="post" theme="simple">
	        		<tr>
	     				<td class="addtd" >统计年份:</td>
	     				<td class="addtdinput">
	     					<s:textfield id="bisj" name="stu.bysj" style="width:300px;" /><font style="color: red;">*</font>
	     				</td>
	     				<td >
	     					<input type="button" value="统计" onclick="state();" />
	     				</td>
	     			</tr>
	     			<tr><td></td></tr>
	     			</s:form>
	        	</table>
	        	
	        	 <%

    DefaultPieDataset dpd = new DefaultPieDataset();
    
    dpd.setValue("管理人员", 25);
    dpd.setValue("市场人员", 25);
    dpd.setValue("开发人员", 45);
    dpd.setValue("其他人员", 10);
    
    JFreeChart chart = ChartFactory.createPieChart("某公司组织结构图",dpd, true, false, false);
    
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,null,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String url = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
    //String url = "D:\\Program Files\\Tomcat 6.0\\temp\\jfreechart-5695937056336777536"+ fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致

%> 

	<img src="<%=url%>" width="800" height="600">
				
			</div>
			</div>
    	</div>
	    <div id="foot">
	    </div>
</body>
</html>
