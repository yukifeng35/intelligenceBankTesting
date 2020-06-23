package testCase;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.GetScreenshot;
import lib.OpenBrowser;
import lib.PageLoaded;
import pages.HomePage;
import testData.ConfigData;
import testData.ContactFieldData;
import pages.ContactPage;


public class ContactFieldTest {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void navigeteToContactUsPage(){
		//Open the home page
		driver = OpenBrowser.lanuchChrome(ConfigData.baseUrl);
		PageLoaded.pageLoaded(driver);
		
		//Navigate to the contact us page
		HomePage homePageObj = new HomePage(driver);
		homePageObj.navigateToContactUsPage();
		PageLoaded.pageLoaded(driver);
	}
	
	
	@Test
	public void setTextInContactUs() {
		//Get contact field JSON test data
		JSONObject obj = new JSONObject();
		obj = ContactFieldData.contactJsonData();
		
		//Fill in every field on contact
		ContactPage contactUsObj = new ContactPage(driver);
		contactUsObj.setTextInContactField(obj);
		
		//Get screenshot of the filled in contact form
		By contactField = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]");
		String fileName = "contactFieldScreenshot";
		GetScreenshot.getScreenshotByfield(driver,contactField,fileName);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		//Close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed successfully");
	}
}
