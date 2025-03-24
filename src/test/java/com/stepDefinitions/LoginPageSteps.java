package com.stepDefinitions;

import com.driverFactory.DriverFactory;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("Open the browser and navigate to Salesforce")
    public void openTheBrowserAndNavigateToSalesforce() throws IOException {
        loginPage.navigate();
    }
}
