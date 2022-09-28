package despegar_test.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarResultsPage {
	
	String titulo = null;
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(xpath="//*[@class='cluster-description cluster-description-top']"
		    + "//span[@class='accommodation-name -eva-3-ellipsis']")
	List<WebElement> listaTitle;

	public DespegarResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	public String getTitle() {
		for(WebElement title : listaTitle) {
			wait.until(ExpectedConditions.visibilityOf(title));
			if (title.getText().contains("Hotel")) {
				titulo = title.getText();
				break;
			}
		}
		return titulo;
	}
}
