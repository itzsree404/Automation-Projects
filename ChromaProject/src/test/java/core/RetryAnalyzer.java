package core;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int MaxCount = 3, count = 0;
		if (!result.isSuccess()) {
			if (count < MaxCount) {
				count ++;
				System.out.println("retrying test method "+result.getName());
			}
		}
		return false;
		
	}
}
