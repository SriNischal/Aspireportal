package com.atmecs.automationAspireportal.helper;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.testscript.SampleTestScript;
import com.atmecs.automationAspireportal.utils.LoadProperties;
import com.atmecs.automationAspireportal.utils.LogReport;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class EmployeeloginHelper {
	Browser browser=null;
	Pageactions page;
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	LogReport log = new LogReport();
	public EmployeeloginHelper(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
	}
	
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	public void LoginPage() throws Exception {
	log.info("STEP#1: Entering the Email");
		String email=page.getdata_fromExcel("Login Page", "Employee Username", "Employee");
		page.sendKeys(ReadLocators.getPropertyvalue("loc.email.input", ProjectBaseConstantPaths.LOCATORS_FILE), email);
		report.info("Successfully entered Email");
	log.info("STEP#2: Entering the Password");
		String password=page.getdata_fromExcel("Login Page", "Employee Password", "Employee");
		page.sendKeys(ReadLocators.getPropertyvalue("loc.password.input", ProjectBaseConstantPaths.LOCATORS_FILE), password);
		report.info("Successfully entered Password");
	log.info("STEP#3: Click on Login button");  
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.login.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully clicked on login button");
	log.info("STEP#4: Clicking on the Timesheet");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.timesheet.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the Timesheet");

}
}