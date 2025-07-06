package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finishCheckout() {
        driver.findElement(By.id("finish")).click();
    }
}
