package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ellenőrzi, hogy bármilyen termék van-e a kosárban
    public boolean isProductInCart() {
        return driver.findElements(By.className("cart_item")).size() > 0;
    }

    // Ellenőrzi, hogy egy adott termék neve szerepel-e az oldal HTML-jében
    public boolean isProductInCart(String productName) {
        return driver.getPageSource().contains(productName);
    }

    // Checkout gomb megnyomása
    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
}
