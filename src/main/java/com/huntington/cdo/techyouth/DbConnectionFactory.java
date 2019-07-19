package com.huntington.cdo.techyouth;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionFactory
{
	private static DbConnectionFactory instance = null;
	private Connection conn = null;
	
	private DbConnectionFactory()
	{
		
	}
	
	public static DbConnectionFactory getInstance()
	{
		if (null == instance)
		{
			instance = new DbConnectionFactory();
		}
		
		return instance;
	}
	
	public Connection getConnection()
	{
		if (null == conn)
		{
			try
			{
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
				conn = DriverManager.getConnection("jdbc:hsqldb:mem:introdb", "SA", "");
			}
			catch (Exception ex)
			{
				conn = null;
			}
		}
		
		return conn;
	}
	
}
