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
			System.out.println("��������ʧ�ܣ�");
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
		}
		return conn;
	}
}
