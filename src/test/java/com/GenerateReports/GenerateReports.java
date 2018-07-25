package com.GenerateReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateReports {
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void InitReport(String crntclassname)
	{
		
		extent = new ExtentReports(createResultsFolder(crntclassname)+"\\"+crntclassname+".html");
		extent.addSystemInfo("Sprint :","Sprint 32");
		extent.addSystemInfo("Environemnt ","QA");
		extent.addSystemInfo("Cycle","Cycle 2");
	
		
	}
	
	
	public static void startTest(String crntclassname)
	{
		
		test = extent.startTest(crntclassname);
		
	}
	
	public static void logEvent(String status,String Description)
	{
		switch(status.toLowerCase())
		{
		
		case "pass" :
			test.log(LogStatus.PASS, Description);
			break;
		
		case "fail" :
			test.log(LogStatus.FAIL, Description);
			break;
			
		default:
			break;
		
		
		}
		
	}
	
	
	public static void flushReport()
	{
		extent.endTest(test);
		extent.flush();
		
		
		
	}
	
	
	
	public static String createResultsFolder(String crntclassname)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String currentdate = sdf.format(new Date());
		String Path = System.getProperty("user.dir")+"\\Results\\"+currentdate+crntclassname;
		
		File f = new File(Path);
		
		if(!f.exists())
		{
			
			f.mkdirs();
			
		}
		return Path;
		
		
	}



	

}
