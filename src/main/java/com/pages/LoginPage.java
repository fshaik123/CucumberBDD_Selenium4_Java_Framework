package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.util.ConfigReader.getProperty;

public class LoginPage {
    private final WebDriver driver;

    private final By emailID = By.id("email");
    private final By password = By.id("passwd");
    private final By SignInButton = By.id("SubmitLogin");

    private final By forgotPwdLink = By.linkText("Forgot your password?");

    // Constructor of the page class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() throws IOException {
        driver.get(getProperty("Salesforce_URL"));
    }
}