package test.appium.noMobilePageObject.definitions;

import java.net.MalformedURLException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import test.appium.noMobilePageObject.steps.LoginSteps;

public class LoginDefinitions {
	
	@Steps
	LoginSteps loginSteps;
	
	@Given("^Ingreso a la aplicacion$")
	public void ingresoALaAplicacion() throws MalformedURLException {
	    loginSteps.iniciarAplicacion();
	}


	@When("^ingreso usuario \"([^\"]*)\" y contrasena \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasena(String usuario, String contrasena) {
		loginSteps.loguinConUsuarioYContrasena(usuario,contrasena);
	}

	@Then("^valido ingreso a la aplicacion \"([^\"]*)\"$")
	public void validoIngresoALaAplicacion(String mensaje) {
		loginSteps.validarIngreso(mensaje);
	}
	
	@When("^ingreso al formulario ingresar pago$")
	public void ingresoAlFormularioIngresarPago() {
	    loginSteps.ingresoAFormulario();
	}


	@When("^diligencio formulario de pago con numero \"([^\"]*)\" nombre \"([^\"]*)\" cantidad \"([^\"]*)\" pais \"([^\"]*)\"$")
	public void diligencioFormularioDePagoConNumeroNombreCantidadPais(String numero, String nombre, String cantidad, String pais) {
	    loginSteps.diligenciarPago(numero,nombre,cantidad,pais);
	}

	@Then("^valido pago exitoso$")
	public void validoPagoExitoso() {

	}
}
