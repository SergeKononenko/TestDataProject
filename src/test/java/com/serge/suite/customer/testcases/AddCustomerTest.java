package com.serge.suite.customer.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.serge.utilities.Constants;
import com.serge.utilities.DataProviders;
import com.serge.utilities.DataUtil;
import com.serge.utilities.ExcelReader;

public class AddCustomerTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "customerDP")
	public void addCustomerTest(Hashtable<String, String> data) {

		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		DataUtil.checkExecution("CustomerSuite", "AddCustomerTest",
				data.get("runMode"), excel);
		
		
	}

}
