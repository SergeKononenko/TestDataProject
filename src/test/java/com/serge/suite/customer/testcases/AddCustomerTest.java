package com.serge.suite.customer.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.serge.utilities.DataProviders;

public class AddCustomerTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "customerDP")
	public void addCustomerTest(Hashtable<String, String> table) {

	}

}
