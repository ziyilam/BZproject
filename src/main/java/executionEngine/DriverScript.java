package executionEngine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript {
	public static ActionKeywords actionKeywords;
	public static String WX;
	
	private static final Logger logger = LogManager.getLogger(DriverScript.class.getName());
	
	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
	}
	
	public static void main(String[] args) throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData);
		DriverScript startEngine = new DriverScript();
		startEngine.execute_ProBZ();
	}
	
	private void execute_ProBZ() throws Exception {
		logger.info("\n\n---------------------------------------   execute_ProBZ|START  ---------------------------------------\n\n\n");
		for(int i = 0; i<=5;i++) {
		String BZ = ExcelUtils.getCellData(1, i, Constants.Sheet_ProBZ);
		actionKeywords.wuXing(BZ);
		int count = i+6;
		ExcelUtils.setCellData(WX, 1, count, Constants.Sheet_ProBZ);
		}
	}

}
