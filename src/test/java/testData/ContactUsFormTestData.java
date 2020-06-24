package testData;

import org.json.JSONObject;

public class ContactUsFormTestData {


	public static JSONObject contactUsFormJsonTestData() {
		
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
	

}
