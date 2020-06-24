package testCase;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
import pages.ContactUsPage.errorPromptName;


public class ContactUsFormTest {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void navigateToContactUsPage(){
		//Open the home page
		driver = OpenBrowser.lanuchChrome(ConfigData.baseUrl);
		LoadPage.loadPageForHeader(driver); //waiting for the page loaded successfully
		
		//Navigate to the Contact Us page
		HomePage homePageObj = new HomePage(driver);
		homePageObj.navigateToContactUsPage();
		LoadPage.loadPageForHeader(driver);
	}
	
	
	@Test
	//Contact Us form positive testing 
	public void fillInContactUsFormTest() {
		//Get Contact Us form JSON test data
		JSONObject testDataObj = ContactUsFormTestData.fillFormJson();
		
		//Fill in every field on Contact Us form
		ContactUsPage contactUsPageObj = new ContactUsPage(driver);
		contactUsPageObj.fillInContactUsForm(testDataObj);
		
		
		//Get screenshot of the filled in contact form
		GetScreenshot.getScreenshotPartial(driver,ContactUsFormTestData.targetArea,ContactUsFormTestData.screenshotFileName);
		
	}
	
	@Test
	//Contact Us form negative testing for missing required fields
	public void fillInContactUsFormTestForMissingRequiredField() {
		//Get Contact Us form JSON test data for missing required field
		JSONObject testDataObj = ContactUsFormTestData.fillFormJsonMissingRequired();
		
		//Fill in every field on Contact Us form
		ContactUsPage contactUsPageObj = new ContactUsPage(driver);
		contactUsPageObj.fillInContactUsForm(testDataObj);
		
		//Verify Contact Us form missing required field text
		Assert.assertEquals(contactUsPageObj.getWarningText(errorPromptName.COMPANY_NAME_MISSING), ContactUsFormTestData.missingRequiredWarning);
		Assert.assertEquals(contactUsPageObj.getWarningText(errorPromptName.FIRST_NAME_MISSING), ContactUsFormTestData.missingRequiredWarning);
		Assert.assertEquals(contactUsPageObj.getWarningText(errorPromptName.EMAIL_MISSING), ContactUsFormTestData.missingRequiredWarning);
		
		//Get screenshot of the filled in contact form with missing required field warning message
		GetScreenshot.getScreenshotPartial(driver,ContactUsFormTestData.targetArea,ContactUsFormTestData.missingRequiredScreenshotFileName);
		
	}
	
	@Test
	//Contact Us form negative testing for format validation
	public void fillInContactUsFormTestForDataFormatValidation() {
		//Get Contact Us form JSON test data for format validation
		JSONObject testDataObj = ContactUsFormTestData.fillFormJsonSpecialFieldsValidation();
		
		//Fill in every field on Contact Us form
		ContactUsPage contactUsPageObj = new ContactUsPage(driver);
		contactUsPageObj.fillInContactUsForm(testDataObj);
		
		//Verify Contact Us form format validation text
		Assert.assertEquals(contactUsPageObj.getWarningText(errorPromptName.EMAIL_FORMAT),ContactUsFormTestData.emailFormatWarning);
		Assert.assertEquals(contactUsPageObj.getWarningText(errorPromptName.PHONE_NUMBER_LENGTH), ContactUsFormTestData.phoneNumberLengthWarning);
		Assert.assertEquals(contactUsPageObj.getWarningText(errorPromptName.PHONE_NUMBER_CHAR), ContactUsFormTestData.phoneNumberCharacterWarning);
		
		//Get screenshot of the filled in contact form with format validation warning message
		GetScreenshot.getScreenshotPartial(driver,ContactUsFormTestData.targetArea,ContactUsFormTestData.formatValidationScreenshotFileName);
		
	}

	@AfterMethod
	//Refresh the page for the new test data
	public void pageRefreshAfterEachTest() {
		driver.navigate().refresh();
		LoadPage.loadPageForHeader(driver);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		//Close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
