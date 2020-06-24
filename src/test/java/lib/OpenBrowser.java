package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	static String chromeDriverPath = "//driver/chrome/chromedriver";

	public static WebDriver lanuchChrome(String url){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}
	
	public static WebDriver lanuchFirefox(String url) {
		return null;
		
	}
	
}
