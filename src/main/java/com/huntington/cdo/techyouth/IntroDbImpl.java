package com.huntington.cdo.techyouth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IntroDbImpl implements IntroDb
{
	private Connection conn;
	private static final String CREATE_TABLE_SQL="CREATE TABLE Customers ("
                    + "UID INT NOT NULL,"
                    + "LASTNAME VARCHAR(45) NOT NULL,"
					+ "FIRSTNAME VARCHAR(30) NOT NULL,"
                    + "EMAIL VARCHAR(45) NOT NULL,"
                    + "PRIMARY KEY (UID))";
					
	public IntroDbImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	@Override
	public void listAllCustomers()
	{
		try
		{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(CREATE_TABLE_SQL);
			stmt.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Bob', 'simpson@gmail.com')");
			stmt.executeUpdate("INSERT INTO Customers " + "VALUES (1002, 'Jones', 'Janet', 'jj@gmail.com')");
			stmt.executeUpdate("INSERT INTO Customers " + "VALUES (1003, 'Richardson', 'Ronald', 'r2@gmail.com')");
            ResultSet rs =  stmt.executeQuery("select * from Customers");
             
            // Loop through the data and print all artist names
            while(rs.next()) 
			{
                //System.out.println("Customer Name: " + rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME"));
				System.out.println("Customer Name: " + rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME"));
				Customer cust = new Customer();
				//cust.setLastName(rs.getString("LASTNAME"));
            }
             
            // Clean up
            rs.close();
            stmt.close();			
		}
		catch (SQLException sqlex)
		{
			sqlex.printStackTrace();
		}
		
	}
	
	@Override
	public Customer getCustomer(int id)
	{
		Customer cust = new Customer();
		
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from Customers where uid = " + id);
			if (!rs.next())
			{
				return null;
			}
			
			cust.setUid(rs.getInt("uid"));
			cust.setFirstname(rs.getString("firstname"));
			cust.setLastname(rs.getString("lastname"));
			cust.setEmail(rs.getString("email"));
		}
		catch (SQLException sqlex)
		{
			sqlex.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println("Got customer <" + cust + ">");
		return cust;
	}
	
}
