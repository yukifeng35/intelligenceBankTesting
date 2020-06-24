package testCase;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.GetScreenshot;
import lib.OpenBrowser;
import lib.LoadPage;
import pages.HomePage;
import testData.ConfigData;
import testData.ContactUsFormTestData;
import pages.ContactUsPage;


public class ContactUsFormTest {
	
	WebDriver driver = null;
	By contactUsFormAreaElement = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]");
	String contactUsFormScreenshotFileName = "contactUsFormScreenshot";
	
	@BeforeTest
	public void loadHomePage(){
		//Open the home page
		driver = OpenBrowser.lanuchChrome(ConfigData.baseUrl);
		LoadPage.loadPageForHeader(driver); //waiting for the page loaded successfully
		
		
	}
	
	
	@Test
	public void fillInContactUsFormTest() {
		//Navigate to the Contact Us page
		HomePage homePageObj = new HomePage(driver);
		homePageObj.navigateToContactUsPage();
		LoadPage.loadPageForHeader(driver); //waiting for the page loaded successfully
				
		//Get Contact Us form JSON test data
		JSONObject contactUsFormJSONTestDataObj = new JSONObject();
		contactUsFormJSONTestDataObj = ContactUsFormTestData.contactUsFormJsonTestData();
		
		//Fill in every field on Contact Us form
		ContactUsPage contactUsPageObj = new ContactUsPage(driver);
		contactUsPageObj.fillInContactUsForm(contactUsFormJSONTestDataObj);
		
		//Get screenshot of the filled in contact form
		GetScreenshot.getScreenshotPartPage(driver,contactUsFormAreaElement,contactUsFormScreenshotFileName);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		//Close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed successfully");
	}
}
