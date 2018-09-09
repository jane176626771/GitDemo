package com.studentmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.studentmanage.bean.StudentInfo;
import com.studentmanage.dao.StudentInfoDao;

public class QueryAction {
	private StudentInfo stu;
	private List<StudentInfo> resultList;
	private List<String> list;  
    private Map map;
	StudentInfoDao stuDao = new StudentInfoDao();
	public String preQuery(){
		doubleSelect();
		return "prequery";
	}
	public String queryInfo(){
		doubleSelect();
		resultList = stuDao.queryByCondi(stu);
		return "prequery";
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
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
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
}
