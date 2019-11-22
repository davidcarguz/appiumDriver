package test.appium.noMobilePageObject.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
features = "src/test/resources/features/"
,glue = "test.appium.noMobilePageObject.definitions"
,tags = "@pago_exitoso"
,snippets = SnippetType.CAMELCASE
)

public class LoginRunner {

}
