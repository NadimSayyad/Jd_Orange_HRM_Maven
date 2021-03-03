package com.OrangeHRM;

import org.testng.annotations.DataProvider;

public class OrangeHRMTestData {
	
	@DataProvider(name = "Login")
	public Object[][] getDataLogin() {
		// Multidimensional Object
				// 3X3 or 4X3 or 4X5
		
		return new Object[][] {
			{"Admin", "admin123"},
			{"Admin", "admin123"},
			{"Admin", "admin123"}
			
		};
		
	}
	
	@DataProvider(name = "loginValidation")
	public Object[][] getValidationData() {
		
		return new Object[][]{
			{
				"", "", "Username cannot be empty"
			},
			{
				"Admin", "", "Password cannot be empty"
			},
			
			{
				"", "admin123", "Username cannot be empty"
			}, 
			{
				"Admin", "admin123", "Dashboard"
			}
			
		};
	}
	
	@DataProvider(name = "LoginExcelData")
	public Object[][] Authentication() throws Exception{
		ReadExcelFileSignIn excel = new ReadExcelFileSignIn();
		String RelativePath = System.getProperty("user.dir");
		//Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\git\\abhikdixit-Maven_Selenium_WebDriver_4\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xlsx","SignIn");
		Object[][] testObjArray = excel.getExcelData(RelativePath+"\\HRM_Test_Data.xlsx","SignIn");
		System.out.println(testObjArray);
		return testObjArray;

	}
	

}
