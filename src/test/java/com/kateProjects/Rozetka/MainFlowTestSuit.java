package com.kateProjects.Rozetka;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainFlowTestSuit extends BaseTestClass {

    /* JUnit Rule:
    @Rule
    public TestName name = new TestName();*/

    private static HomePage homePage = new HomePage();
    private static ResultPage resultPage = new ResultPage();

    @Test
    public void SearchTest() throws Exception {
        //System.out.println("Starting " + name.getMethodName());
        //homePage.search("mobile");
        //Assert.assertTrue(, "Mobiles are found!");
    }
    @Test
    public void FirstTest() throws Exception {
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/");
        Assert.assertTrue(homePage.sortResults(Sort.CHEAP), "Failed to sort by cheap!");
        List <WebElement> foundCartElements = resultPage.findAllCartElements();
        Assert.assertFalse(foundCartElements.isEmpty(), "Failed to find cart elements!");
        Assert.assertTrue(foundCartElements.size() > 0, "Failed to find cart elements!");  //equals to 29 row
//        Assert.assertTrue(foundCartElements.size() >= 2, "Expected the size >= 2!");

       //Negative cases
        Assert.assertFalse(resultPage.addElementsToCart(foundCartElements, 0), "Should not add 0 number elements");
        Assert.assertFalse(resultPage.addElementsToCart(foundCartElements, -2), "Should not add -2 number elements");
        Assert.assertFalse(resultPage.addElementsToCart(foundCartElements, foundCartElements.size() + 1 ), "Should not add number greateer then elements count");
        Assert.assertFalse(resultPage.addElementsToCart(null, 2), "Should not add null elements list");

        boolean isAdded = resultPage.addElementsToCart(foundCartElements, 2);
        Assert.assertTrue(isAdded, "Failed to add elements!");
    }
}