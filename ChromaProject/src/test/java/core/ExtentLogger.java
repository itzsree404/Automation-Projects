package core;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {		
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static void setTest(ExtentTest extentTest) {
		test.set(extentTest);
	}
	public static void logInfo(String message) {
		test.get().info(message);
	}
	public static void logFail(String message) {
		test.get().fail(message);    
	}
}
