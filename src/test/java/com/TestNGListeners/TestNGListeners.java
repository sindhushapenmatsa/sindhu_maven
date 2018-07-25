package com.TestNGListeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.GenerateReports.GenerateReports;

public class TestNGListeners implements ITestListener,IInvokedMethodListener{
	public static String crntclassname;



	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult classname) {
		
		String TCname = classname.getInstanceName().toString();
		int lastposition_dot=TCname.lastIndexOf(".")+1;
		crntclassname = TCname.substring(lastposition_dot);
		GenerateReports.InitReport(crntclassname);
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		GenerateReports.flushReport();
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		GenerateReports.startTest(crntclassname);
		
	}

	
	
	
	
}
