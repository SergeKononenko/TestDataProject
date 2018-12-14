package com.serge.rough;

import com.serge.utilities.ExcelReader;
import com.serge.utilities.TestUtil;

public class CheckingRunModes {

	public static void main(String[] args) {

		String suiteName = "BankManagerSuite";
		boolean suiteRunMode = TestUtil.isSuiteRunnable(suiteName,
				new ExcelReader(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\testdata\\Suite.xlsx"));
		System.out.println(suiteRunMode);
		
		
		String testCaseName = "AddCustomerTest";
		
		boolean testRunMode = TestUtil.isTestRunnable(testCaseName,
				new ExcelReader(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\testdata\\BankManagersSuite.xlsx"));
		System.out.println(testRunMode);
		
		
	}
}
