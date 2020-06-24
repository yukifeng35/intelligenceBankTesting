package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testData.ConfigData;

public class LoadPage {

	public static void loadPageForHeader(WebDriver driver) {
		//The Contact Us button in the header of page is loaded at the last part mostly
		//Consider that page is loaded successfully if the Contact Us button element is found
		try {
			WebDriverWait wait = new WebDriverWait(driver, 300000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConfigData.headerContactUs));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
