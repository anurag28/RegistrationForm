package steps;

import org.openqa.selenium.WebDriver;

import objects.RegistrationPage;

public class RegistrationSteps {
	RegistrationPage registrationPage;
	
	public RegistrationSteps(WebDriver driver) {
		registrationPage = new RegistrationPage(driver);
	}
	
	public void fillRegistrationForm(String name, String phoneNumber, String emailAddress, String userId, String password) {
		registrationPage.typeName(name);
		registrationPage.typePhoneNumber(phoneNumber);
		registrationPage.typeEmailAddress(emailAddress);
		registrationPage.typeUserId(userId);
		registrationPage.typePassword(password);
	}

}
