package lib;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GetScreenshot {
	
	static String screenshotPath = System.getProperty("user.dir");
	
	public static void getScreenshotByfield(WebDriver driver, By field, String fileName) {
		WebElement contactForm = driver.findElement(field);
		driver.manage().window().fullscreen();
		((JavascriptExecutor) driver).executeScript("$('.sticky-header').css('position', 'relative');");

		Screenshot contactPageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,contactForm);
		try {                 
			ImageIO.write(contactPageScreenshot.getImage(),"PNG",new File(screenshotPath+"//screenshot/contactUsPage/"+fileName+".png"));       
			} catch (IOException e) {                              
			  e.printStackTrace();
			}     
	}
	
	public static void getScreenshotFullPage(WebDriver driver, String fileName) {
		driver.manage().window().fullscreen();
		Screenshot contactPageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {                 
			ImageIO.write(contactPageScreenshot.getImage(),"PNG",new File(screenshotPath+"//screenshot/contactUsPage/"+fileName+".png"));       
			} catch (IOException e) {                              
			  e.printStackTrace();
			}     
	}

	
	
}
