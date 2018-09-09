package com.studentmanage.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.studentmanage.bean.UserInfo;
import com.studentmanage.dao.UserDao;
import com.studentmanage.util.Constant;

public class LoginAction {
	private String username;
	private String password;
	private String usertype;
	private String msg;
	public String login(){
	    UserDao userDao = new UserDao();
	    UserInfo  u = new UserInfo();
	    u.setUsername(username);
	    u.setPassword(password);
	    u.setUsertype(usertype);
	    int idflag = userDao.userExists(u);
	  
	    if(idflag>0){
		    Map session = ActionContext.getContext().getSession();
		    session.put(Constant.USERNAME, username);
		    session.put(Constant.USERTYPE, usertype);
		    return "success";
	    }else{
	    	setMsg("1");
	    	return "fail";
	    }
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
