package pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCarsExtras extends BasicPage {
	private By cars = By.cssSelector("a[href=\"#Cars\"]");
	private By extras = By.cssSelector("a[href=\"https://www.phptravels.net/admin/cars/extras\"]");
	private By add = By.cssSelector(".btn.btn-success.xcrud-action");
	private By name = By.name("cHRfZXh0cmFzLmV4dHJhc190aXRsZQ--");
	private By status = By.name("cHRfZXh0cmFzLmV4dHJhc19zdGF0dXM-");
	private By price = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[4]/div/input");
	private By save = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[1]/a[1]");
	private By rows = By.cssSelector("td:nth-child(4)");
	

	public TravelsCarsExtras(WebDriver driver) {
		super(driver);

	}

	public WebElement getTCars() {
		return this.driver.findElement(cars);
	}

	public WebElement getExtras() {
		return this.driver.findElement(extras);
	}

	public WebElement getAdd() {
		return this.driver.findElement(add);
	}
	
	public WebElement getName() {
		return this.driver.findElement(name);
	}
	
	public WebElement getStatus() {
		return this.driver.findElement(status);
	}
	
	public WebElement getPrice() {
		return this.driver.findElement(price);
	}
	
	
	public WebElement getSave() {
		return this.driver.findElement(save);
	}

	
	public WebElement getRow() {
		return this.driver.findElement(rows);
	}
	
	public void iframeClose() {
        try {
            Thread.sleep(15000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return document.querySelector(\"#chat-widget-container\").remove();");
            js.executeScript("return document.querySelector(\"#livechat-eye-catcher-img > img\").remove();");}
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Nema ga");
        }
    }

}
