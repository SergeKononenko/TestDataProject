package com.serge.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "bankManagerDP")
	public static Object[][] getDataSuite1(Method m) {

		return DataUtil.getData(m.getName(),
				new ExcelReader(Constants.SUITE1_XL_PATH));
	}

	@DataProvider(name = "customerDP")
	public static Object[][] getDataSuite2(Method m) {

		return DataUtil.getData(m.getName(),
				new ExcelReader(Constants.SUITE2_XL_PATH));
	}
}
