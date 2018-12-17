package com.serge.suite.bankmanager.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.serge.utilities.DataProviders;

public class OpenAccountTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP")
	public void openAccountTest(Hashtable<String, String> table) {

	}

}
