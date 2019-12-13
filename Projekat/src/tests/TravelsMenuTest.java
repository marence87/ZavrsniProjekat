package tests;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TitlePage;
import pages.TravelCustomer;
import pages.TravelsLogin;
import pages.TravelsMenu;

public class TravelsMenuTest extends BasicTest {
	private String baseUrl = "https://phptravels.net/admin";
	
	@Test(priority = 01)
	public void basicLogin() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);		
		
		
		
		File file = new File("Username.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		String username = sheet.getRow(1).getCell(0).getStringCellValue();
		String password = sheet.getRow(1).getCell(1).getStringCellValue();
		
		TravelsLogin tl = new TravelsLogin(driver);
		tl.signIn(username, password);
		wb.close();
		
		Thread.sleep(1000);
		
		TitlePage tp = new TitlePage(driver);		
		Assert.assertTrue(tp.getPageTitle().contains("Dashboard"));	
		}
	


	@Test(priority = 1)
	public void updateTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getUpdates().click();
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Updates"));
		
	}
	
	@Test(priority = 2)
	public void modulesTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getModules().click();
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Modules"));
		
	}
	
	@Test(priority = 3)
	public void toursTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getTours().click();
		Thread.sleep(1000);
		tm.getAddNew().click();
		Thread.sleep(1000);
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Add Tour"));
		
	}
	
	
	@Test(priority = 4)
	public void carsTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getCars().click();
		tm.getCars2().click();
		Thread.sleep(1000);
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Cars Management"));
		
	}
	
	
	@Test(priority = 5)
	public void couponsTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getCoupons().click();
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Coupon Codes Management"));
		
	}
	
	@Test(priority = 6)
	public void newsletterTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getNewsletter().click();
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Newsletter Management"));
		
	}
	
	@Test(priority = 7)
	public void bookingsTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getBookings().click();
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Booking Management"));
		
	}
	
	
	@Test(priority = 8)
	public void customersTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getAccounts().click();
		Thread.sleep(1000);
		tm.getCustomers().click();
		Thread.sleep(1000);
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Customers Management"));
		
	}
	
	@Test(priority = 9)
	public void editCustomersTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		TravelsMenu tm = new TravelsMenu(driver);
		tm.iframeClose();

		tm.getAccounts().click();
		Thread.sleep(1000);
		tm.getCustomers().click();
		Thread.sleep(1000);
		
		TravelCustomer tc = new TravelCustomer(driver);

		tc.getEdit().click();
		Thread.sleep(1000);
		
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Update Customer"));
		
	}
	
	
}
