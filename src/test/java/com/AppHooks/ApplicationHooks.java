package com.AppHooks;

import com.driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class ApplicationHooks {

    private WebDriver driver;

    @Before()
    public void launchBrowser() {
        driver = DriverFactory.init_driver("chrome");
    }

    @After()
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
