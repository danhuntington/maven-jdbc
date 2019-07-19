package com.huntington.cdo.techyouth;

public class Customer
{
	private int uid;
	private String lastname;
	private String firstname;
	private String email;
	
	public Customer()
	{
		
	}
	
	public Customer(int uid, String lastname, String firstname, String email)
	{
		super();
		this.uid = uid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}

	public int getUid()
	{
		return uid;
	}

	public void setUid(int uid)
	{
		this.uid = uid;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "Customer [uid=" + uid + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", email=" + email + "]";
	}
	
}
