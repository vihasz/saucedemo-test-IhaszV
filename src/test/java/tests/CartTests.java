package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class CartTests extends BaseTest {


        @Test
        public void testAddProductToCart() {
            LoginPage login = new LoginPage(driver);
            login.login("standard_user", "secret_sauce");

            InventoryPage inventory = new InventoryPage(driver);
            inventory.addFirstProductToCart();
            inventory.goToCart();

            CartPage cart = new CartPage(driver);
            assertTrue(cart.isProductInCart());
        }
    }

