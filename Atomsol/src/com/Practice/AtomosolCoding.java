package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AtomosolCoding 
{

	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		/*
		ChromeDriver driver = new ChromeDriver();  
		DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));      
              
        devTools.send(Network.emulateNetworkConditions(true, 300, 200, 100, java.util.Optional.empty()));
		*/
		String url="https://blazedemo.com/index.php ";
		driver.get(url);
		
		Thread.sleep(3000);
		//Task 1: To Check The Title of the Entered URL:
		System.out.println("The Title of the Home Page is: "+driver.getTitle());
		
		
		//Task 2: to Navigate to located webelement and click
		
		driver.findElement(By.linkText("destination of the week! The Beach!")).click();
		
		Thread.sleep(3000);
		//Task 2: to check whether current url has string 'vacation'
		
		System.out.println("The Current URL is :"+driver.getCurrentUrl());
		
		//To navigate back to the home page
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		//Task 3: To Purchase a ticket
		//Task3(a): 
		
		Thread.sleep(3000);
		Select source =new Select (driver.findElement(By.name("fromPort")));
		Thread.sleep(3000);
		source.selectByVisibleText("Mexico City");
		Thread.sleep(3000);
		Select destination=new Select(driver.findElement(By.name("toPort")));
		//Thread.sleep(3000);
		Thread.sleep(3000);
		destination.selectByVisibleText("London");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();		
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input")).click();
		
		Thread.sleep(3000);
		WebElement e=driver.findElement(By.xpath("/html/body/div[2]/p[5]/em"));
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
		
		Thread.sleep(3000);	
		//driver.quit();
	}
}
