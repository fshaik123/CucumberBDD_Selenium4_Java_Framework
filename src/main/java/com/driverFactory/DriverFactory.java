package com.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    protected static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static WebDriver driver;

    public static WebDriver init_driver(String browser) {
        System.out.println("Browser value is: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            tlDriver.set(new FirefoxDriver());
        } else {
            System.out.println("Please pass the supported browser value instead of " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }
}