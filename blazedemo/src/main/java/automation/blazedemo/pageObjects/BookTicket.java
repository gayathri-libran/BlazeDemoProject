package automation.blazedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookTicket {
	
	public WebDriver driver;
	By name=By.id("inputName");
	By address=By.id("address");
	By city=By.id("city");
	By state=By.id("state");
	By zip=By.id("zipCode");
	By cardType=By.id("cardType");
	By creditcardnumber=By.id("creditCardNumber");
	By creditcardmonth=By.id("creditCardMonth");
	By creditcardyear=By.id("creditCardYear");
	By nameoncard=By.id("nameOnCard");
	By purchase = By.xpath("//input[@type='submit']");
	
	
	public BookTicket(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getName()
	{
		return driver.findElement(name);
	}
	public WebElement getAddress()
	{
		return driver.findElement(address);
	}
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	public WebElement getState()
	{
		return driver.findElement(state);
	}
	public WebElement getZip()
	{
		return driver.findElement(zip);
	}
	public WebElement getCardType()
	{
		return driver.findElement(cardType);
	}
	public WebElement getCreditcardNo()
	{
		return driver.findElement(creditcardnumber);
	}
	public WebElement getCreditcardmonth()
	{
		return driver.findElement(creditcardmonth);
	}
	public WebElement getCreditcardyear()
	{
		return driver.findElement(creditcardyear);
	}
	public WebElement getNameoncard()
	{
		return driver.findElement(nameoncard);
	}
	public WebElement purchase()
	{
		return driver.findElement(purchase);
	}
	
	
	
}
