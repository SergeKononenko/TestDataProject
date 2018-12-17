package com.serge.rough;

import com.serge.utilities.DataUtil;
import com.serge.utilities.ExcelReader;

public class CheckingRunModes {

	public static void main(String[] args) {

		String suiteName = "BankManagerSuite";
		boolean suiteRunMode = DataUtil.isSuiteRunnable(suiteName,
				new ExcelReader(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\testdata\\Suite.xlsx"));
		System.out.println(suiteRunMode);
		
		
		String testCaseName = "AddCustomerTest";
		
		boolean testRunMode = DataUtil.isTestRunnable(testCaseName,
				new ExcelReader(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\testdata\\BankManagersSuite.xlsx"));
		System.out.println(testRunMode);
		
		
	}
}
