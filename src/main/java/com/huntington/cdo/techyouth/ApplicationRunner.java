package com.huntington.cdo.techyouth;

import java.sql.Connection;
import java.sql.DriverManager;


public class ApplicationRunner
{

	public static void main(String[] args) 
	{
		Connection conn = null;

		try 
		{
			//Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			//Creating the connection with HSQLDB
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:introdb", "SA", "");
			if (conn != null)
			{
				System.out.println("Connection created successfully");

			}
			else
			{
				System.out.println("Problem with creating connection");
			}

		}  
		catch (Exception e) 
		{
			e.printStackTrace(System.out);
		}
		
		IntroDb app = new IntroDbImpl(conn);
		app.listAllCustomers();
		
		try
		{
			conn.close();
		}
		catch (Exception ex)
		{
			// ...
		}
		
	}

}
