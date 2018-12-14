package com.serge.utilities;

public class TestUtil {

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

}
