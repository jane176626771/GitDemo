package com.studentmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.studentmanage.bean.StudentInfo;
import com.studentmanage.dao.StudentInfoDao;

public class StudentInfoAction {
	List<StudentInfo> studentList;
	StudentInfoDao stuDao = new StudentInfoDao();
	private int id;
	private String flag;
	private String msg; 
	private StudentInfo stu;
	
	
	private List<String> list;  
    private Map map; 
	//进入列表页面
	public String list(){
		studentList = stuDao.queryAll();
		return "list";
	}
	//进入增加页面
	public String preAddStu(){
		setFlag("add");
		doubleSelect();
		return "preadd";
	}
	
	//点击增加按钮
	public String add(){
		boolean result = stuDao.addStudent(stu);
		if(result){
		   setMsg("a1");
		}else{
		   setMsg("a0");
		}
		return list();
	}
	//进入修改用户页面
	public String preUpdate(){
	  stu = stuDao.queryById(id);
	  setId(id);
	  setFlag("update");
	  doubleSelect();
	  return "preUpdate";
	}
	 public String update(){
		StudentInfo stuTemp = new StudentInfo();
		stuTemp.setId(id);
		stuTemp.setXuehao(stu.getXuehao());
		stuTemp.setBj(stu.getBj());
		stuTemp.setBjmc(stu.getBjmc());
		stuTemp.setBjzw(stu.getBjzw());
		stuTemp.setBysj(stu.getBysj());
		stuTemp.setBzr(stu.getBzr());
		stuTemp.setBzrlxdh(stu.getBzrlxdh());
		stuTemp.setDzyx(stu.getDzyx());
		stuTemp.setIdcard(stu.getIdcard());
		stuTemp.setJyd(stu.getJyd());
		stuTemp.setLxdh(stu.getLxdh());
		stuTemp.setMz(stu.getMz());
		stuTemp.setSfjy(stu.getSfjy());
		stuTemp.setSfsf(stu.getSfsf());
		stuTemp.setSr(stu.getSr());
		stuTemp.setSyd(stu.getSyd());
		stuTemp.setXb(stu.getXb());
		stuTemp.setXm(stu.getXm());
		stuTemp.setXshzw(stu.getXshzw());
		stuTemp.setXz(stu.getXz());
		stuTemp.setYx(stu.getYx());
		stuTemp.setZy(stu.getZy());
		stuTemp.setZzmm(stu.getZzmm());
		boolean result = stuDao.updateStudent(stuTemp);
		if(result){
		   setMsg("u1");
		}else{
		   setMsg("u0");
		}
		return list();
	}
	 private void doubleSelect(){
			list = new ArrayList<String>();  
			list.add("软件学院");  
			list.add("工学院");  
			list.add("理学院"); 
			list.add("经济管理学院");  
			list.add("人文学院");  
			list.add("政法学院"); 
			list.add("外语学院");  
			list.add("教育科学学院");  
			list.add("艺术与设计学院");
			list.add("体育学院");
	        List<String> list1 = new ArrayList<String>();  
	        list1.add("软件工程");  
	        List<String> list2 = new ArrayList<String>();  
	        list2.add("土木工程");  
	        list2.add("电子信息工程");  
	        list2.add("食品科学与工程");  
	        list2.add("计算机科学与技术");  
	        List<String> list3 = new ArrayList<String>();  
	        list3.add("数学与应用数学");  
	        list3.add("物理学"); 
	        list3.add("化学");  
	        list3.add("地理科学");  
	        list3.add("生物科学"); 
	        List<String> list4 = new ArrayList<String>();  
	        list4.add("财务管理");  
	        list4.add("会计学");  
	        list4.add("旅游管理");  
	        list4.add("金融学");
	        List<String> list5 = new ArrayList<String>();  
	        list5.add("汉语言文学");  
	        list5.add("历史学");  
	        list5.add("文秘教育");  
	        list5.add("对外汉语");
	        List<String> list6 = new ArrayList<String>();  
	        list6.add("思想政治教育");  
	        list6.add("法学");  
	        list6.add("社会工作");
	        List<String> list7 = new ArrayList<String>();  
	        list7.add("英语");  
	        list7.add("俄语"); 
	        List<String> list8 = new ArrayList<String>();  
	        list8.add("小学教育");  
	        list8.add("心理学");
	        List<String> list9 = new ArrayList<String>();  
	        list9.add("艺术设计");  
	        list9.add("动画");
	        list9.add("摄影");  
	        list9.add("音乐学");
	        list9.add("美术学");  
	        list9.add("音乐表演");
	        List<String> list10 = new ArrayList<String>();  
	        list10.add("体育教");  
	        list10.add("社会体育");
	        map = new HashMap();  
	        map.put("软件学院", list1);  
	        map.put("工学院", list2);  
	        map.put("理学院", list3); 
	        map.put("经济管理学院", list4);  
			map.put("人文学院", list5);  
			map.put("政法学院", list6); 
			map.put("外语学院", list7);  
			map.put("教育科学学院", list8);  
			map.put("艺术与设计学院", list9);
			map.put("体育学院", list10);
		}
	public List<StudentInfo> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<StudentInfo> studentList) {
		this.studentList = studentList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public StudentInfo getStu() {
		return stu;
	}
	public void setStu(StudentInfo stu) {
		this.stu = stu;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Map getMap() {
		return map;
	}
}
