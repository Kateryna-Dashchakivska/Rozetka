package com.kateProjects.Rozetka;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Unit test for simple App.
 */
public class MainFlowTestSuit extends BaseTestClass {

    @Rule
    public TestName name = new TestName();
    HomePage homePage = new HomePage();

    @Test
    public void SearchTest() throws Exception {
        System.out.println("Starting " + name.getMethodName());
        homePage.search("mobile");
        //Assert.assertTrue(, "Mobiles are found!");
}
    @Test
    public void FirstTest() throws Exception {
        System.out.println("Starting " + name.getMethodName());
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/");

    }



}
