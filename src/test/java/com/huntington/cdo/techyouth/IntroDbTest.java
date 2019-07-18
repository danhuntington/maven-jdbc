package com.huntington.cdo.techyouth;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

import java.sql.Connection;
import java.sql.DriverManager;

public class IntroDbTest 
{
	private IntroDb app;
	private Connection conn = null;
	
	@Before
	public void initialize()
	{
		try
		{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:introdb", "SA", "");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		app = new IntroDbImpl(conn);
	}
	
	@Test
	public void test() throws Exception 
	{
		app.listAllCustomers();
	}
}
