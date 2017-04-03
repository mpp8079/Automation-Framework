package com.hybrid.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {
	private String excelFile;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFCell cell;
	private XSSFRow row;
	private FileInputStream is;
	private static Logger logger = Logger.getLogger(GetExcelData.class.getName());
	
	
	public String getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(String excelFile) {
		this.excelFile = excelFile;
	}

	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	public XSSFCell getCell() {
		return cell;
	}

	public void setCell(XSSFCell cell) {
		this.cell = cell;
	}

	public XSSFRow getRow() {
		return row;
	}

	public void setRow(XSSFRow row) {
		this.row = row;
	}

	public FileInputStream getIs() {
		return is;
	}

	public void setIs(FileInputStream is) {
		this.is = is;
	}
	
	public GetExcelData(String excelFile, String sheetName){
		setExcelFile(excelFile);
		try {
			setIs(new FileInputStream(getExcelFile()));
			setWorkbook(new XSSFWorkbook(getIs()));
			setSheet(sheetName.isEmpty()? getWorkbook().getSheetAt(0) : getWorkbook().getSheet(sheetName));
			getIs().close();
		} catch (SecurityException | IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	public GetExcelData(String excelFile){
		this(excelFile, "");
	}
	
	public void writeWorkbook(){
		try {
			FileOutputStream outFile = new FileOutputStream(new File(getExcelFile()));
			getWorkbook().write(outFile);
			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
// returns number of columns in a sheet
	private int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!doesSheetExist(sheetName))
			return -1;
		setSheet(getWorkbook().getSheet(sheetName));
		setRow(getSheet().getRow(0));

		if (getRow() == null)
			return -1;
		return getRow().getLastCellNum();
	}
	
	// find whether sheets exists
	private boolean doesSheetExist(String sheetName) {
		int index = getWorkbook().getSheetIndex(sheetName);
		if (index == -1) {
			index = getWorkbook().getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}
	
	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;
	}
	
	// returns the row count in a sheet
	private int getRowCount(String sheetName) {
		int index = getWorkbook().getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			setSheet(getWorkbook().getSheetAt(index));
			int number = getSheet().getLastRowNum() + 1;
			return number;
		}
	}
	
	// returns the data from a cell
		public String getCellData(String sheetName, String colName, int rowNum) {
			try {
				if (rowNum <= 0)
					return "";

				int index = getWorkbook().getSheetIndex(sheetName);
				int col_Num = -1;
				if (index == -1)
					return "";

				setSheet(getWorkbook().getSheetAt(index));
				setRow(getSheet().getRow(0));
				for (int i = 0; i < getRow().getLastCellNum(); i++) {
					if (getRow().getCell(i).getStringCellValue().trim()
							.equals(colName.trim()))
						col_Num = i;
				}
				if (col_Num == -1)
					return "";

				setRow(getSheet().getRow(rowNum - 1));
				if (getRow() == null)
					return "";
				setCell(getRow().getCell(col_Num));

				if (getCell() == null)
					return "";
				if (getCell().getCellType() == Cell.CELL_TYPE_STRING)
					return getCell().getStringCellValue();
				else if (getCell().getCellType() == Cell.CELL_TYPE_NUMERIC
						|| getCell().getCellType() == Cell.CELL_TYPE_FORMULA) {

					String cellText = String.valueOf(getCell().getNumericCellValue());
					if (DateUtil.isCellDateFormatted(getCell())) {
						double d = getCell().getNumericCellValue();
						Calendar cal = Calendar.getInstance();
						cal.setTime(DateUtil.getJavaDate(d));
						cellText = (String.valueOf(cal.get(Calendar.YEAR)))
								.substring(2);
						cellText = cal.get(Calendar.DAY_OF_MONTH) + "/"
								+ cal.get(Calendar.MONTH) + 1 + "/" + cellText;
					}

					return cellText;
				} else if (getCell().getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(getCell().getBooleanCellValue());

			} catch (Exception e) {
				logger.error(e.getMessage());
				return "row " + rowNum + " or column " + colName
						+ " does not exist in xls";
			}
		}
		
		public String getCellData(String sheetName, int colNum, int rowNum) {
			String cellText="";
			try {
				if (rowNum <= 0)
					return cellText;

				int index = getWorkbook().getSheetIndex(sheetName);

				if (index == -1)
					return cellText;

				setSheet(getWorkbook().getSheetAt(index));
				setRow(getSheet().getRow(rowNum-1));
				if (getRow() == null)
					return cellText;
				setCell(getRow().getCell(colNum));
				if (getCell() == null)
					return cellText;

				if (getCell().getCellType() == Cell.CELL_TYPE_STRING)
					return getCell().getStringCellValue();
				else if (getCell().getCellType() == Cell.CELL_TYPE_NUMERIC
						|| getCell().getCellType() == Cell.CELL_TYPE_FORMULA) {
					cellText = String.valueOf(getCell().getNumericCellValue());
					if (DateUtil.isCellDateFormatted(getCell())) {
						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						cellText = df.format(getCell().getDateCellValue());
				    }
					return cellText;
				} else if (getCell().getCellType() == Cell.CELL_TYPE_BLANK)
					return cellText;
				else
					return String.valueOf(getCell().getBooleanCellValue());
			} catch (Exception e) {
				logger.error(e.getMessage());
				return cellText;
			}
		}
/****************************************************************************************************
 * Reads the whole row of credit card or new user details based on the search criteria in the form of key value
 * pairs
 * 
 * @author yvkv001
 * @return
 ***************************************************************************************************/
    /*public void getDataRowFromExcel(String argumentList) {
    	GetExcelData datatable = new GetExcelData(Utilities.getWorkSpace() + "//Data//RegressionData.xlsx");
		String[] args = argumentList.split("@");
		Random randomGenerator = new Random();
		int randomInt = 0;
		if (args.length <= 1) {
		}
		String strWSName = args[0].trim().replace(" ", "");
		String keyValue = args[1].trim();

		try {
			int columns = datatable.getColumnCount(strWSName);
			int rowNum = datatable.getCellRowNum(strWSName, "TestCaseType", keyValue);

			for (int cNum = 0; cNum < columns; cNum++) {
				randomInt = randomGenerator.nextInt(1000000);
				String colName = datatable.getCellData(strWSName, cNum, 1);
				String colVal = datatable.getCellData(strWSName, cNum, rowNum);
				Utilities.setGlobalVar("gbl" + colName + "==>" + colVal);
				if(Boolean.parseBoolean(MasterHashMap.getValue(HashMapConstants.MasterConstant.GBL_RANDOM_USER_FOR_REGISTRATION))){
					if(colName.equalsIgnoreCase("firstname")){
						Utilities.setGlobalVar("gbl" + colName + "==>" + colVal+Integer.toString(randomInt));
					}else if(colName.equalsIgnoreCase("lastname")){
						Utilities.setGlobalVar("gbl" + colName + "==>" + colVal+Integer.toString(randomInt));
					}else if(colName.equalsIgnoreCase("email")){
						String[] tempVal = colVal.split("@");
						Utilities.setGlobalVar("gbl" + colName + "==>" + (tempVal[0]+Integer.toString(randomInt)+"@"+tempVal[1]));
					}else if(colName.equalsIgnoreCase("opportunityname")){
						Utilities.setGlobalVar("gbl" + colName + "==>" + colVal+Integer.toString(randomInt));
					}
				}
			}

		}
		// End
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
