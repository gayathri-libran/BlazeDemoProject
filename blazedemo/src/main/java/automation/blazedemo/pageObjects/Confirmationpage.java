package automation.blazedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Confirmationpage {
	
	public WebDriver driver;
	
	By confirmationText = By.xpath("//div[@class=\"container hero-unit\"]/h1");
	
	public Confirmationpage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public WebElement getConfirmationpage()
	{
		return driver.findElement(confirmationText);
	}

}
