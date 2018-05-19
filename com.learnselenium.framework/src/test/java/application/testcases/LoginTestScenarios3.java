package application.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.DataProviderFactory;
import pagesObjects.BaseClass;
import pagesObjects.Login;
import utility.Helper;

public class LoginTestScenarios3 extends BaseClass {

	ExtentTest logger;

	@Test(description = "This test will verify user is able to login with valid crendentials")
	public void loginWithValidCredentials() 
	{
		logger = report.startTest("LoginValid");

		logger.log(LogStatus.INFO, "Browser and Application are up and running");

		Login login = PageFactory.initElements(driver, Login.class);

		try {
			login.loginApplicationWithSync(DataProviderFactory.getExcel().getStringData("Login", 1, 0), DataProviderFactory.getExcel().getStringData("Login", 1, 1));

			logger.log(LogStatus.PASS, "Browser and Application are up and running");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Login Func is not working");

			Assert.assertTrue(false);
		}

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			String path = Helper.captureScreenshot(driver);

			logger.log(LogStatus.FAIL, result.getThrowable().getMessage());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));

		}
		if (ITestResult.SUCCESS == result.getStatus()) {

			String path = Helper.captureScreenshot(driver);
			logger.log(LogStatus.PASS, logger.addScreenCapture(path));
		}

		report.endTest(logger);

	}

}
