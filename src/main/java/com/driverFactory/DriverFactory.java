package com.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @return This will return tldriver.
     */
    public WebDriver init_driver(String browser) {
        System.out.println("Browser value is: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else {
            System.out.println("Please pass the supported browser value instead of " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * This is used to get the driver with ThreadLocal
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
