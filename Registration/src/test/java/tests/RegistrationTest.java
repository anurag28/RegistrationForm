package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.RegistrationPage;
import steps.RegistrationSteps;
import utils.ConfigReader;
import utils.TestSessionInitiator;
import utils.YamlReader;

public class RegistrationTest{
	
	WebDriver driver;
	RegistrationPage registrationPage;
	RegistrationSteps registrationSteps;
	String yamlFilePath = System.getProperty("user.dir") + File.separator + "src/test/java/testdata/registration_form.yml";
	TestSessionInitiator test;
	
	
@BeforeTest
public void beforeTest() throws FileNotFoundException, IOException {
	test = new TestSessionInitiator();
	driver = test.getDriver();	
	registrationSteps = new RegistrationSteps(driver);
	registrationPage = new RegistrationPage(driver);
	YamlReader.setYamlFilePath(yamlFilePath);
	driver.get(ConfigReader.getUrl());
}

@Test
public void tc01_validateClearButton() {
	registrationPage.typeName(YamlReader.getYamlValue("valid_registration_form_data.name"));
	Assert.assertEquals(registrationPage.getNameFieldValue(), YamlReader.getYamlValue("valid_registration_form_data.name"));
	registrationPage.clickClear();
	registrationPage.acceptAlert();
	Assert.assertEquals(registrationPage.getNameFieldValue(), "");
}

@Test
public void tc02_validateInvalidEmailValidationMsg() {
	registrationSteps.fillRegistrationForm(YamlReader.getYamlValue("valid_registration_form_data.name"), 
			YamlReader.getYamlValue("valid_registration_form_data.phone_number"), 
			YamlReader.getYamlValue("invalid_email"), 
			YamlReader.getYamlValue("valid_registration_form_data.user_id"), 
			YamlReader.getYamlValue("valid_registration_form_data.password"));
	registrationPage.clickSubmit();
	Assert.assertEquals(registrationPage.getInvalidEmailValidationMsg(), 
			YamlReader.getYamlValue("invalid_email_validation_msg"));
}

@Test
public void tc03_validatePasswordFieldIsMasked() {
	Assert.assertEquals(registrationPage.isPasswordFieldtypeDisplayed(), true);
}

@Test
public void tc04_validateSuccessMessageForValidForm() {
	
	registrationSteps.fillRegistrationForm(YamlReader.getYamlValue("valid_registration_form_data.name"), 
			YamlReader.getYamlValue("valid_registration_form_data.phone_number"), 
			YamlReader.getYamlValue("valid_registration_form_data.email_address"), 
			YamlReader.getYamlValue("valid_registration_form_data.user_id"), 
			YamlReader.getYamlValue("valid_registration_form_data.password"));
	registrationPage.clickSubmit();
	Assert.assertEquals(registrationPage.getAlertText(), 
			YamlReader.getYamlValue("valid_registration_form_data.success_msg"));
}

@AfterTest
public void afterTest() {
	driver.quit();
}
}
