package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {
	
	@Override
	public boolean retry(ITestResult result) {
		int MaxCount = 3, count = 1;
		if (count< MaxCount) {
			
		}
		return false;
		
	}
}
