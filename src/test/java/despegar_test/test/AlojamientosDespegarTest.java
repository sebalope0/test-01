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
	DespegarHomePage cbaHomePage = null;

  @BeforeMethod
  public void setup(ITestContext context) {
	  String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
      String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
	  driver = DriverFactory.createDriver(navegador);
	  DriverFactory.goToMainPage(driver);
	  homePage = new DespegarHomePage(this.driver);
  }//end BeforeMethod
 
  @DataProvider(name = "Alojamientos")
  public Object[][] dpMethod() {
	  return new Object[][]{{"Men"},{"Cord"}};
  }
 
  @Test(dataProvider = "Alojamientos", description = "Verificar que las busquedas de alojamiento funcionan")
  public void VerificarAlojamientoDespegar(String provincia) throws Exception  {
	  homePage.assertLinks();
	  homePage.clickalojamientos();
	  homePage.inputDestinos(provincia);
	  homePage.inputFechas();
	  homePage.inputHabitaciones();
	  DespegarResultsPage resultsPage = homePage.clickBtn();
	  Assert.assertTrue(resultsPage.getTitle().contains("Hotel"), "No se encontro 'Hotel'");
	  System.out.println("El Primer Hotel encontrado es: " + resultsPage.getTitle() + " en " + provincia);
  }//end Test

  @AfterMethod
  public void endSetup() {
	  driver.close();
  }//end AfterMethod
 
}//end class AlojamientosDespegarTest