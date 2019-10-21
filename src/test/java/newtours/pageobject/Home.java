package newtours.pageobject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;

public class Home {
	
	WebDriver driver;
	private Scenario scenario;
	
	@FindBy(xpath = "//a[text()='SIGN-ON']")
	private WebElement lnkSignOn;
	
	@FindBy(xpath = "//a[text()='REGISTER']")
	private WebElement lnkRegister;
	
	@FindBy(xpath = "//a[text()='SUPPORT']")
	private WebElement lnkSuport;
	
	@FindBy(xpath = "//a[text()='CONTACT']")
	private WebElement lnkContact;
	
	@FindBy(name = "userName")
	private WebElement txtUserName;
	
	@FindBy(name = "password")
	private WebElement txtPassWord;
	
	@FindBy(name = "login")
	private WebElement btnSignIn;
	
	public Home(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario= scenario;
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String user, String pass) {
		fillUserName(user);
		fillPassWord(pass);
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
		clickToSignIn();
	}
	
	public void fillUserName(String value) {
		txtUserName.clear();
		txtUserName.sendKeys(value);
	}
	
	public void fillPassWord(String value) {
		txtPassWord.clear();
		txtPassWord.sendKeys(value);
	}
	
	public void clickToSignIn() {
		btnSignIn.click();
	}

}
