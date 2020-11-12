package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.helper.DateHelper;
import com.atmecs.automationAspireportal.helper.ManagerloginHelper;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.automationAspireportal.utils.Waits;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC05_ShiftsPage extends TestSuiteBase{
	ValidationHelper helper=new ValidationHelper(browser);
	DateHelper date=new DateHelper(browser);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	@Test
	public void Shifts() throws Exception {
		ManagerloginHelper manahelper=new ManagerloginHelper(browser);
		Pageactions page =new Pageactions(browser);
		Waits wait=new Waits(browser);
		manahelper.LoginPage();
	report.info("Clicking on the Shifts button");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.shiftsbutton.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	report.info("Successfully clicked on the shifts button");
	report.info("Clicking on the project dropdown in shifts page");
	    Thread.sleep(5000);
		helper.selectproject("Project", "loc.shifts.ddn", "loc.projecttext.txt", "loc.projectvalue.txt");
	report.info("Successfully selected the project");
	report.info("Clicking on click here to update shifts");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.clickHereToUpdateShift.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	report.info("Successfully clicked on click here to update shifts"); 
	report.info("Selecting Employee");
	    helper.selectemployee("loc.selectEmployee.input", "loc.projectvalue.txt");
	report.info("Successfully selected employee");
	report.info("Selecting start date and end date");
	    date.selectdates();
	report.info("Successfully selected dates");    
	report.info("Selecting Shift");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.selectshift.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
	report.info("Successfully selected shift");
	report.info("Clicking on save button");
	   page.clickOnElement(ReadLocators.getPropertyvalue("loc.save.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	   helper.getDataofRow("Shifts", "validate.alertmsg.txt", 9);   
	    
	}
}
