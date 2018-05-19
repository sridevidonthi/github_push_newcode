package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Helper;

public class LogOut {

	WebDriver driver;

	public LogOut(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='welcome']")
	WebElement welcomeUser;

	@FindBy(xpath = "//*[@id='welcome-menu']/ul/li[2]/a")
	WebElement Logout;

	@FindBy(xpath = ".//*[@id='divLogo']/img")
	WebElement logoutImg;

	public void logOffUser() {

		Helper.waitForWebElement(driver, welcomeUser, 30).click();

		Helper.waitForWebElement(driver, Logout, 30).click();

		Helper.waitForWebElement(driver, logoutImg, 30);

	}

}
