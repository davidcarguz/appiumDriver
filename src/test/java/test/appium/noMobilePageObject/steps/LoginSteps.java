package test.appium.noMobilePageObject.steps;

import java.net.MalformedURLException;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import test.appium.noMobilePageObject.pageObjects.LoginPageObjects;

public class LoginSteps {

	LoginPageObjects loginPageObjects;
	
	@Step
	public void iniciarAplicacion() throws MalformedURLException {
		loginPageObjects.iniciarApp();
		Serenity.takeScreenshot();
		
	}
	
	@Step
	public void loguinConUsuarioYContrasena(String usuario, String contrasena) {
		Serenity.takeScreenshot();
		loginPageObjects.ingresarUsuario(usuario);
		loginPageObjects.ingresarContrasena(contrasena);
		loginPageObjects.darClicEnBotonIngresar();
		Serenity.takeScreenshot();
		
	}

	@Step
	public void validarIngreso(String mensaje) {
		loginPageObjects.validarMensajeSaldo(mensaje);
		Serenity.takeScreenshot();
		
	}
	
	@Step
	public void ingresoAFormulario() {
		loginPageObjects.darClicEnMakePayment();
		
	}

	@Step
	public void diligenciarPago(String numero, String nombre, String cantidad, String pais) {
		loginPageObjects.ingresarNumeroTelefonico(numero);
		loginPageObjects.ingresarNombre(nombre);
		loginPageObjects.ingresarValorPago(cantidad);
		loginPageObjects.darClicEnBuscarPais();
		loginPageObjects.SeleccionarPais(pais);
		
	}
}
