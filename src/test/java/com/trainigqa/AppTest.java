package com.trainigqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    //LOGIN
    By userNameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By submitButton = By.id("Login");
    //1 App Launcher
    By appLauncher = By.xpath("//button//div[@class='slds-icon-waffle']"); 
    //2 Barra de Búsqueda
    By searchBar = By.xpath("//input[@placeholder='Search apps and items...']");
    //3 Opción Accounts
    By accountsResult = By.xpath("//*[@id=\"Account\"]/div/lightning-formatted-rich-text/span/p/b");
    //4 Botón New
    By newButton = By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[3]/div/div/div/div[1]/div/div[2]/div/div/div/runtime_pipeline_inspector-actions-button-group/lightning-button-group/div/slot/lightning-button[1]/button"); 
    //5 Botón New
    By nextButton = By.xpath("//*[@id=\"content_822:0\"]/div/div/div[2]/div/button[2]/span");
	//6 Input Account name
	By accountNameInput = By.xpath("//input[@name='Name']");
	//7 Guardar
    By saveButton = By.xpath("//button[@name='SaveEdit']");
    
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trailsignup-1b27d308d4f19f.my.salesforce.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit(); 
    }

    @Test
    public void testCreateAccount() throws InterruptedException{
        
        // --- LOGIN ---
        driver.findElement(userNameLocator).sendKeys("cristianaxel2003@qa.test.com");
        driver.findElement(passwordLocator).sendKeys("ZlF946rZL8b$");
        driver.findElement(submitButton).click(); 
		Thread.sleep(5000);       

        // --- FLUJO DE CREACIÓN ---
        //Paso 1
        System.out.println("Abriendo App Launcher...");
        driver.findElement(appLauncher).click();
        Thread.sleep(3000); 

        //Paso 2
        System.out.println("Buscando 'Accounts'...");
        driver.findElement(searchBar).sendKeys("Accounts");
        Thread.sleep(2000); 

        //Paso 3
        System.out.println("Seleccionando resultado...");
        driver.findElement(accountsResult).click();
        Thread.sleep(5000); 

        //Paso 4
        System.out.println("Click en botón New...");
        driver.findElement(newButton).click();
        Thread.sleep(3000); 

        //Paso 5
        System.out.println("Click en botón Next...");
        driver.findElement(nextButton).click();
        Thread.sleep(3000); 

		//Paso 6
		if(driver.findElement(accountNameInput).isDisplayed()){
            System.out.println("Escribiendo nombre...");
            driver.findElement(accountNameInput).sendKeys("UserTest001");
            Thread.sleep(1000);
            
            //Paso 7
            System.out.println("Guardando...");
            driver.findElement(saveButton).click();
            Thread.sleep(4000);
            System.out.println("¡ÉXITO! Script completado.");
        } else {
            System.out.println("ERROR: No se abrió el modal.");
        }
    }
}