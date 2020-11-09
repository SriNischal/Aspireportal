package com.atmecs.automationAspireportal.validationresult;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.PropReader;
import com.atmecs.automationAspireportal.utils.ReadDataFromExcel;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.falcon.automation.ui.selenium.Browser;


public class EmployeePageValidation {
	PropReader propReader=new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ReadDataFromExcel readingData=new ReadDataFromExcel();
	ReadLocators read=new ReadLocators();
    String sheetname="Employee";
    String columnname="Validation Text";
	Pageactions page;
	ValidationHelper helper;

	public EmployeePageValidation(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
		helper = new ValidationHelper(browser);
		//reports=new ExtentReport(browser);
	}
	public void validateEmployeeBreadcrum() throws Exception {
		helper.getDataofRow("Breadcrum", "validate.empbreadcrum.txt",2);
	}
	public void validateEmployeeNotes() throws Exception {
		helper.getDataofRow("Notes value", "validate.tooltip.txt",9);

}
	public void validateEmployeeaddactvity() throws Exception {
		helper.getDataofRow("Add activity value", "validate.tooltip.txt",10);

}
	public void validateEmployeedeleteactvity() throws Exception {
		helper.getDataofRow("Delete activity value", "validate.tooltip.txt",11);

}
}