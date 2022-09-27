package despegar_test.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import despegar_test.driver.DriverFactory;
import despegar_test.pages.DespegarHomePage;
import despegar_test.pages.DespegarResultsPage;

public class AlojamientosDespegarTest {
	
	WebDriver driver = null;
	DespegarHomePage homePage = null;
	
  @BeforeMethod
  public void setup(ITestContext context) {
	  String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
      String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
	  driver = DriverFactory.createDriver(navegador);
	  DriverFactory.goToMainPage(driver);
	  homePage = new DespegarHomePage(this.driver);
  }//end BeforeMethod
  
  @Test(description = "Verificar que las busquedas de alojamiento funcionan")
  public void VerificarAlojamientoDespegar() throws Exception  {
	  homePage.clickalojamientos();
	  homePage.inputDestinos("Mendoza");
	  homePage.inputFechas();
	  homePage.inputHabitaciones();
	  DespegarResultsPage resultsPage = homePage.clickBtn();
	  Assert.assertTrue(resultsPage.getTitle().contains("Hotel"), "No se encontro 'Hotel'");
	  System.out.println("El nombre del alojamiento " + resultsPage.getTitle());
  }//end Test
  
  @AfterMethod
  public void endSetup() {
	  driver.close();
  }//end AfterMethod
  
}//end class AlojamientosDespegarTest