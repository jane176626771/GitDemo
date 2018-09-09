package com.studentmanage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class BaseDao {

	public Connection getConnection(){
		String url = "jdbc:mysql://localhost/manage";
		String user = "root";
		String password = "tiger";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败！");
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");
		}
		return conn;
	}
}
