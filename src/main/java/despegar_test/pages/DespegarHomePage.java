package despegar_test.pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarHomePage {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css="a.HOTELS")
	WebElement alojamientos;
	
	//para pasar a la resultpage
	@FindBy(css="#searchbox-sbox-box-hotels .sbox5-box-places-ovr.sbox-places-container--3kBK7  "
			   + "input.input-tag")
	WebElement inputDestino;
	
	@FindBy(css="span.item-text")
	WebElement listaDestino;
	
	@FindBy(xpath="//*[@id='searchbox-sbox-box-hotels']//*[@class='sbox5-dates-input1-container']"
			    + "//*[@class='sbox5-3-input sbox5-3-validation -top-right -lg -icon-left']")
	WebElement calendar;
	
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']"
			    + "//*[@data-month='2022-09']//*[text()=29]")
	WebElement primerFecha;
	
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']"
			    + "//*[@data-month='2022-09']//*[text()=30]")
	WebElement segundaFecha;
	
	@FindBy(css=".sbox5-floating-tooltip-opened .sbox5-3-btn .btn-text")
	WebElement clickAplicar;
	
	@FindBy(id="svg-bed-3xwvNFB")
	WebElement clickBed;
	
	@FindBy(css=".stepper__room")
	WebElement rooms;
	
	@FindBy(css=".stepper__room  button.steppers-icon-right")
	WebElement cantAdultos;
	
	@FindBy(css=".stepper__room > div.stepper__distribution_container > "
			  + "div:nth-child(2) button.steppers-icon-right")
	WebElement cantNinos;
	
	@FindBy(css="select.select")
	WebElement selEdad;
	
	@FindBy(css=".sbox5-floating-tooltip-opened a.sbox5-3-btn")
	WebElement clickAplicarRoom;
	
	@FindBy(css=".sbox5-box-content > button")
	WebElement clickBtnBuscar;
	
	public DespegarHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}

	public void clickalojamientos() {
		alojamientos.click();
	}
	
	public void inputDestinos (String text) {
		wait.until(ExpectedConditions.visibilityOf(inputDestino));
		this.inputDestino.click();
		this.inputDestino.clear();
		this.inputDestino.sendKeys(text);
		wait.until(ExpectedConditions.elementToBeClickable(listaDestino));
		this.listaDestino.click();
	}
	
	public void inputFechas() {
		this.calendar.click();
		wait.until(ExpectedConditions.visibilityOf(calendar));
		this.primerFecha.click();
		this.segundaFecha.click();
		this.clickAplicar.click();
	}
	
	public void inputHabitaciones() {
		this.clickBed.click();
		wait.until(ExpectedConditions.visibilityOf(rooms));
		this.cantAdultos.click();
		this.cantNinos.click();
		Select drpSelect = new Select (selEdad);
		drpSelect.selectByValue("2");
		this.clickAplicarRoom.click();
	}

	public DespegarResultsPage clickBtn() {
		this.clickBtnBuscar.click();
		return new DespegarResultsPage(this.driver);
	}

}//end class DespegarHome
