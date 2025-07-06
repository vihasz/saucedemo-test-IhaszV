package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    private WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderComplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
            String confirmation = driver.findElement(By.className("complete-header")).getText();
            return confirmation.contains("Thank you for your order");
        } catch (Exception e) {
            System.out.println("Nem sikerült betölteni az oldalt vagy nincs köszönő szöveg: " + e.getMessage());
            return false;
        }
    }
}
