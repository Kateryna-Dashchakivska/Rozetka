package com.kateProjects.Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    WebDriver driver = DriverFactory.getChromeDriver();
    WebDriverWait wait = DriverFactory.getWebDriverWait();

    private static final By HEADER_SEARCH_INPUT_LOCATOR = By.className("rz-header-search");


    public void search(String value){
        WebElement search = driver.findElement(HEADER_SEARCH_INPUT_LOCATOR);
        search.sendKeys(value);
        search.sendKeys(Keys.ENTER);
    }
}
