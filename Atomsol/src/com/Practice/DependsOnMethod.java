package com.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod 
{

	@Test(dependsOnMethods= {"data"})
	public void loginpage()
	{
		System.out.println("Abc Method");
	
		
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
	@Test(priority=-2)
	public void forgotpassword()
	{
		System.out.println("xyz Method");
		
	}
	@Test
	public void data()
	{
		System.out.println("pqr Method");
		Assert.fail();
		
	}
}
