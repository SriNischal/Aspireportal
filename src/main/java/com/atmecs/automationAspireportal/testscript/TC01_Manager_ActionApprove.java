package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.helper.EmployeeHelper;
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
		Pageactions page=new Pageactions(browser);
		ManagerPageValidation validation=new ManagerPageValidation(browser);
		ManagerloginHelper manahelper=new ManagerloginHelper(browser);
	    ValidationHelper helper=new ValidationHelper(browser);
	    
	    EmployeeHelper employeeHelper=new EmployeeHelper(browser);
	  
	    employeeHelper.employeeHelper();
	    manahelper.LoginPage();
	report.info("Validating the Breadcrum");
		validation.validateManagerBreadcrum();
		report.info("Successfully validated breadcrum");
	report.info("Selecting the project");
	    helper.selectproject("Project", "loc.project.ddn", "loc.projecttext.txt", "loc.projectvalue.txt");
	report.info("Selecting the employee name");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.empnamedown.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected employee dropdown");
	report.info("Clicking approve button under action column");
	    helper.approve_rejectbutton("Approve message", "loc.actionapprove.btn", "validate.approvemessage.txt");
	}
}
