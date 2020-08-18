package sathya;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Start of new test : " + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Successfully executed test cases and its details are : " + result.getName());
	}
	
	 public void onTestFailure(ITestResult result) {
		 System.out.println("Failed test cases and its details are : " + result.getName());
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("Skipped test cases and its details are : " + result.getName());
		 
	 }
	
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 System.out.println("Test failed but with success percentage and its details are : " + result.getName());
	 }
	 
	 public void onStart(ITestContext context) {
		 System.out.println("The root directory is : " + context.getOutputDirectory());
		 
	 }
	 
	 public void onFinish(ITestContext context) {
		 System.out.println("The list of Tests passed are : " + context.getPassedTests());
		 System.out.println("The list of Tests failed are : " + context.getFailedTests());
		 
	 }
	
	
	

}
