package pages;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	WebDriver driver = null;
	
	//All field elements
	By companyNameElement = By.name("company");
	By firstNameElement = By.name("firstname");
	By lastNameElement = By.name("lastname");
	By emailElement = By.name("email");
	By countryElement = By.name("country");
	By phoneNumberElement = By.name("phone");
	By enquiryDetailsElement = By.name("enquiry_details");
	By productFamilyElement = By.name("product_family");
	By agreeElement = By.name("i_agree_to_intelligencebank_s_terms_and_conditions");
	
	//submit button element
	By submitElement = By.cssSelector(".hs_submit:nth-child(12) .hs-button");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void fillInContactUsForm(JSONObject obj){
		driver.findElement(companyNameElement).sendKeys(obj.getString("CompanyName"));
		driver.findElement(firstNameElement).sendKeys(obj.getString("FirstName"));
		driver.findElement(lastNameElement).sendKeys(obj.getString("LastName"));
		driver.findElement(emailElement).sendKeys(obj.getString("Email"));
		new Select(driver.findElement(countryElement)).selectByVisibleText(obj.getString("Country"));
		driver.findElement(phoneNumberElement).sendKeys(obj.getString("PhoneNumber"));
		driver.findElement(enquiryDetailsElement).sendKeys(obj.getString("EnquiryDetails"));
		new Select(driver.findElement(productFamilyElement)).selectByVisibleText(obj.getString("ProductFamily"));
		if (obj.getBoolean("Agree")) {
			driver.findElement(agreeElement).click();
		}
	}
	
	public void clickSubmit(){
		driver.findElement(submitElement).click();
	}
	

}
