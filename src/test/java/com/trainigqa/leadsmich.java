package com.trainigqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class leadsmich {

    By userNameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By submitButton = By.id("Login");

    //Para buscar boton de app launcher
    By waffleButton = By.xpath("//button[@aria-haspopup='dialog' and @title='App Launcher']");
    By waffleText = By.xpath("//input[@placeholder='Search apps and items...']"); //crear xpath manual buscando valores por id y placeholder 
    By waffleLeads = By.xpath("//*[@id=\"Lead\"]/div/lightning-formatted-rich-text/span/p/b");
    By newButton = By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[3]/div/div/lst-object-home/div/lst-list-view-manager/lst-common-list-internal/lst-list-view-manager-header/div/div[1]/div[3]/div/ul/li[1]");
    By nextButton = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/button[2]");
    By lastName = By.xpath("//*[@placeholder= 'Last Name']");
    By saveButton = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/records-form-footer/div/div[2]/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button");




                     

    private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trailsignup-1b27d308d4f19f.my.salesforce.com");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException{
		
		driver.findElement(userNameLocator).sendKeys("marizmendi@pocs-mex-oct.com");
		driver.findElement(passwordLocator).sendKeys("Lwymmd13");
		driver.findElement(submitButton).click();
        Thread.sleep(10000);
        driver.findElement(waffleButton).click();
        Thread.sleep(2000);
        driver.findElement(waffleText).sendKeys("Leads");
        Thread.sleep(4000);
        driver.findElement(waffleLeads).click();
        Thread.sleep(4000);
        driver.findElement(newButton).click();
        Thread.sleep(4000);
        driver.findElement(nextButton).click();
        Thread.sleep(4000);
        driver.findElement(lastName).sendKeys("Prueba Michel destructor de universos");
        Thread.sleep(2000);
        driver.findElement(saveButton).click();
	}
}
