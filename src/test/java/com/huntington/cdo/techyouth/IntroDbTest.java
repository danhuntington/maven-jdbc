package com.huntington.cdo.techyouth;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@RunWith(MockitoJUnitRunner.class)
public class IntroDbTest 
{
	@InjectMocks
	private IntroDbImpl app;
	
	@Mock
    private Connection conn;
	
    @Mock
    private Statement stmt;
    
    @Captor
    ArgumentCaptor<String> argCaptor;

    @Mock
    private ResultSet rs;

	@Before
	public void initialize()
	{
		MockitoAnnotations.initMocks(this);
		
		app = new IntroDbImpl(conn);
	}
	
	@Test
	public void test() throws Exception 
	{
		Mockito.when(conn.createStatement()).thenReturn(stmt);
		Mockito.when(stmt.executeUpdate(argCaptor.capture())).thenReturn(1);
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.when(rs.getString(Mockito.anyString())).thenReturn("name");
		Mockito.when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
		
		app.listAllCustomers();

		Mockito.verify(conn, Mockito.times(1)).createStatement();
		Mockito.verify(stmt, Mockito.times(4)).executeUpdate(Mockito.anyString());
		
		for (String argval : argCaptor.getAllValues())
		{
			System.out.println(argval);
		}
		
	}
	
	@Test
	public void testGetCustomer() throws Exception
	{
		Mockito.when(conn.createStatement()).thenReturn(stmt);
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(rs.getInt(Mockito.anyString())).thenReturn(1001);
		Mockito.when(rs.getString("firstname")).thenReturn("Bob");
		Mockito.when(rs.getString("lastname")).thenReturn("Simpson");
		Mockito.when(rs.getString("email")).thenReturn("simpson@gmail.com");
		
		app.getCustomer(1001);
	}

	@Test
	public void testGetCustomerNotFound() throws Exception
	{
		Mockito.when(conn.createStatement()).thenReturn(stmt);
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(false);
		
		Customer cust = app.getCustomer(999);
		assertNull("Customer should be null when not found", cust);
	}
	
}
