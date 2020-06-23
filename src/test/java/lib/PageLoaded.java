package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testData.ConfigData;

public class PageLoaded {

	public static void pageLoaded(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfigData.pageHeadClassName));
	}
	
}
