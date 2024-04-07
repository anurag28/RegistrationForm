package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.RegistrationPage;
import utils.ConfigReader;

public class RegistrationTest extends ConfigReader{
	
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	RegistrationPage registration;
	
	
@BeforeTest
public void beforeTest() throws FileNotFoundException, IOException {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	String url = config.getUrl();
	
	driver.get(url);
		
}

@Test
public void validateSuccessMessageForValidForm() {
	registration = new RegistrationPage(driver);
	registration.typeName("John Doe");
	registration.typePhoneNumber("0987654321");
	registration.typeEmailAddress("johnd@test.com");
	registration.typeUserId("jdoe123");
	registration.typePassword("jDoe@123");
	registration.clickSubmit();
	Assert.assertEquals(registration.getAlertText(), "Form submitted successfully!");
}

@AfterTest
public void afterTest() {
	driver.quit();
}
}
