package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String firstName, String lastName, String postalCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));

        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("first-name")).sendKeys(firstName);

        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("last-name")).sendKeys(lastName);

        driver.findElement(By.id("postal-code")).clear();
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);

        driver.findElement(By.id("continue")).click();
    }

    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
