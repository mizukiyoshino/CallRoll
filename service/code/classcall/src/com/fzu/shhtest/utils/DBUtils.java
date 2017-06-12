package com.fzu.shhtest.utils;

import java.sql.*;

public class DBUtils
{
	private static final String CONN_URL = "jdbc:mysql://localhost:3306/studentsitedb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	public static Connection getConn()     
	{  
        Connection conn = null;         
        try         
        {           
        	//修改此处代码  
        	Class.forName("com.mysql.jdbc.Driver");
        	conn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
        } 
		catch (ClassNotFoundException e)         
		{             
			// TODO Auto-generated catch block             
			e.printStackTrace();         
		} 
		catch (SQLException e)         
		{             
			// TODO Auto-generated catch block             
			e.printStackTrace();         
		}  
        return conn;     
    }	
	public static void releaseResource(Connection conn, PreparedStatement pstmt,ResultSet rset)
	{
		try
		{ 
			// 修改此处代码
			if(conn != null)
				conn.close();
			if(pstmt != null)
				pstmt.close();
			if(rset != null)
				rset.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}