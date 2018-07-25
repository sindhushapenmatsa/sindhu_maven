package com.GenericFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ReadExcel.ReadExcel;

public class GenericFunctions extends ReadExcel {
	public static WebDriver driver;
	
	public static boolean launch_app(){
		
		boolean flag = true;
		try{
			driver = new FirefoxDriver();
			
			driver.get(getCommonTestData("Url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Application launched successfully");
		}
		
		catch(Exception e){
			
			System.out.println(e.getMessage());
			System.out.println("Application launch Failed");
			flag =false;
		}
		
		return flag;
		
	}
	
	
	

}
