package pages;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	WebDriver driver = null;
	
	//All field elements
	By companyName = By.name("company");
	By firstName = By.name("firstname");
	By lastName = By.name("lastname");
	By email = By.name("email");
	By country = By.name("country");
	By phoneNumber = By.name("phone");
	By enquiryDetails = By.name("enquiry_details");
	By productFamily = By.name("product_family");
	By agree = By.name("i_agree_to_intelligencebank_s_terms_and_conditions");
	
	//Warning text elements
	By companyNameRequired = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/span/div/form/fieldset[1]/div/ul/li/label");
	By firstNameRequired = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/span/div/form/fieldset[2]/div[1]/ul/li/label");
	By emailRequired = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/span/div/form/fieldset[3]/div/ul/li/label");
	By emailFormatValidation = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/span/div/form/fieldset[3]/div/ul/li/label");
	By phoneNumberLengthValidation = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/span/div/form/fieldset[4]/div[2]/ul/li[1]/label");
	By phoneNumberCharacterValidation = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/span/div/form/fieldset[4]/div[2]/ul/li[2]/label");
	
	//submit button element
	By submitElement = By.cssSelector(".hs_submit:nth-child(12) .hs-button");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void fillInContactUsForm(JSONObject obj){
		driver.findElement(companyName).sendKeys(obj.getString("CompanyName"));
		driver.findElement(firstName).sendKeys(obj.getString("FirstName"));
		driver.findElement(lastName).sendKeys(obj.getString("LastName"));
		driver.findElement(email).sendKeys(obj.getString("Email"));
		new Select(driver.findElement(country)).selectByVisibleText(obj.getString("Country"));
		driver.findElement(phoneNumber).sendKeys(obj.getString("PhoneNumber"));
		driver.findElement(enquiryDetails).sendKeys(obj.getString("EnquiryDetails"));
		new Select(driver.findElement(productFamily)).selectByVisibleText(obj.getString("ProductFamily"));
		if (obj.getBoolean("Agree")) {
			driver.findElement(agree).click();
		}
	}
	
	public String getWarningText(String fieldName){
		switch (fieldName){
			case "companyNameMissing":
				return driver.findElement(companyNameRequired).getText();
			case "firstNameMissing":
				return driver.findElement(firstNameRequired).getText();
			case "emailMissing":
				return driver.findElement(emailRequired).getText();
			case "emailFormat":
				return driver.findElement(emailFormatValidation).getText();
			case "phoneNumberLength":
				return driver.findElement(phoneNumberLengthValidation).getText();
			case "phoneNumberChar":
				return driver.findElement(phoneNumberCharacterValidation).getText();
			default:
				return null;
		}
	}

	//not used, for further testing
	public void clickSubmit(){
		driver.findElement(submitElement).click();
	}
	

}
