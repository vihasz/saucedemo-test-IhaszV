package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTests extends BaseTest {

    @Test
    public void testCompleteOrder() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillForm("Jakab", "Kiss", "1234");

        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        overviewPage.finishCheckout();

        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        assertTrue(completePage.isOrderComplete());
    }


    @Test
    public void testEmptyCheckoutForm() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        new InventoryPage(driver).addFirstProductToCart();
        new InventoryPage(driver).goToCart();
        new CartPage(driver).clickCheckout();
        new CheckoutPage(driver).fillForm("", "", "");
        assertTrue(driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed());
    }

}
