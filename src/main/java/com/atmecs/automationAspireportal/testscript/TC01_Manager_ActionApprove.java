package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.helper.EmployeeloginHelper;
import com.atmecs.automationAspireportal.helper.ManagerloginHelper;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.automationAspireportal.utils.LoadProperties;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.automationAspireportal.validationresult.EmployeePageValidation;
import com.atmecs.automationAspireportal.validationresult.ManagerPageValidation;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC01_Manager_ActionApprove extends TestSuiteBase{
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	String actualtooltipmessage;
	String expectedtooltipmessage;
	String sheetname="Employee";
	String columnname="Validation Text";
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	@Test
	public void EmployeePage() throws Exception {
		EmployeePageValidation validate=new EmployeePageValidation(browser);
		Pageactions page=new Pageactions(browser);
		ManagerPageValidation validation=new ManagerPageValidation(browser);
		ManagerloginHelper manahelper=new ManagerloginHelper(browser);
	    EmployeeloginHelper emphelper=new EmployeeloginHelper(browser);
	    emphelper.LoginPage();
	    ValidationHelper helper=new ValidationHelper(browser);
	 report.info("STEP#5: Validating the Breadcrum");
		validate.validateEmployeeBreadcrum();
		report.info("Successfully validated breadcrum");
		//page.clickOnElement(ReadLocators.getPropertyvalue("loc.copy.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	report.info("STEP#6: Selecting the activity");
	    helper.selectactivity("Activity 1", "loc.activity.drpdwn", "loc.actvity.ddn", "loc.activityvalue.ddn");
	report.info("STEP#7: Entering hours to the days");	
	    helper.enterDatatoRow("Monday value", "loc.monvalue.txt");
	    helper.enterDatatoRow("Tuesday value", "loc.tuevalue.txt");
	    helper.enterDatatoRow("Wednesday value", "loc.wedvalue.txt");
	    helper.enterDatatoRow("Thursday value", "loc.thuvalue.txt");
	    helper.enterDatatoRow("Friday value", "loc.frivalue.txt");
	 report.info("STEP#8: Add Notes");
	    helper.tooltipmessage("Notes value", "loc.notestooltip.txt", "Notes text", "loc.textarea.txt","validate.notestooltip.txt");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.approvenotes.btn", ProjectBaseConstantPaths.LOCATORS_FILE)); 
	report.info("STEP#9: Add Activity");	
	    helper.activity("Add activity value", "loc.addactvity.btn", "validate.addtooltip.txt");
	report.info("STEP#10: Selecting the second activity");	
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.activity2.drpdwn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    String activity2=page.getdata_fromExcel("Employee", "Validation Text", "Activity 2");
        page.sendKeys(ReadLocators.getPropertyvalue("loc.actvity.ddn", ProjectBaseConstantPaths.LOCATORS_FILE), activity2);
        page.clickOnElement(ReadLocators.getPropertyvalue("loc.activityvalue.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
  	    report.info("Successfully selected Activity");
	report.info("STEP#11: Delete Activity");
	    helper.activity("Delete activity value", "loc.deleteactivity.btn", "validate.deletetooltip.txt");
	report.info("STEP#12: Submit button");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.submit.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    actualtooltipmessage=page.getText(ReadLocators.getPropertyvalue("validate.submitmessage.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
        expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Submit message");
        Verify.verifyString(actualtooltipmessage, expectedtooltipmessage, "Validating the tooltip message is same as expected or not");
		report.info("Successfully validated submit message");
	report.info("STEP#13: Logout button");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.logout.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.logouttext.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    
	    manahelper.LoginPage();
	report.info("STEP#14: Validating the Breadcrum");
		validation.validateManagerBreadcrum();
		report.info("Successfully validated breadcrum");
	report.info("STEP#15: Selecting the project");
	    helper.selectproject("Project", "loc.project.ddn", "loc.projecttext.txt", "loc.projectvalue.txt");
	report.info("STEP#16: Selecting the employee name");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.empnamedown.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected employee dropdown");
	report.info("STEP#17: Clicking approve button under action column");
	    helper.approvebutton("Approve message", "loc.actionapprove.btn", "validate.approvemessage.txt");
	}
}
