package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void verify_Login() {
		logger.info("****Starting TC002_LoginTest");
		// Homepage
		try {
			HomePage hp = new HomePage(driver);
			hp.clickmyaccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.EnterMailid(p.getProperty("email"));
			lp.EnterPassword(p.getProperty("password"));
			lp.clkOnLogin();
			// My account
			MyAccountPage macp = new MyAccountPage(driver);
			boolean targetpage = macp.isMyAccountPageExists();
			// Assert.assertEquals(targetpage, true,"Login Failed");
			Assert.assertTrue(targetpage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****Starting TC002_LoginTest");
	}

}
