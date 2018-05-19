package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Helper;

public class Login {

	WebDriver driver;

	public Login(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(name = "txtUsername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement loginButton;

	public void loginApplication(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}

	public void loginApplicationWithSync(String user, String pass) 
	{
		Helper.waitForWebElement(driver, username, 20).sendKeys(user);
		Helper.waitForWebElement(driver, password, 20).sendKeys(pass);
		Helper.waitForWebElement(driver, loginButton, 20).click();
	}

}
