package pages;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	WebDriver driver = null;
	
	//All field elements
	@FindBy(name = "company") WebElement companyName;
	@FindBy(name = "firstname") WebElement firstName;
	@FindBy(name = "lastname") WebElement lastName;
	@FindBy(name = "email") WebElement email;
	@FindBy(name = "country") WebElement country;
	@FindBy(name = "phone") WebElement phoneNumber;
	@FindBy(name = "enquiry_details") WebElement enquiryDetails;
	@FindBy(name = "product_family") WebElement productFamily;
	@FindBy(name = "i_agree_to_intelligencebank_s_terms_and_conditions") WebElement agree;
	
	//Warning text elements
	@FindBy(css = "fieldset.form-columns-1:nth-child(1) > div:nth-child(1) > ul:nth-child(4) > li:nth-child(1) > label:nth-child(1)") WebElement companyNameRequired;
	@FindBy(css = "fieldset.form-columns-2:nth-child(2) > div:nth-child(1) > ul:nth-child(4) > li:nth-child(1) > label:nth-child(1)") WebElement firstNameRequired;
	@FindBy(css = "fieldset:nth-child(3) > div:nth-child(1) > ul:nth-child(4) > li:nth-child(1) > label:nth-child(1)") WebElement emailValidation;
	@FindBy(css = ".hs_phone > ul:nth-child(4) > li:nth-child(1) > label:nth-child(1)") WebElement phoneNumberLengthValidation;
	@FindBy(css = ".hs_phone > ul:nth-child(4) > li:nth-child(2) > label:nth-child(1)") WebElement phoneNumberCharacterValidation;
			
			

	public enum errorPromptName {
		COMPANY_NAME_MISSING, FIRST_NAME_MISSING, EMAIL_VALIDATION, PHONE_NUMBER_LENGTH, PHONE_NUMBER_CHAR
	}
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100),this);
	}

	
	public void fillInContactUsForm(JSONObject obj){
		companyName.sendKeys(obj.getString("CompanyName"));
		firstName.sendKeys(obj.getString("FirstName"));
		lastName.sendKeys(obj.getString("LastName"));
		email.sendKeys(obj.getString("Email"));
		new Select(country).selectByVisibleText(obj.getString("Country"));
		phoneNumber.sendKeys(obj.getString("PhoneNumber"));
		enquiryDetails.sendKeys(obj.getString("EnquiryDetails"));
		new Select(productFamily).selectByVisibleText(obj.getString("ProductFamily"));
		if (obj.getBoolean("Agree")) {
			agree.click();
		}
	}
	
	public String getWarningText(errorPromptName errorName){
		switch (errorName){
			case COMPANY_NAME_MISSING:
				return companyNameRequired.getText();
			case FIRST_NAME_MISSING:
				return firstNameRequired.getText();
			case EMAIL_VALIDATION:
				return emailValidation.getText();
			case PHONE_NUMBER_LENGTH:
				return phoneNumberLengthValidation.getText();
			case PHONE_NUMBER_CHAR:
				return phoneNumberCharacterValidation.getText();
			default:
				return null;
		}
	}
	
	
	//not used, for further testing
//	public void clickSubmit(){
//		driver.findElement(submitElement).click();
//	}
	

}
