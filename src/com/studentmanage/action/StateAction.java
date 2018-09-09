package com.studentmanage.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.ActionSupport;
import com.studentmanage.bean.StudentInfo;
import com.studentmanage.dao.StudentInfoDao;

public class StateAction extends ActionSupport{
	private JFreeChart chart;
	private StudentInfo stu;
	private List<StudentInfo> resultList; 
	private int stateresult;
	private int total;
	StudentInfoDao stuDao = new StudentInfoDao();
	//学校就业率
	public String preSchool(){
		return "preSchool";
	}
	public String stateschool(){
		List<Integer> list = stuDao.state(stu,"1");
		stateresult = list.get(0);
		total = list.get(1);
		
		/*DefaultPieDataset  dcd = new DefaultPieDataset();
		dcd.setValue("就业人员", stateresult);
		dcd.setValue("学校总人数",total);
		chart = ChartFactory.createPieChart(stu.getBysj()+"年就业率统计",
				dcd,  true, false, false) ;
		OutputStream os = null;
		try {
			os = new FileOutputStream("company.jpeg");
			ChartUtilities.writeChartAsJPEG(os, 1.0f, chart, 400, 300, null);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};*/
		
		
		return "preSchool";
	}
	//就业地点
	public String preCity(){
		resultList = stuDao.queryByCondi(stu);
		return "preCity";
	}
	//专业就业率
	public String preMajor(){
		resultList = stuDao.queryByCondi(stu);
		return "preMajor";
	}
	//院系就业率
	public String preYx(){
		resultList = stuDao.queryByCondi(stu);
		return "preYx";
	}
	
	public StudentInfo getStu() {
		return stu;
	}
	public void setStu(StudentInfo stu) {
		this.stu = stu;
	}
	public List<StudentInfo> getResultList() {
		return resultList;
	}
	public void setResultList(List<StudentInfo> resultList) {
		this.resultList = resultList;
	}
	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	public int getStateresult() {
		return stateresult;
	}
	public void setStateresult(int stateresult) {
		this.stateresult = stateresult;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
