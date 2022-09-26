package despegar_test.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import despegar_test.driver.DriverFactory;
import despegar_test.pages.DespegarHomePage;
import despegar_test.pages.DespegarHotelPage;
import despegar_test.pages.DespegarResultsPage;

//import despegar_test.test.DriverDespegar;

public class AlojamientosDespegarTest {
	
	WebDriver driver = null;
	DespegarHomePage homePage = null;
	
	
  @Test(description = "Verificar que las busquedas de alojamiento funcionan")
  public void VerificarAlojamientoDespegar() throws Exception  {
	  
	  this.driver = DriverFactory.createDriver("CHROME");
	  homePage = new DespegarHomePage(this.driver);
	  homePage.clickalojamientos();
	  homePage.inputDestinos("Mendoza, Mendoza, Argentina");
	  homePage.inputFechas();
	  homePage.inputHabitaciones();
	  DespegarResultsPage resultsPage = homePage.clickBtn();
	  DespegarHotelPage hotelPage = resultsPage.clickfstResult();
	  Assert.assertTrue(hotelPage.getTitle().contains("Mendoza, Argentina."), "El titulo no contenia el texto 'Mendoza, Argentina.'");
	  //this.driver.close();
  }
}
