package com.studentmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.studentmanage.bean.UserInfo;



public class UserDao extends BaseDao {
	Connection conn = null;
	 public UserDao(){
	  conn = getConnection(); 
	 }
	 public int userExists(UserInfo u){
		  int result = 0;
		  if(conn!=null){
		   try {
		    PreparedStatement pstm = conn.prepareStatement("select * from userinfo where username=? and password=? and usertype=?");
		    pstm.setString(1, u.getUsername());
		    pstm.setString(2, u.getPassword());
		    pstm.setString(3, u.getUsertype());
		    ResultSet rs = pstm.executeQuery();
		    while(rs.next()){
		      result = 1;
		      break;
		     }
		   } catch (SQLException e) {
		    e.printStackTrace();
		   }
		  }
		  return result;
		 }
	 public boolean addUser(UserInfo u){
			int result = 0;
			if(conn!=null){
				try {
					PreparedStatement pstm = conn.prepareStatement("insert into userinfo("
							+ "username,password,usertype)"
							+ " values(?,?,?)");
					pstm.setString(1, u.getUsername());
					pstm.setString(2, u.getPassword());
					pstm.setString(3, u.getUsertype());
					result = pstm.executeUpdate();
				} catch (SQLException e) {
					System.out.print("数据异常!");
				}
			}
			if(result>0){
				return true;
			}else{
				System.out.println("添加数据失败！");
				return false;
			}
		}
	 public UserInfo queryById(int id){
		UserInfo user = null;
		if(conn!=null){
			try {
				PreparedStatement pstm = conn.prepareStatement("select * from userinfo where id=?");
				pstm.setInt(1, id);
				ResultSet rs = pstm.executeQuery();
				if(rs!=null){
					while(rs.next()){
						user = new UserInfo();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setUsertype(rs.getString("usertype"));
					}
				}
			} catch (SQLException e) {
				System.out.print("判断记录是否存在失败!");
			}
		}
		return user;
	}
	 public boolean updateUser(UserInfo user){
			int result = 0;
			if(conn!=null){
				try {
					PreparedStatement pstm = conn.prepareStatement("update userinfo set username=?"
							+ ",password=?,usertype=? where id=?");
					pstm.setString(1, user.getUsername());
					pstm.setString(2, user.getPassword());
					pstm.setString(3, user.getUsertype());
					pstm.setInt(4, user.getId());
					result = pstm.executeUpdate();
				} catch (SQLException e) {
					System.out.print("数据异常!");
				}
			}
			if(result>0){
				return true;
			}else{
				System.out.println("修改数据失败！");
				return false;
			}
		}
		public boolean deleteUser(int id){
			int result = 0;
			if(conn!=null){
				try {
					PreparedStatement pstm = conn.prepareStatement("delete from userinfo where id=?");
					pstm.setInt(1, id);
					result = pstm.executeUpdate();
				} catch (SQLException e) {
					System.out.print("数据异常!");
				}
			}
			if(result>0){
				return true;
			}else{
				System.out.println("删除数据失败！");
				return false;
			}
		}
	 public List<UserInfo> queryAll(){
		 List<UserInfo> resultList = new ArrayList<UserInfo>();
		 if(conn!=null){
			   try {
			    PreparedStatement pstm = conn.prepareStatement("select * from userinfo ");
			    ResultSet rs = pstm.executeQuery();
			    while(rs.next()){
			    	UserInfo u = new UserInfo();
			    	u.setId(rs.getInt("id"));
			    	u.setUsername(rs.getString("username"));
			    	u.setPassword(rs.getString("password"));
			    	u.setUsertype(rs.getString("usertype"));
			    	resultList.add(u);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		 }
		 return resultList;
	 }
	/*
	  
	  public User queryByName(String name){
		User user = null;
		if(conn!=null){
			Statement stm;
			try {
				stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select * from user where identity='1' and username='"+name+"'");
				while(rs.next()){
					user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setIdentity("1");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}*/
}
