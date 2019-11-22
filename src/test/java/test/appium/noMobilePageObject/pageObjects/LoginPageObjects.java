package test.appium.noMobilePageObject.pageObjects;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class LoginPageObjects extends PageObject{
	
	public DesiredCapabilities dc = new DesiredCapabilities();
	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    String edtUsuario = "com.experitest.ExperiBank:id/usernameTextField";
    String edtContrasena = "com.experitest.ExperiBank:id/passwordTextField";
    String btnIngresar = "com.experitest.ExperiBank:id/loginButton";
    String btnPagos = "com.experitest.ExperiBank:id/makePaymentButton";
    String txtSaldo = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View\r\n";
    
    String btnRealizarPago = "com.experitest.ExperiBank:id/makePaymentButton";
    String edtTelefono = "com.experitest.ExperiBank:id/phoneTextField";
    String edtNombre = "com.experitest.ExperiBank:id/nameTextField";
    String edtValor = "com.experitest.ExperiBank:id/amountTextField";
    String btnBuscarPais = "com.experitest.ExperiBank:id/countryButton"; 
    String btnPais = "//android.widget.ListView/android.widget.TextView[@text = \"Colombia\"]";
    		
	public void iniciarApp() throws MalformedURLException {
		dc.setCapability("deviceName", "Xiaomi Mi5");
        dc.setCapability("udid", "d728d2a97cf5");
        dc.setCapability("automationName", "uiautomator2");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "8.1.0");
        dc.setCapability("app", "C:\\Users\\DAVID\\Desktop\\ExperiBank.apk");
        dc.setCapability("skipUnlock","true");
        dc.setCapability("appPackage", "com.experitest.ExperiBank");
        dc.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
        dc.setCapability("noReset","false");
        this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        this.wait = new WebDriverWait(driver, 10);
	}

	public void ingresarUsuario(String usuario) {
		driver.findElement(By.id(this.edtUsuario)).sendKeys(usuario);		
	}

	public void ingresarContrasena(String contrasena) {
		driver.findElement(By.id(this.edtContrasena)).sendKeys(contrasena);
		
	}

	public void darClicEnBotonIngresar() {
		driver.findElement(By.id(this.btnIngresar)).click();
		
	}

	public void validarMensajeSaldo(String mensaje) {
		
		MobileElement mensajeSaldo = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtSaldo)));
		String mensajeAValidar = mensajeSaldo.getText().toString();
		System.out.println("mensaje: "+mensajeAValidar+" mensaje feature: "+mensaje);
		assertTrue(mensajeAValidar.contains(mensaje));
	}

	public void darClicEnMakePayment() {
		MobileElement btnRealizarPago =(MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnRealizarPago)));
		btnRealizarPago.click();
	}

	public void ingresarNumeroTelefonico(String numero) {
		MobileElement btnTelefono = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.edtTelefono)));
		btnTelefono.sendKeys(numero);
		
	}

	public void ingresarNombre(String nombre) {
		driver.findElement(By.id(this.edtNombre)).sendKeys(nombre);
		
	}

	public void ingresarValorPago(String cantidad) {
		driver.findElement(By.id(this.edtValor)).sendKeys(cantidad);
		
	}

	public void darClicEnBuscarPais() {
		driver.findElement(By.id(this.btnBuscarPais)).click();
		
	}

	@SuppressWarnings("rawtypes")
	public void SeleccionarPais(String pais) {
		waitFor(4).seconds();
		Dimension size = driver.manage().window().getSize();
		int startY = (int) (size.height*0.8);
		int endY = (int) (size.height*0.2);
		int pointX = (int) (size.width*0.5);
		System.out.println("x: "+pointX+" y1: "+startY+" y2: "+endY+" aqui estamos");
		TouchAction ta = new TouchAction((PerformsTouchActions) driver);
		ta.press(PointOption.point(pointX, startY)).waitAction().moveTo(PointOption.point(pointX, endY)).release().perform();
		driver.quit();
	}
	
	
}
