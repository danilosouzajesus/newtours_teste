package newtours.pageobject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import junit.framework.Assert;

public class ConfirmFlight {

	WebDriver driver;
	private Scenario scenario;
	
	@FindBy(xpath = "//font[contains(text(),'Confirmation')]")
	private WebElement lblFlightConfirmationNumber;
		
	public ConfirmFlight(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario= scenario;
		PageFactory.initElements(driver, this);
	}
	
	public void confirmFlightConfirmation() {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
		Assert.assertEquals(true, lblFlightConfirmationNumber.isDisplayed());
	}
	
	public String getFlightConfirmation() {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
		return lblFlightConfirmationNumber.getText();
	}
}
