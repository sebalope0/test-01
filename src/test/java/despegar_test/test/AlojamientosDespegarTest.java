package despegar_test.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import despegar_test.driver.DriverFactory;
import despegar_test.pages.DespegarHomePage;
import despegar_test.pages.DespegarResultsPage;

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
	  Assert.assertTrue(resultsPage.getTitle().contains("Hotel"), "No se encontro 'Hotel'");
	  System.out.println("El nombre del alojamiento " + resultsPage.getTitle());
	  this.driver.close();
  }
}
