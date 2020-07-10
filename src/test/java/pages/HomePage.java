package pages;

import org.openqa.selenium.WebDriver;

import testData.ConfigData;


public class HomePage {
	
	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToContactUsPage(){
		driver.findElement(ConfigData.headerContactUs).click();
	}
	
}
