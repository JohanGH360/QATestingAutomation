package com.trainigqa;


/**
* Hello world!
*
*/


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
public class AppTest {

//Login
By userNameLocator = By.id("username");
By passwordLocator = By.id("password");
By submitButton = By.id("Login");

//Buscar Contact
By buttonApplauncher = By.xpath("//button[@aria-haspopup='dialog' and @title='App Launcher']");
By searchWrite = By.xpath("//input[@placeholder='Search apps and items...']");
By buttonContact = By.xpath("//*[@id=\"Contact\"]/div/lightning-formatted-rich-text/span/p/b");

//Crear un nuevo Contacto
By newContact = By.xpath("//button[@name='NewContact' and @type='button']");
By buttonNext = By.xpath("//button[@class='slds-button slds-button_neutral slds-button slds-button_brand uiButton' and @data-aura-class='uiButton']");

//Registro del Contact
By nombreContact = By.xpath("//input[@name='lastName' and @placeholder='Last Name']");
By searchAccount = By.xpath("//input[@placeholder='Search Accounts...']");
By searchAccountExist = By.xpath("//lightning-base-combobox-formatted-text[@title='kevin Test']");
By saveNewContact = By.xpath("//button[@class='slds-button slds-button_brand' and @name='SaveEdit']");

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
public void test() throws InterruptedException{
    //Login
    driver.findElement(userNameLocator).sendKeys("kevin191203@qa.test.com");
    driver.findElement(passwordLocator).sendKeys("diego191203");
    Thread.sleep(5000);
    driver.findElement(submitButton).click();
    Thread.sleep(5000);

    //Dentro de la org

    //Buscar Contacts
    driver.findElement(buttonApplauncher).click();
    Thread.sleep(5000);
    driver.findElement(searchWrite).sendKeys("Contacts");
    Thread.sleep(5000); 
    driver.findElement(buttonContact).click();
    Thread.sleep(5000); 

    //Crear un nuevo contacto
    driver.findElement(newContact).click();
    Thread.sleep(5000);
    driver.findElement(buttonNext).click();
    Thread.sleep(5000);
    
    //Registro
    driver.findElement(nombreContact).sendKeys("Diego");
    Thread.sleep(5000); 
    driver.findElement(searchAccount).sendKeys("kevin");
    Thread.sleep(5000); 
    driver.findElement(searchAccountExist).click();
    Thread.sleep(5000);
    driver.findElement(saveNewContact).click();
    Thread.sleep(5000);
}
}
