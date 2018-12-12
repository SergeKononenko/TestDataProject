package com.serge.rough;

import com.serge.utilities.Constants;
import com.serge.utilities.ExcelReader;

public class ReadingExcelData {

	public static void main(String[] args) {

		ExcelReader excel = new ExcelReader(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\testdata\\BankManagersSuite.xlsx");
		int rowsTotal = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are: " + rowsTotal);
		String testName = "AddCustomerTest";
		// String testName = "OpenAccountTest";
// find test case start row
		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum <= rowsTotal; testCaseRowNum++) {
			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0,
					testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Start row: " + testCaseRowNum);

// Checking total rows in TestCase		
		int dataStartRowNum = testCaseRowNum + 2; // row where test data starts
		int testRows = 0;
		while (!excel.getCellData(Constants.DATA_SHEET, 0,
				dataStartRowNum + testRows).equals("")) {
			testRows++;
		}
		System.out.println("Num of Data rows: " + testRows);

// Checking total columns in TestCase
		int testCols = 0;
		int colStartColNum = testCaseRowNum + 1; // it is the next line after TC
													// name

		while (!excel
				.getCellData(Constants.DATA_SHEET, testCols, colStartColNum)
				.equals("")) {
			testCols++;
		}

		System.out.println("Num of Data cols: " + testCols);

//Print Data
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum
				+ testRows; rNum++) {
			for (int cNum = 0; cNum <= testCols; cNum++) {
				System.out.println(
						excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}

		}
	}

}