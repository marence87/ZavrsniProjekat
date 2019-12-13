package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelCars extends BasicPage {
	
	private By table = By.className("xcrud-row");
	private By upload = By.cssSelector("a[href=\"https://www.phptravels.net/admin/cars/gallery/chennai\"]");

	public TravelCars(WebDriver driver) {
		super(driver);
	}
	

	public List<WebElement> getRow() {
		return this.driver.findElements(this.table);
	}


	public int numOfRows() {
	return this.getRow().size();

	}

	public List<WebElement> carsList() {

		List<WebElement> carNames = new ArrayList<WebElement>();

		for (int i = 0; i < this.numOfRows(); i++) {
			WebElement name = this.getRow().get(i).findElements(By.tagName("td")).get(4);
			carNames.add(name);
		}
		return carNames;
	}

	public int getNumOfOrders() {

		int sum = 0;

		for (int i = 0; i < this.numOfRows(); i++) {

			WebElement orderNum = this.getRow().get(i).findElements(By.tagName("td")).get(9);
			sum += Integer.parseInt(orderNum.findElement(By.tagName("input")).getAttribute("value"));
		}
		return sum;
	}
	
	public WebElement addImage(){
		return this.driver.findElement(upload);
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
