package tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TitlePage;
import pages.TravelsLogin;

public class TravelsLoginTest extends BasicTest {
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




}
