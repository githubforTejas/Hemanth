package com.crm.vtigerTY.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplementClass implements ITestListener,IPathConstant {

	ExtentReports report;
	ExtentTest test;
	String screenShotName;
	String reportName;
	
	public void onTestStart(ITestResult result) {
		reportName=	result.getMethod().getMethodName();

	test=report.createTest(result.getMethod().getMethodName());
	
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS	, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
				try {
					screenShotName = WebDriverUtility.takeScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
					test.addScreenCaptureFromPath(screenShotName);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
//String testName = result.getMethod().getMethodName();
//System.out.println(testName+ "======= execute and i am Listening=====");
//
//EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.sdriver);
//File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
//try {
//	FileUtils.copyFile(srcFile, new File("./Screenshot/"+testName+".png"));
//}catch (IOException e) {
//	e.printStackTrace();
//}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP	, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

		ExtentSparkReporter spark=new ExtentSparkReporter(extentreportpath+"report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Framework Extent Report");
		spark.config().setDocumentTitle("Hemanth's document");

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "Hemanth");
		report.setSystemInfo("ReviwedBy", "Urs");
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("Browser","Chrome");
			
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
