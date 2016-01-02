package com.jdhg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MysqlHelper {
	java.sql.Connection conn =null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	//增删改查
	//1增删改: 获取数据库的连接,然后执行sql语句,关闭数据库.
	//2查:获取数据库的连接,获取加油管,然后执行sql语句,关闭加油管,关闭数据库.
	
	private Connection getConnection(){
		// TODO Auto-generated method stub
		String driver="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/studentmanager?useUnicode=true&characterEncoding=UTF-8";
		String user="root";
		String password="";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//1增删改
	public int excute(String sql)
	{
		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeAll();
		return 1;
	}

	//2查
	public ResultSet query(String sql)
	{
		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void closeAll()
	{
		try
		{
			rs.close();
			rs=null;
		}
		catch(Exception e){
			rs=null;
		}
		try
		{
			stmt.close();
			stmt=null;
		}
		catch(Exception e){
			stmt=null;
		}
		try
		{
			conn.close();
			conn=null;
		}
		catch(Exception e){
			conn=null;
		}
	}
}
