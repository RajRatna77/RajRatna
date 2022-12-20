package com.Practice;

import org.testng.annotations.Test;

public class InvocationCount 
{

	@Test(priority=1)
	public void loginpage()
	{
		System.out.println("loginpage Method");
		
	}
	
	@Test(priority=3)
	public void homepage()
	{
		System.out.println("mnp Method");
		
	}
	@Test(priority=0)
	public void signpage()
	{
		System.out.println("ghi Method");
		
	}
	@Test(priority=-2,invocationCount=3)
	public void forgotpassword()
	{
		System.out.println("xyz Method");
		
	}
	@Test(priority=4)
	public void data()
	{
		System.out.println("pqr Method");
		
	}
}
