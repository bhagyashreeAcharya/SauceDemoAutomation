package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {
    @Test
    public void verifyLogoutTest(){
        // Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();



        // wait until inventory page loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));

        //click on menu button
        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        // now logout
        driver.findElement(By.id("logout_sidebar_link")).click();


        // wait until login page loads again
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        // Verify redirected to login page

        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(),"Login button is not displayed. Logout failed.");


    }
}
