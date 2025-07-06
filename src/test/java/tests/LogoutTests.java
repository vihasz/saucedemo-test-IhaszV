package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTests extends BaseTest {

    @Test
    public void testLogout() {
        // 0. Ablak maximalizálása a jobb elérhetőséghez
        driver.manage().window().maximize();

        // 1. Bejelentkezés
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 2. Hamburger menü megnyitása
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // 3. Várakozás a Logout linkre (20 mp-re emelt időkerettel)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement logoutLink = wait
                .until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        // 4. Görgetés az elemhez, ha nem látható
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", logoutLink);

        // 5. Kattintás (normál kattintás elegendő – JS is használható, ha hibát dob)
        logoutLink.click();

        // 6. Várakozás a login oldalon található felhasználónév mezőre
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        // 7. URL ellenőrzése a kijelentkezés helyességére
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("saucedemo.com"), "A kijelentkezés nem sikerült.");
    }
}
