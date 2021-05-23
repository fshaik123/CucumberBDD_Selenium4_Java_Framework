package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailID = By.id("email");
    private By password = By.id("passwd");
    private By SignInButton = By.id("SubmitLogin");

    private By forgotPwdLink = By.linkText("Forgot your password?");

    // Constructor of the page class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Page Actions
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkExists() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailID).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(SignInButton).click();
    }

    public AccountsPage login(String user, String pwd) {
        enterUserName(user);
        enterPassword(pwd);
        clickOnLogin();
        return new AccountsPage(driver);
    }
}
