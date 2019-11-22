#Author: David Cardenas Guzman

@login
Feature: prueba de ingreso a la app

  @login_exitoso
  Scenario: loguin exitoso
    Given Ingreso a la aplicacion
    When ingreso usuario "company" y contrasena "company"
    Then valido ingreso a la aplicacion "balance"
   
  @pago_exitoso  
 	Scenario: realizar pago
 		Given Ingreso a la aplicacion
    And ingreso usuario "company" y contrasena "company"
    When ingreso al formulario ingresar pago
    And diligencio formulario de pago con numero "3143054871" nombre "David Cardenas" cantidad "20" pais "Colombia" 
    Then valido pago exitoso  

