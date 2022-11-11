package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Date;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;

public class TestGoogle {

	// Las variables a utilizar son:
	private WebDriver driver;
	private static final String T_Driver = "webdriver.chrome.driver";
	// Indico la ubicacion de driver.
	private static final String Path_Driver = "./src/test/resources/webDriver/chromedriver.exe";
	// Declaracion de url base para el arranque de la prueba.
	private String UrlBase = "https://www.google.com/intl/es/gmail/about/";// U:minuscula
	// private String UrlBase =
	// "https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%26ogbl%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&ifkv=ARgdvAuYBLRMl--e7qzOZAU2JKcKNsBfv0tBaKbAeEcgT1K9W_e4cVLn0-LuZxf1ZTdb7U4NpWiN&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Inicio Test");
		System.setProperty(T_Driver, Path_Driver);
	}

	@Before
	public void setUp() {
		// Abre el navegador.
		driver = new ChromeDriver();
		// Entrar a la página de inicio de sesion de gmail.
		driver.get(UrlBase);
		driver.manage().window().maximize();
	}

	@Test
	public void RT_JULIANA_PELAEZSourch() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		esperar(3);

		String usuario1 = "pruebasautomatizacion1@gmail.com";

		driver.findElement(By.xpath("//a[contains(@data-action, 'sign in')]")).click();
		esperar(3);
		
		// Identificar el input del usuario.
		driver.findElement(By.id("identifierId")).sendKeys(usuario1);
		// Escribir correo en el input de usuario.
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();

		esperar(3);

		String contra1 = "Pruebas1";

		// Ingresar contraseña
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(contra1);
		// Hacer click para iniciar
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();

		esperar(3);
		String correo2 = "pruebasautomatizacion2@gmail.com";

		// Dar clic al boton redactar
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div/div")).click();
		// Ingresar el correo de destinatario.
		WebElement destino = driver.findElement(By.xpath("//*[@id=\":cr\"]"));
		destino.sendKeys(correo2, Keys.ENTER);

		esperar(3);

		// Redacción de asunto del correo.
		WebElement asunto = driver.findElement(By.xpath("//*[@id=\":8u\"]"));
		asunto.click();
		Date fechayhora_act = new Date();
		asunto.sendKeys("Prueba  " + fechayhora_act);

		esperar(3);

		// Redacción del cuerpo del correo.
		WebElement texto = driver.findElement(By.xpath("//*[@id=\":a1\"]"));
		texto.click();
		Faker cod = new Faker();
		int num_cod = cod.number().randomDigit();
		texto.sendKeys("Prueba Automatizada, código:  " + num_cod);

		esperar(3);

		// Enviar correo electronico
		driver.findElement(By.xpath("//*[@id=\":8k\"]")).click();

		esperar(12);

		// cerrar sesion
		WebElement cerrar = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a"));
		cerrar.click();
		;

		esperar(10);
		//Añadir otra cuenta
		WebElement cambio = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]"));
		cambio.click();

		/// Assert.assertEquals("Añadir otra cuenta", driver.getTitle());

		// driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div/div[2]/div/div/div[2]/c-wiz[2]/div/span")).click();

		esperar(6);
	}

	public static void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@After
	public void tearDown() {
		// driver.quit();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fin Test");
	}
}
