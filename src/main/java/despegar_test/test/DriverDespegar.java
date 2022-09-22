package despegar_test.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverDespegar {
	
	public static WebDriver createDriver(String driverOption) {
			
			WebDriver driver = null;
			
			switch (driverOption) {
				case "CHROME":
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\gerar\\OneDrive\\Documentos\\__VATES__\\automation\\chromedriver_win32\\chromedriver.exe"); 
					driver = new ChromeDriver();
					break;
		
				case "FIREFOX":
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\gerar\\OneDrive\\Documentos\\__VATES__\\automation\\chromedriver_win32\\geckodriver.exe"); 
					driver = new FirefoxDriver();
					break;
		
				default:
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\gerar\\OneDrive\\Documentos\\__VATES__\\automation\\chromedriver_win32\\chromedriver.exe"); 
					driver = new ChromeDriver();
					break;
			}
	
			driver.get("https://www.despegar.com.ar");
			driver.manage().window().maximize();
			return driver;
		}

}
