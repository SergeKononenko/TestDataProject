package com.serge.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataUtil {

	public static boolean isSuiteRunnable(String suiteName, ExcelReader excel) {

		int rows = excel.getRowCount(Constants.SUITE_SHEET);
		for (int rowNum = 2; rowNum < rows; rowNum++) {
			String data = excel.getCellData(Constants.SUITE_SHEET,
					Constants.SUITENAME_COL, rowNum);
			if (data.equals(suiteName)) {
				String runMode = excel.getCellData(Constants.SUITE_SHEET,
						Constants.RUNMODE_COL, rowNum);
				if (runMode.equals(Constants.RUNMODE_YES)) {
					return true;
				} else
					return false;
			}
		}
		return false;

	}

	public static boolean isTestRunnable(String testCaseName,
			ExcelReader excel) {

		int rows = excel.getRowCount(Constants.TESTCASE_SHEET);

		for (int rowNum = 2; rowNum < rows; rowNum++) {
			String data = excel.getCellData(Constants.TESTCASE_SHEET,
					Constants.TESTCASE_COL, rowNum);
			if (data.equals(testCaseName)) {
				String runMode = excel.getCellData(Constants.TESTCASE_SHEET,
						Constants.RUNMODE_COL, rowNum);
				if (runMode.equals(Constants.RUNMODE_YES)) {
					return true;
				} else
					return false;
			}
		}
		return false;

	}

	@DataProvider
	public static Object[][] getData(String testCase, ExcelReader excel) {

		int rowsTotal = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are: " + rowsTotal);
		String testName = testCase;

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

//Getting Data
		Object[][] data = new Object[testRows][1];
		int i = 0;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum
				+ testRows; rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum <= testCols; cNum++) {
//				System.out.println(
//						excel.getCellData(Constants.DATA_SHEET, cNum, rNum));

//				data[rNum - dataStartRowNum][cNum] = excel
//						.getCellData(Constants.DATA_SHEET, cNum, rNum);

				String testData = excel.getCellData(Constants.DATA_SHEET, cNum,
						rNum);
				String colName = excel.getCellData(Constants.DATA_SHEET, cNum,
						colStartColNum);
				table.put(colName, testData);

			}
			data[i][0] = table;
			i++;
		}
		return data;
	}

}
