package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTests extends BaseTest {

    @Test
    public void testLogout() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 1. Kattints a hamburger menüre
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // 2. Várj, amíg a Logout link kattintható lesz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();

        // 3. Várj, hogy megjelenjen a login oldal eleme (username mező)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        // 4. Ellenőrizd, hogy visszakerültünk a login oldalra
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("saucedemo.com"), "A kijelentkezés nem sikerült.");
    }
}
