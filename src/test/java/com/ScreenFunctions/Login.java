package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ReadExcel.ReadExcel;

public class Login extends ReadExcel {
	
	@FindBy(how=How.ID,using="txtUsername")
	public static WebElement Edi_Login_Username;
	
	@FindBy(how=How.ID,using="txtPassword")
	public static WebElement Edi_Login_Password;
	
	@FindBy(how=How.ID,using="btnLogin")
	public static WebElement Edi_Login_Login;
	
	  public static boolean Entercredentials() {
		  boolean flag = true;
		  
		  try{
		  
		  Edi_Login_Username.sendKeys(getCommonTestData("Username"));
		  Edi_Login_Password.sendKeys(getCommonTestData("Password"));
		  Edi_Login_Login.click();
		  System.out.println("credentials not entered successfully");
		  
		  }
		  
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  System.out.println("credentials entered successfully");
			  flag = false;
		  }
		  
		  return flag;
		  
	}

}
