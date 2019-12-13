package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsLogin extends BasicPage {

	private By email = By.name("email");
	private By password = By.name("password");
	private By remember = By.className("checkbox");
	private By forget = By.cssSelector(".forget-password.text-right");
	private By login = By.cssSelector(".btn.btn-primary.btn-block.ladda-button.fadeIn.animated.btn-lg");

	public TravelsLogin(WebDriver driver) {
		super(driver);

	}

	public void setEmail(String email) {
		this.driver.findElement(this.email).sendKeys(email);
	}
	
	public void setPassword(String password) {
		this.driver.findElement(this.password).sendKeys(password);
	}
	

	
	public void clickOnLoginBtn() {
		this.driver.findElement(this.login).click();
	}
	
	public void signIn(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
		this.getRemember().click();
		this.clickOnLoginBtn();
	}

	public WebElement getRemember() {
		return this.driver.findElement(remember);
	}

	public WebElement getForget() {
		return this.driver.findElement(forget);
	}
	


}
