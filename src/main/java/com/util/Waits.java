package com.util.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {

    public void waitForPageToBeReady(int timeOutInSeconds, WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
    }

    public void waitUntilLoadingSpinnerDisappears(By findBy, WebDriver driver) {
        List<WebElement> loads = driver.findElements(findBy);
        if (!loads.isEmpty()) {
            new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.invisibilityOfAllElements(loads));
        } else {
            System.out.println("Loading or Spinner not present");
        }
    }

    public void waitForElementVisibility(By findBy, int timeOutInSeconds, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementInvisibility(By findBy, int timeOutInSeconds, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public void waitForElementToBeClickable(By locator, int timeOutInSeconds, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Boolean isElementPresent(By targetElement, WebDriver driver) {
        return !driver.findElements(targetElement).isEmpty();
    }
    
    public Boolean isElementNotPresent(By targetElement, WebDriver driver) {
        return driver.findElements(targetElement).isEmpty();
    }
}
