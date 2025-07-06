package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Konstruktor, ahol a driver és a wait példányosítva lesz
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Termék kosárba helyezése (példa: Sauce Labs Fleece Jacket)
    public void addFirstProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    // Átlépés a kosár oldalra
    public void goToCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    // Kijelentkezés a hamburger menün keresztül
    public void logout() {
        // Hamburger menü gomb kattintása
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();

        // Várakozás, hogy a logout link kattintható legyen
        WebElement logoutLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))
        );

        // Logout link kattintása
        logoutLink.click();
    }
}
