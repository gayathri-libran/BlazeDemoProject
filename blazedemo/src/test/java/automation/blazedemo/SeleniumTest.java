package automation.blazedemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.blazedemo.pageObjects.BookTicket;
import automation.blazedemo.pageObjects.Confirmationpage;
import automation.blazedemo.pageObjects.FindFlight;
import automation.blazedemo.pageObjects.SelectFlight;
import resources.Base;

public class SeleniumTest extends Base{
	
	public static final String EXPECTED_CONF_TEXT = "Thank you for your purchase today!";
	
	public WebDriver driver;

	 
	@BeforeTest
	public void initialize() throws IOException {
		driver =initializeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test(dataProvider="getData")
	public void browserAutomation(String name, String address, String city, String state, String zip, String cardType,String creditcardnumber,String creditcardmonth,String creditcardyear,String nameoncard) {
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		findFlight();
		selectFlight();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BookTicket bkTkt = new BookTicket(driver);
		bkTkt.getName().sendKeys(name);
		bkTkt.getAddress().sendKeys(address);
		bkTkt.getCity().sendKeys(city);
		bkTkt.getState().sendKeys(state);
		bkTkt.getZip().sendKeys(zip);
		bkTkt.getNameoncard().sendKeys(nameoncard);
		bkTkt.getCreditcardmonth().clear();
		bkTkt.getCreditcardmonth().sendKeys(creditcardmonth);
		bkTkt.getCreditcardyear().clear();
		bkTkt.getCreditcardyear().sendKeys(creditcardyear);
		bkTkt.getCreditcardNo().sendKeys(creditcardnumber);
		
		Select selectCardtype = new Select(driver.findElement(By.id("cardType")));
		selectCardtype.selectByValue(cardType);
		bkTkt.purchase().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Confirmationpage conFpage = new Confirmationpage(driver);
		String confirmationText= conFpage.getConfirmationpage().getText();
		
		Assert.assertEquals(confirmationText, EXPECTED_CONF_TEXT);
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	



	public void findFlight() {
		FindFlight findFlight = new FindFlight(driver);
		
		String departure = prop.getProperty("departure");
		findFlight.selectDeparture(departure);
		//wait
		
		String destination = prop.getProperty("destination");
		findFlight.selectDestination(destination);
		//wait
		
		findFlight.submit().click();
		//wait
	}
	
	public void selectFlight() {
		SelectFlight selectFlight= new SelectFlight(driver);
		String flightNumber= prop.getProperty("flightNumber");
		selectFlight.selectFlightElement(flightNumber).click();
	}

	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[1][10];
		//0th row
		data[0][0]="test";
		data[0][1]="123456";
		data[0][2]="bengaluru";
		data[0][3]="KA";
		data[0][4]="456788";
		data[0][5]= "amex";
		data[0][6]= "24553433534";
		data[0][7]= "12";
		data[0][8]= "2012";
		data[0][9]= "Mike";
		return data;
	}
	
}
