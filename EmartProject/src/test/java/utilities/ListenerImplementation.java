package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

import base.BaseClass;

public class ListenerImplementation extends BaseClass implements ITestListener{
		
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod());
		System.out.println("Test Started");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot screen= (TakesScreenshot) driver;
		File src= screen.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshots/test "+ System.currentTimeMillis() + ".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
}
