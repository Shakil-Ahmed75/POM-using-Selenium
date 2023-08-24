package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

  public class IndexPage {
	// create object of webdriver
	WebDriver ldriver;

	// constructor
	public IndexPage(WebDriver rdDriver) {
		ldriver = rdDriver;
		PageFactory.initElements(rdDriver, this);
	}
	
	@FindBy(linkText = "Sign in") 
	WebElement signIn;
	
	//identify action on webelement
	public void clickOnSignIn() {
		signIn.click();
		
	}

}
