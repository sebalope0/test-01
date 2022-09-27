package despegar_test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static void goToMainPage(WebDriver driver) {
		driver.get("https://www.despegar.com.ar");
	}
	
	public static WebDriver createDriver(String driverOption) {
			
			WebDriver driver = null;
			
			switch (driverOption) {
				case "CHROME":
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\gerar\\OneDrive\\Documentos\\__VATES__\\automation\\chromedriver_win32\\chromedriver.exe"); 
					driver = new ChromeDriver();
					break;

				case "FIREFOX":
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\gerar\\OneDrive\\Documentos\\__VATES__\\automation\\geckodriver\\geckodriver.exe"); 
					driver = new FirefoxDriver();
					break;

				default:
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\gerar\\OneDrive\\Documentos\\__VATES__\\automation\\chromedriver_win32\\chromedriver.exe"); 
					driver = new ChromeDriver();
					break;
			}

			driver.manage().window().maximize();
			return driver;
		}

}
