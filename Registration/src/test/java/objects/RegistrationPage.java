package objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By nameField = By.id("name");
	By phoneNumberField = By.cssSelector("#phoneNumber");
	By emailAddressField = By.id("email");
	By userIdField = By.name("userID");
	By passwordField = By.xpath("//input[@type='password']");
	By submitBtn = By.xpath("//button[@type='submit']");
	By cancelbtn = By.xpath("//button[text()='Cancel']");
	By clearBtn = By.xpath("//*[text()='Clear']");
	
	public void typeName(String name) {
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(name);
	}

	public void typePhoneNumber(String phoneNumber) {
		driver.findElement(phoneNumberField).clear();
		driver.findElement(phoneNumberField).sendKeys(phoneNumber);
	}

	public void typeEmailAddress(String emailAdress) {
		driver.findElement(emailAddressField).clear();
		driver.findElement(emailAddressField).sendKeys(emailAdress);
	}

	public void typeUserId(String userId) {
		driver.findElement(userIdField).clear();
		driver.findElement(userIdField).sendKeys(userId);
	}

	public void typePassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickSubmit() {
		driver.findElement(submitBtn).click();
	}
	
	public void clickCancel() {
		driver.findElement(cancelbtn).click();
	}
	
	public void clickClear() {
		driver.findElement(clearBtn).click();
	}
	
	public String getNameFieldValue() {
		return driver.findElement(nameField).getAttribute("value");
	}
	
	public boolean isPasswordFieldtypeDisplayed() {
		return driver.findElement(passwordField).isDisplayed();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public String getInvalidEmailValidationMsg() {
		return driver.findElement(emailAddressField).getAttribute("validationMessage");
	}
}
