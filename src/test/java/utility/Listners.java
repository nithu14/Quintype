package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.model.ITest;

public class Listners extends Base implements ITestListener {
	
	ExtentReports extend=Base.Extendreport();
	public static ExtentTest test;
	
	public Listners() throws IOException {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test =extend.startTest(result.getMethod().getMethodName());
		
	//	ITestListener.super.onTestStart(result);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.getRunStatus();
		test.setDescription("Pass");
		
			extend.endTest(test);
//		ITestListener.super.onTestSuccess(result);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.getRunStatus();
		test.setDescription("Fail");
		extend.endTest(test);
	//	ITestListener.super.onTestFailure(result);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.getRunStatus();
		test.setDescription("Skipped");
		
		extend.endTest(test);
//		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extend.flush();
		extend.close();
//		ITestListener.super.onFinish(context);
	}

}
