package testCases;

import org.testng.annotations.Test;

import pageObject.IndexPage;
import pageObject.MyAccountPage;

public class TC01MyAccountPage extends WebBase {

	@Test 
	public void verifyRegistrationAndLogin() {
		
		logger.info("***************TestCase Verify Registration and Login starts*****************");
		IndexPage page= new IndexPage(driver);
		page.clickOnSignIn();
		logger.info("Clicked on sign in link");
		
		MyAccountPage myPage= new MyAccountPage(driver);
		myPage.enterCreateEmailAddress("shakilahmed@gmail.com");
		logger.info("Entered Email Address");
		myPage.clickSubmitCreate();
		logger.info("clicked on create an account button");
	}
}
