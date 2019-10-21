package newtours.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;

public class SelectFlight {
	
	WebDriver driver;
	private Scenario scenario;
	
	@FindBy(name = "reserveFlights")
	private WebElement btnContinue;
	
	public SelectFlight(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario= scenario;
		PageFactory.initElements(driver, this);
	}
	
	public void selectFlight(String flight) {
		driver.findElement(By.xpath("//*[contains(text(), '"+ flight +"')]/../../..//input")).click();
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
		btnContinue.click();
	}

}
