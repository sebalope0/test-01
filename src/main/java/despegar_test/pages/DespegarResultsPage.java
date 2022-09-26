package despegar_test.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarResultsPage {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css=".cluster-description.cluster-description-top")
	WebElement fstResult;
	
	public DespegarResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	public DespegarHotelPage clickfstResult() {
		this.wait.until(ExpectedConditions.elementToBeClickable(fstResult));
		fstResult.click();
		return new DespegarHotelPage(this.driver);
	}
	
}
