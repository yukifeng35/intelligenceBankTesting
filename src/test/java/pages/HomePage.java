package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	
	WebDriver driver = null;
	//Contact us button element
	By contactUsButtonElement = By.cssSelector("#hs_cos_wrapper_module_1560312803417508 > #hs-cta-wrapper-6aa09ce5-b1d5-4d93-9d57-69e82a85d536 > #hs-cta-6aa09ce5-b1d5-4d93-9d57-69e82a85d536 span");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToContactUsPage(){
		driver.findElement(contactUsButtonElement).click();
	}
	
}
