package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	static String chromeDriverPath = System.getProperty("user.dir");

	public static WebDriver lanuchChrome(String url){
		System.setProperty("webdriver.chrome.driver", chromeDriverPath+"//driver/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}
	
	public static WebDriver lanuchFirefox(String url) {
		return null;
		
	}
	
}
