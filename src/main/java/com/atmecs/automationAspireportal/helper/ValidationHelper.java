package com.atmecs.automationAspireportal.helper;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.utils.LogReport;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;

public class ValidationHelper {
	Browser browser = null;

	LogReport log = new LogReport();
	ReadLocators read = new ReadLocators();
	Pageactions page;
	String sheetname = "Employee";
	String columnname = "Validation Text";
	String actualmessage;
	String expectedmessage;

	public ValidationHelper(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
	}

	public void getDataofRow(String expectedString, String validationMessage, int i) throws Exception {
		actualmessage = page.getText(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
		page.writedata_toExcel(sheetname, columnname, i, actualmessage);
		expectedmessage = page.getdata_fromExcel(sheetname, columnname, expectedString);
		Verify.verifyString(actualmessage, expectedmessage, "Successfully validated the text");

	}
}
