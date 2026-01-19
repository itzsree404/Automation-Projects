package core;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotData extends BaseClass {
	
	 public static String captureScreenshot(String testName) {

	        String path = System.getProperty("user.dir")+ "/screenshots/" + testName + ".png";

	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            File dest = new File(path);
	            FileUtils.copyFile(src, dest);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        
	        }
	        
	        return path;
	    }
}
