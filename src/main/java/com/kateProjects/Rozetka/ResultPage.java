package com.kateProjects.Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ResultPage {
    WebDriver driver = DriverFactory.getChromeDriver();
    Actions actions = new Actions(driver);

    private static final By CART_ICON_LOCATOR = By.className("sprite-side btn-link g-buy-submit-light");
    private static final By CLOSE_CART_ICON_LOCATOR = By.className("js-svg-close");

    public List <WebElement> findAllCartElements() {
//        List<WebElement> orderElement = driver.findElements(CART_ICON_LOCATOR);
//        return orderElement;
        return driver.findElements(CART_ICON_LOCATOR); //this equals to 17+18 rows
    }

    public boolean addElementsToCart(List <WebElement> elementsInCart, int number) {
        if (elementsInCart == null || elementsInCart.isEmpty() || number < 1 || number > elementsInCart.size()) {
            return false;
        }

        for (int i = 1; i <= number; i++) {
            WebElement myEl = elementsInCart.get(i);
            actions.moveToElement(myEl).click().build().perform();

            boolean isClosed = this.closeCartModal();
            if(!isClosed) {   //if (isClosed) equals to if(isClosed == true)
                return false;   //if (!isClosed) equals to if(isClosed == false)
            }
        }
        return true;
    }

    private boolean closeCartModal() {
        List<WebElement> closeIcon = driver.findElements(CLOSE_CART_ICON_LOCATOR);
        if (closeIcon.isEmpty()) {
            return false;
        }
        closeIcon.get(0).click();
        return true;
    }




}
