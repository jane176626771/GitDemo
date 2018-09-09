package com.studentmanage.action;

import java.util.List;

import com.studentmanage.bean.UserInfo;
import com.studentmanage.dao.UserDao;


public class UserAction {
	private int id;
	private String flag;
	private List<UserInfo> userList;
	UserDao userDao = new UserDao();
	private UserInfo user;
	private String msg;
	//进入列表页面
	public String list(){
		userList = userDao.queryAll();
		return "list";
	}
	
	//进入增加页面
	public String preAddUser(){
		setFlag("add");
		return "success";
	}
	//点击增加按钮
	public String add(){
		boolean result = userDao.addUser(user);
		if(result){
		   setMsg("a1");
		}else{
		   setMsg("a0");
		}
		return list();
	}
	//进入修改用户页面
	public String preUpdate(){
	  user = userDao.queryById(id);
	  setId(id);
	  setFlag("update");
	  return "preUpdate";
	}
	 public String update(){
		UserInfo userTemp = new UserInfo();
		userTemp.setId(id);
		userTemp.setUsername(user.getUsername());
		userTemp.setPassword(user.getPassword());
		userTemp.setUsertype(user.getUsertype());
		boolean result = userDao.updateUser(userTemp);
		if(result){
		   setMsg("u1");
		}else{
		   setMsg("u0");
		}
		return list();
	}
	 public String delete(){
		  boolean result = userDao.deleteUser(id);
		  if(result){
		   setMsg("d1");
		  }else{
		   setMsg("d0");
		  }
		  return list();
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}


	public List<UserInfo> getUserList() {
		return userList;
	}


	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
