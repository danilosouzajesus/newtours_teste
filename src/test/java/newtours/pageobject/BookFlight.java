package newtours.pageobject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;

public class BookFlight {
	
	WebDriver driver;
	private Scenario scenario;
	
	@FindBy(name = "passFirst0")
	private WebElement txtFirstName;
	
	@FindBy(name = "passLast0")
	private WebElement txtLastName;
	
	@FindBy(name = "creditnumber")
	private WebElement txtCreditNumber;
	
	@FindBy(name = "cc_frst_name")
	private WebElement txtCcFirstName;
	
	@FindBy(name = "cc_last_name")
	private WebElement txtCcLastName;
	
	@FindBy(name = "buyFlights")
	private WebElement btnSecurePurchase;
	
	public BookFlight(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario= scenario;
		PageFactory.initElements(driver, this);
	}
	
	public void fillFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void fillLastName(String lastName) {
		txtLastName.sendKeys(lastName);		
	}
	
	public void fillCreditCard(String ccNumber) {
		txtCreditNumber.sendKeys(ccNumber);		
	}
	
	public void bookFlight(String firstName, String lastName, String ccNumber) {
		fillFirstName(firstName);
		fillLastName(lastName);
		fillCreditCard(ccNumber);
		txtCcFirstName.sendKeys(firstName);
		txtCcLastName.sendKeys(lastName);
		
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
		
		btnSecurePurchase.click();
	}

}
