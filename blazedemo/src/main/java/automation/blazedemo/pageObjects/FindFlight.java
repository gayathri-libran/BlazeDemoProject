package automation.blazedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindFlight {

	public WebDriver driver;
	By departure= By.xpath("//select[@name ='fromPort']");
	By destination= By.xpath("//select[@name ='toPort']");
	By submit=By.xpath("//input[@type='submit']");
	
	public FindFlight(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public void selectDeparture (String departureLocation) {
		Select departure = new Select(driver.findElement(By.xpath("//select[@name ='fromPort']")));
		departure.selectByValue(departureLocation);
	}
	
	public void selectDestination (String destination) {
		Select departure = new Select(driver.findElement(By.xpath("//select[@name ='toPort']")));
		departure.selectByValue(destination);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
}
