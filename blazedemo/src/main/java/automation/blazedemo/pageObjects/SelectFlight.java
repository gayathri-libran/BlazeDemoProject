package automation.blazedemo.pageObjects;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFlight {

	public WebDriver driver;

	public SelectFlight(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement selectFlightElement(String flightNumber) {
		WebElement returnElement = null;
		WebElement baseTable = driver.findElement(By.tagName("table"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		WebElement flightNoElement = null;
		
		for(int i=1; i<rows.size(); i++) {
			
			 flightNoElement = baseTable.findElement(By.xpath("//*[@class=\"table\"]/tbody/tr["+i+"]/td[2]"));
			
			if (null!= flightNumber && flightNumber.equalsIgnoreCase(flightNoElement.getText())) {
				returnElement = baseTable.findElement(By.xpath("//*[@class=\"table\"]/tbody/tr[" +i +"]/td[1]"));
				break;
			}
		}
		
		return returnElement;
	}

}
