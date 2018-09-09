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
	//�����б�ҳ��
	public String list(){
		studentList = stuDao.queryAll();
		return "list";
	}
	//��������ҳ��
	public String preAddStu(){
		setFlag("add");
		doubleSelect();
		return "preadd";
	}
	
	//������Ӱ�ť
	public String add(){
		boolean result = stuDao.addStudent(stu);
		if(result){
		   setMsg("a1");
		}else{
		   setMsg("a0");
		}
		return list();
	}
	//�����޸��û�ҳ��
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
			list.add("���ѧԺ");  
			list.add("��ѧԺ");  
			list.add("��ѧԺ"); 
			list.add("���ù���ѧԺ");  
			list.add("����ѧԺ");  
			list.add("����ѧԺ"); 
			list.add("����ѧԺ");  
			list.add("������ѧѧԺ");  
			list.add("���������ѧԺ");
			list.add("����ѧԺ");
	        List<String> list1 = new ArrayList<String>();  
	        list1.add("�������");  
	        List<String> list2 = new ArrayList<String>();  
	        list2.add("��ľ����");  
	        list2.add("������Ϣ����");  
	        list2.add("ʳƷ��ѧ�빤��");  
	        list2.add("�������ѧ�뼼��");  
	        List<String> list3 = new ArrayList<String>();  
	        list3.add("��ѧ��Ӧ����ѧ");  
	        list3.add("����ѧ"); 
	        list3.add("��ѧ");  
	        list3.add("�����ѧ");  
	        list3.add("�����ѧ"); 
	        List<String> list4 = new ArrayList<String>();  
	        list4.add("�������");  
	        list4.add("���ѧ");  
	        list4.add("���ι���");  
	        list4.add("����ѧ");
	        List<String> list5 = new ArrayList<String>();  
	        list5.add("��������ѧ");  
	        list5.add("��ʷѧ");  
	        list5.add("���ؽ���");  
	        list5.add("���⺺��");
	        List<String> list6 = new ArrayList<String>();  
	        list6.add("˼�����ν���");  
	        list6.add("��ѧ");  
	        list6.add("��Ṥ��");
	        List<String> list7 = new ArrayList<String>();  
	        list7.add("Ӣ��");  
	        list7.add("����"); 
	        List<String> list8 = new ArrayList<String>();  
	        list8.add("Сѧ����");  
	        list8.add("����ѧ");
	        List<String> list9 = new ArrayList<String>();  
	        list9.add("�������");  
	        list9.add("����");
	        list9.add("��Ӱ");  
	        list9.add("����ѧ");
	        list9.add("����ѧ");  
	        list9.add("���ֱ���");
	        List<String> list10 = new ArrayList<String>();  
	        list10.add("������");  
	        list10.add("�������");
	        map = new HashMap();  
	        map.put("���ѧԺ", list1);  
	        map.put("��ѧԺ", list2);  
	        map.put("��ѧԺ", list3); 
	        map.put("���ù���ѧԺ", list4);  
			map.put("����ѧԺ", list5);  
			map.put("����ѧԺ", list6); 
			map.put("����ѧԺ", list7);  
			map.put("������ѧѧԺ", list8);  
			map.put("���������ѧԺ", list9);
			map.put("����ѧԺ", list10);
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
