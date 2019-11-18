#Author: David Cardenas Guzman

@login
Feature: prueba de ingreso a la app

  @login_exitoso
  Scenario: loguin exitoso
    Given Ingreso a la aplicacion
    When ingreso usuario "company" y contrasena "company"
    Then valido ingreso a la aplicacion "balance"

