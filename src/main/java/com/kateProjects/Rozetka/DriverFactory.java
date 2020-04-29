package com.kateProjects.Rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverFactory(){
        //prevent instantiation
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            //System.setProperty("C:\\Program Files (x86)\\Google\\Chrome\\Application\\", "chromedriver.exe");

            try {
                driver = new RemoteWebDriver(
                        new URL("http://127.0.0.1:9515"),
                        new ChromeOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }


        public static WebDriverWait getWebDriverWait() {
            if (wait == null) {
                wait = new WebDriverWait(driver, 5);
            }
            return wait;
        }

}
