package newtours.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;

public class SearchFlight {
	
	WebDriver driver;
	private Scenario scenario;
	
	@FindBy(xpath = "//a[text()='SIGN-OFF']")
	private WebElement lnkSignOff;
	
	@FindBy(xpath = "//a[text()='ITINERARY']")
	private WebElement lnkItinerary;
	
	@FindBy(xpath = "//a[text()='PROFILE']")
	private WebElement lnkProfile;
	
	@FindBy(xpath = "//a[text()='SUPPORT']")
	private WebElement lnkSuport;
	
	@FindBy(xpath = "//a[text()='CONTACT']")
	private WebElement lnkContact;
	
	@FindBy(name = "passCount")
	private WebElement cboPassangers;
	
	@FindBy(name = "fromPort")
	private WebElement cboFromPort;
	
	@FindBy(name = "fromMonth")
	private WebElement cboFromMonth;
	
	@FindBy(name = "fromDay")
	private WebElement cboFromDay;
	
	@FindBy(name = "toPort")
	private WebElement cboToPort;
	
	@FindBy(name = "toMonth")
	private WebElement cboToMonth;
	
	@FindBy(name = "toDay")
	private WebElement cboToDay;
	
	@FindBy(name = "findFlights")
	private WebElement btnContinue;
	
	public SearchFlight(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario= scenario;
		PageFactory.initElements(driver, this);
	}
	
	public void selectDepartingFrom(String from) {
		new Select(cboFromPort).selectByVisibleText(from);
	}
	
	public void selectArrivingIn(String to) {
		new Select(cboToPort).selectByVisibleText(to);
	}
	
	public void selectTravelDate(String month, String day) {
		new Select(cboFromMonth).selectByVisibleText(month);
		new Select(cboFromDay).selectByVisibleText(day);
	}
	
	public void selectTravelClass(String flightClass) {
		switch (flightClass.toLowerCase()) {
		case "economy":
			driver.findElement(By.xpath("//input[contains(@value,'Coach')]")).click();
			break;
			
		case "business ":
			driver.findElement(By.xpath("//input[contains(@value,'Business')]")).click();		
			break;
					
		case "first":
			driver.findElement(By.xpath("//input[contains(@value,'First')]")).click();
			break;
		}
	}
	
	public void selectPassengersQuantity(int quantity) {
		new Select(cboPassangers).selectByVisibleText(quantity+"");
	}
	
	public void searchFlight(int passengerQuantity, String from, String to, String month, String day, String flightClass) {
		selectDepartingFrom(from);
		selectArrivingIn(to);
		selectTravelDate(month, day);
		selectTravelClass(flightClass);
		selectPassengersQuantity(passengerQuantity);
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
		btnContinue.click();
	}
}
