package com.example.bdd.steps;

import com.example.bdd.hooks.Hooks;
import com.example.page.Basic.MainPage;
import com.example.page.LoginPage;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private LoginPage loginPage;
    private MainPage mainPage;

    @Given("I open the login page")
    public void user_opens_login_page() {
        log.info("I open the login page");
        loginPage = new LoginPage(Hooks.driver);
        loginPage.openPage();
    }

    @When("^I login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_and_password(String username, String password) {
        log.info("I login with username {} and password {}", username, password);
        loginPage.enterUsernameAndPassword(username, password);
    }

    @When("I click login button")
    public void clicks_login_button() {
        log.info("I click login button");
        mainPage = loginPage.pressSubmitButton();
    }

    @Then("I should see the credentials block")
    public void user_should_see_dashboard() {
        log.info("I should see the credentials block");
        assertTrue(mainPage.isLoginSuccessful(), "Login failed");
    }
}
