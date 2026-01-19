package core;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener extends BaseClass implements ITestListener {

	private static ExtentReports extent = ExtentReportManager.getReportInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	Logger log = Log.getLogger(this.getClass());

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest =extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);	
		log.info("Test started: {}", result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
		log.info("Test passed: {}", result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		log.error("Test failed: {}", result.getMethod().getMethodName());
		log.error("Failure reason: ", result.getThrowable());
		test.get().fail(result.getThrowable());
		String screenshotPath = ScreenshotData.captureScreenshot(result.getMethod().getMethodName());
		test.get().addScreenCaptureFromPath(screenshotPath);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip("Test Skipped");
		log.warn("Test skipped: {}", result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

}
