package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LockedUserLoginTest extends BaseTest {
    @Test
    public void verifyLockedUserLogin(){
        // Selenium: enter locked username
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");

        // Selenium: enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Selenium: Enter login button
        driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);

        // Selenium: capture error message text
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();

        // TestNG: verify locked user error appears
        Assert.assertTrue(errorMessage.contains("locked out"),"Expected locked user error message not displayed");




    }
}
