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
			conn = DbConnectionFactory.getInstance().getConnection();
				
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
		app.getCustomer(1001);
		
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
