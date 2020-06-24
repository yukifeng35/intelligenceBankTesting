package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testData.ConfigData;

public class LoadPage {

	public static void loadPageForHeader(WebDriver driver) {
		//The page header is loaded at the last part mostly
		//Consider that page is loaded successfully if the header element is found
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfigData.pageHeaderElementXpath));
	}
	
}
