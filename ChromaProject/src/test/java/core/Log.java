package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

	public class Log {
		
		 public static Logger getLogger(Class<?> cls) {
		        return LogManager.getLogger(cls);
		    }
		 
		public static void info(String message) {
	        Logger logger = LogManager.getLogger();
	        logger.info(message);
	        ExtentLogger.logInfo(message);
	    }

	    public static void error(String message) {
	        Logger logger = LogManager.getLogger();
	        logger.error(message);
	        ExtentLogger.logFail(message);
	    }

}
