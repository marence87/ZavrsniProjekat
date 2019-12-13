package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TitlePage;
import pages.TravelCars;
import pages.TravelsCarsExtras;
import pages.TravelsLogin;
import pages.TravelsMenu;

public class TravelCarsTest extends BasicTest {

	private String baseUrl = "https://phptravels.net/admin";
	
	@Test (priority = 0)
	public void loginTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);

		TravelsLogin tl = new TravelsLogin(driver);

		tl.signIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertEquals(driver.getTitle(), "Dashboard");
	}
	
	

	@Test(priority = 1)
	public void carsTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getCars().click();
		tm.getCars2().click();
		Thread.sleep(2000);
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Cars Management"));
		
	}
	
	@Test(priority = 2)

	public void numOfRows() throws InterruptedException {

		TravelCars tc = new TravelCars(driver);
		Assert.assertFalse(tc.carsList().size() == 10);
	}

	
	@Test(priority = 3)

	public void numOfOrders() throws InterruptedException {

	TravelCars tc = new TravelCars(driver);
	tc.iframeClose();
	Assert.assertTrue(tc.getNumOfOrders() > 50);

	}

	
	@Test(priority = 4)
	public void basicAdd() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);

		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();
		TravelsCarsExtras tce = new TravelsCarsExtras(driver);
		tce.iframeClose();

		tm.getCars().click();
		Thread.sleep(1000);
		tm.getExtras().click();
		Thread.sleep(2000);

		tce.getAdd().click();

		Thread.sleep(2000);
		
		tce.iframeClose();

		tce.getName().sendKeys("Auto1");
		tce.getName().sendKeys(Keys.ENTER);
		
		Select select = new Select(tce.getStatus());
		select.selectByIndex(1);
		
		tce.getPrice().sendKeys("2000");
		tce.getPrice().sendKeys(Keys.ENTER);
		
		tce.getSave().click();
		Thread.sleep(2000);
		Assert.assertTrue(tce.getRow().getText().contains("Auto1"));

	}

	
	@Test(priority = 5)
	public void lettersToPrice() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);

		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();
		TravelsCarsExtras tce = new TravelsCarsExtras(driver);
		tce.iframeClose();

		tm.getCars().click();
		Thread.sleep(1000);
		tm.getExtras().click();
		Thread.sleep(2000);

		tce.getAdd().click();

		Thread.sleep(2000);
		
		tce.iframeClose();

		tce.getName().sendKeys("Auto1");
		tce.getName().sendKeys(Keys.ENTER);
		
		Select select = new Select(tce.getStatus());
		select.selectByIndex(1);
		
		tce.getPrice().sendKeys("ABC");
		tce.getPrice().sendKeys(Keys.ENTER);
		
		int result = tce.getPrice().getText().length();
		

		Assert.assertEquals(result, 0);

	}
		
	
	
	
}
