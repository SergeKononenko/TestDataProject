package com.serge.suite.bankmanager.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.serge.utilities.Constants;
import com.serge.utilities.DataProviders;
import com.serge.utilities.DataUtil;
import com.serge.utilities.ExcelReader;

public class OpenAccountTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP")
	public void openAccountTest(Hashtable<String, String> data) {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("BankManagerSuite", "OpenAccountTest",
				data.get("runMode"), excel);
	
	}

}
