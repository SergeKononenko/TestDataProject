package com.serge.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@Test(dataProvider = "getData")
	public void testData(Hashtable<String, String> data) {

		System.out.println(data.get("runMode") + "----" + data.get("firstName")
				+ "------" + data.get("lastName"));
	}

	
}
