package stepDefinitions;

import pages.LoginElements;
import utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    LoginElements le = new LoginElements();
    @Given("Navigate to Trendyol")
    public void navigateToTrendyol() {
        BaseDriver.getDriver().get("https://www.trendyol.com/");
        le.pressEsc();
        le.clickFunction(le.getWebElement("closeButton"));
        le.clickFunction(le.getWebElement("acceptCookie"));
    }

    @When("Enter user information")
    public void enterUserInformation() {
        le.clickFunction(le.getWebElement("login"));
        le.pressEsc();
        le.sendKeysFunction(le.getWebElement("email"), "akdoganflow@gmail.com");
        le.sendKeysFunction(le.getWebElement("password"), "Naz_123");
    }

    @And("Click login")
    public void clickLogin() {
        le.clickFunction(le.getWebElement("LOGIN"));
    }

    @Then("Verify successful login")
    public void verifySuccessfulLogin() {
        le.verifyContainsTextFunction(le.getWebElement("verifyLogin"), "Hesabım");

    }
}
