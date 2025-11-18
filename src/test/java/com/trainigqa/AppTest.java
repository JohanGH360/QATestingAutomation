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
	
	By userNameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By submitButton = By.id("Login");
	By buttonNavMenu = By.xpath("//button[@aria-label='Show Navigation Menu']");
	By solicitudesServicios = By.xpath("//a[@href='/lightning/o/Solicitud_de_Servicio__c/home']");
	By newSolicitud = By.xpath("//a[@title='New']");
	By nombreSolicitud = By.xpath("//input[@name='Name']");
	By clienteRelacionado = By.xpath("//input[@placeholder='Search Contacts...']");
	By confirmFormularioSolicitud = By.xpath("//h2[@class='header slds-modal__title slds-hyphenate slds-text-heading_medium']");
	By guardarButton = By.xpath("//button[@name='SaveEdit']");
	
	
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("URL de su org ");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException{
		
		driver.findElement(userNameLocator).sendKeys("Su usuario");
		driver.findElement(passwordLocator).sendKeys("Su contraseña");
		driver.findElement(submitButton).click();
		Thread.sleep(2000);
		driver.findElement(buttonNavMenu).click();
		Thread.sleep(2000);
		driver.findElement(solicitudesServicios).click();
		Thread.sleep(2000);
		driver.findElement(newSolicitud).click();
		Thread.sleep(2000); 
		if (driver.findElement(confirmFormularioSolicitud).isDisplayed()) {
			System.out.println("Si se encontro el elemento");
			driver.findElement(nombreSolicitud).sendKeys("Prueba2");
			driver.findElement(clienteRelacionado).sendKeys("Maria Clifton");
			Thread.sleep(2000);
			driver.findElement(guardarButton).click();
		}else {
			System.out.println("No se puede validar que estes creando una nueva solicitud de servicio");
		}
	}
}
