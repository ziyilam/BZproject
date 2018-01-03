package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.Constants;



public class ExcelUtils {
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static org.apache.poi.ss.usermodel.Cell Cell;
	private static XSSFRow Row;

	private static final Logger logger = LogManager.getLogger(ExcelUtils.class.getName());
	
	public static void setExcelFile(String Path) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			/*logger.info(Path);
			logger.info(ExcelFile);
			logger.info(ExcelWBook);*/
		} catch (Exception e) {
			logger.error(" * ExcelUtils|setExcelFile. Exception Message - " + e.getMessage());
			
		}

	}
public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
		
		try {
			String CellData = "";
			
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			CellData = Cell.getStringCellValue();
			/*logger.info(SheetName);
			logger.info(ExcelWSheet);
			logger.info(Cell);
			logger.info(CellData);*/
			return CellData;
			
		
		} catch (Exception e) {
			logger.warn(" * No Cell Data is found and return []");
			return "";
		}
	}

public static void setCellData(String sResult, int iRowNum, int iColNum, String sSheetName) throws Exception {
	try {
		ExcelWSheet = ExcelWBook.getSheet(sSheetName);
		Row = ExcelWSheet.getRow(iRowNum);
		Cell = Row.getCell(iColNum);
		if (Cell == null) {
			Cell = Row.createCell(iColNum);
			Cell.setCellValue(sResult);
		} else {
			Cell.setCellValue(sResult);
		}
		FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
		ExcelWBook.write(fileOut);
		fileOut.close();
		ExcelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));
		logger.info("Data: [" + sResult + "]" + "\n\n" + " written successfully on: ["
				+ Constants.File_TestData + "]" + " - [" + sSheetName + "]");
	} catch (Exception e) {
		logger.error(" * ExcelUtils|setCellData. Exception Message - " + e.getMessage());
	}
}

}
