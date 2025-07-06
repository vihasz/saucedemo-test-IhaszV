package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import pages.LoginPage;
public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void testInvalidPassword() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "wrong_pass");
        assertTrue(login.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    public void testLockedOutUser() {
        LoginPage login = new LoginPage(driver);
        login.login("locked_out_user", "secret_sauce");
        assertTrue(login.getErrorMessage().contains("locked out"));
    }

    @Test
    public void testEmptyFields() {
        LoginPage login = new LoginPage(driver);
        login.login("", "");
        assertTrue(login.getErrorMessage().contains("Username is required"));
    }
}
