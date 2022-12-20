package com.Practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AtmosolCorrection

{

	WebDriver driver;
	/*
	 * public static AtmosolCorrection obj() { AtmosolCorrection ac=new
	 * AtmosolCorrection(); return ac; }
	 */

	public void invokeBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().minimize();
		String url = "https://blazedemo.com/reserve.php";
		driver.get(url);

		AtmosolCorrection ac = new AtmosolCorrection();
		// return ac;

	}

	public void selectPrize() throws InterruptedException, IOException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Thread.sleep(3000);
		List<WebElement> price = driver.findElements(By.xpath("//tr //td[6]"));
		for (int i = 0; i < price.size(); i++) {

			int highest = (int) Double.parseDouble(price.get(i).getText().replaceAll("[^0-9.]", ""));
			if (highest > 700) {

				js.executeScript("arguments[0].style.border='2px solid #E74C3C'",
						driver.findElements(By.xpath("//tr //td[1]/input")).get(i));

				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				FileHandler.copy(source, new File("G:\\Software Testing Course\\Screenshot\\sss.png"));
				driver.findElements(By.xpath("//tr //td[1]/input")).get(i).click();
				driver.navigate().to("https://blazedemo.com/confirmation.php");

				break;

			}
		}

		js.executeScript("arguments[0].style.border='2px solid #E74C3C'",
				driver.findElement(By.xpath("(//tr //td[2])[1]")));
		File f = driver.findElement(By.xpath("(//tr //td[2])[1]")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("G:\\Software Testing Course\\Screenshot\\id.png"));

	}

	public static void main(String[] args) throws InterruptedException, IOException {

		AtmosolCorrection ac = new AtmosolCorrection();
		ac.invokeBrowser("chrome");
		Thread.sleep(3000);
		ac.selectPrize();
	}

}
