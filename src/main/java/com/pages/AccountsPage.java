package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;

    private By accountSectionList = By.xpath("//div[@class='row addresses-lists']//span");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountsPageTitle() {
        return driver.getTitle();
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountSectionList).size();
    }

    public List<String> getAccountsSectionList() {
        List<String> actualAccountsList = new ArrayList<>();
        List<WebElement> accountsList = driver.findElements(accountSectionList);
        for(WebElement e : accountsList) {
            actualAccountsList.add(e.getText());
        }
        return actualAccountsList;
    }
}