package com.demoblaze.step_Defs;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();

    }

    @Then("The user verifies welcome miky")
    public void the_user_verifies_welcome_miky() {

        homePage.verifyLogin();
    }

    @When("The user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("The user verifies welcome {string}")
    public void the_user_welcome_verifies(String string) {
        homePage.verifyLogin(string);
    }
    @When("The user logs in using with credentials")
    public void the_user_logs_in_using_with_credentials(Map<String,String> userCredentials) {
        loginPage.login(userCredentials.get("username"), userCredentials.get("password"));


    }

    @Then("Validate that warning message is {string}")
    public void validate_that_warning_message_is(String message) {
        BrowserUtils.waitFor(2);
        loginPage.verifywithPopUpMessage(message);

    }
}
