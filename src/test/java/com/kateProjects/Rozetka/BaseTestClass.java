package com.kateProjects.Rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void startUpBrowser(){

        driver = DriverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        wait = DriverFactory.getWebDriverWait();
    }

    @BeforeMethod
    public void goToHome(){
        //driver.get("rozetka.com.ua");
    }


    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }






}
