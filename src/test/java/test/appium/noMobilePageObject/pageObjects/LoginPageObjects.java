package test.appium.noMobilePageObject.pageObjects;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
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
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        wait = new WebDriverWait(driver, 10);		
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
		waitFor(4).seconds();
		MobileElement mensajeSaldo = driver.findElement(By.xpath(this.txtSaldo));
		String mensajeAValidar = mensajeSaldo.getText().toString();
		System.out.println("mensaje: "+mensajeAValidar+" mensaje feature: "+mensaje);
		assertTrue(mensajeAValidar.contains(mensaje));
	}
	
	
}
