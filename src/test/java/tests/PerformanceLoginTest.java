package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PerformanceLoginTest extends BaseTest {
    @Test
    public void verifyPerformanceLoginTest(){
        // Selenium: enter performance glitch username
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        // Selenium: enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Selenium: click login
        driver.findElement(By.id("login-button")).click();

        // TestNG: verify login success
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Performance glitch user failed to login");
    }
}
