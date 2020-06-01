package com.kateProjects.Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

enum Sort {
    CHEAP,
    EXPENSIVE,
    POPULARITY,
    NOVELTY,
    ACTION,
    RANK
}

public class HomePage {
    WebDriver driver = DriverFactory.getChromeDriver();
    WebDriverWait wait = DriverFactory.getWebDriverWait();

    private static final By HEADER_SEARCH_INPUT_LOCATOR = By.className("rz-header-search");
    private static final By SORTING_LOCATOR = By.name("drop_link");



    public boolean sortResults(Sort typeToSort) {
        List<WebElement> selectElement = driver.findElements(SORTING_LOCATOR);
        if (selectElement.isEmpty()) {
            return false;
        }

        String sortString;
        switch (typeToSort) {
            case CHEAP:
                sortString = "1: cheap";
                break;

            case EXPENSIVE:
                sortString = "2: expensive";
                break;

            case POPULARITY:
                sortString = "3: popularity";
                break;

            case NOVELTY:
                sortString = "4: novelty";
                break;

            case ACTION:
                sortString = "5: action";
                break;

            case RANK:
                sortString = "6: rank";
                break;

            default:
                return false;

        }
        Select filterDropdown = new Select(selectElement.get(0));
        filterDropdown.selectByValue(sortString);
        return true;
    }

        public void search(String value) {
            WebElement search = driver.findElement(HEADER_SEARCH_INPUT_LOCATOR);
            search.sendKeys(value);
            search.sendKeys(Keys.ENTER);
        }
    }
