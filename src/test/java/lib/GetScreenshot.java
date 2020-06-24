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
	
	static String UseDir = System.getProperty("user.dir");
	
	public static void getScreenshotPartial(WebDriver driver, By area, String fileName) {
		WebElement areaElement = driver.findElement(area);
		driver.manage().window().fullscreen();
		//It's for removing the sticky header for screenshot
		((JavascriptExecutor) driver).executeScript("$('.sticky-header').css('position', 'relative');");
		//Take screenshot
		Screenshot partialScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,areaElement);
		try {                 
			ImageIO.write(partialScreenshot.getImage(),"PNG",new File(UseDir+"//screenshot/"+fileName+".png"));       
			} catch (IOException e) {                              
			  e.printStackTrace();
			}     
	}
	
	//unused, for further testing
	public static void getScreenshotFull(WebDriver driver, String fileName) {
		driver.manage().window().fullscreen();
		//It's for removing the sticky header for screenshot
		((JavascriptExecutor) driver).executeScript("$('.sticky-header').css('position', 'relative');");
		//Take screenshot
		Screenshot fullScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {                 
			ImageIO.write(fullScreenshot.getImage(),"PNG",new File(UseDir+"//screenshot/"+fileName+".png"));       
			} catch (IOException e) {                              
			  e.printStackTrace();
			}     
	}

	
	
}
