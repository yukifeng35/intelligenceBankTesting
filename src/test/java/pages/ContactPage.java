package pages;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

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
	
	
	//submit button element
	By submit = By.cssSelector(".hs_submit:nth-child(12) .hs-button");
	

	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void setTextInContactField(JSONObject obj){
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
	
	public void clickSubmit(){
		driver.findElement(submit).click();
	}
	

}
