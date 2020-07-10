package testData;

import org.json.JSONObject;
import org.openqa.selenium.By;

public class ContactUsFormTestData {

	public static By targetArea = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div/div[2]");
	public static String screenshotFileName = "contactUsFormScreenshot";
	public static String missingRequiredScreenshotFileName = "contactUsFormMissingRequiredScreenshot";
	public static String formatValidationScreenshotFileName = "contactUsFormDataFormatValidationScreenshot";
	public static String missingRequiredWarning = "Please complete this required field.";
	public static String emailFormatWarning = "Email must be formatted correctly.";
	public static String phoneNumberLengthWarning = "Please enter a phone number that's at least 7 numbers long.";
	public static String phoneNumberCharacterWarning = "Must contain only numbers, +()-. and x.";

	public static JSONObject fillFormJson() {
		
		JSONObject obj = new JSONObject();
		
		obj.put("CompanyName", "NAB");
		obj.put("FirstName", "Yuki");
		obj.put("LastName", "Feng");
		obj.put("Email", "yuki.jia.feng@gmail.com");
		obj.put("Country", "Australia");
		obj.put("PhoneNumber", "0481350859");
		obj.put("EnquiryDetails", "This is just a testing");
		obj.put("ProductFamily", "Digital Asset Management");
		obj.put("Agree", true);
		
		return obj;
	}
	
	public static JSONObject fillFormJsonMissingRequired() {
		
		JSONObject obj = new JSONObject();
		
		obj.put("CompanyName", " ");
		obj.put("FirstName", " ");
		obj.put("LastName", " ");
		obj.put("Email", " ");
		obj.put("Country", "Australia");
		obj.put("PhoneNumber", "");
		obj.put("EnquiryDetails", "This is a testing for missing required field");
		obj.put("ProductFamily", "Digital Asset Management");
		obj.put("Agree", false);
		
		return obj;
	}
	
	public static JSONObject fillFormJsonSpecialFieldsValidation() {
		
		JSONObject obj = new JSONObject();
		
		obj.put("CompanyName", "NAB");
		obj.put("FirstName", "Yuki");
		obj.put("LastName", "Feng");
		obj.put("Email", "yukifengau");
		obj.put("Country", "Australia");
		obj.put("PhoneNumber", "abc");
		obj.put("EnquiryDetails", "This is a testing for format validation");
		obj.put("ProductFamily", "Digital Asset Management");
		obj.put("Agree", false);
		
		return obj;
	}
	

}
