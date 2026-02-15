package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {
@Test
    public void verifyInvalidLogin(){
    driver.findElement(By.id("user-name")).sendKeys("wrong_user");
    driver.findElement(By.id("password")).sendKeys("wrong_password");
    driver.findElement(By.id("login-button")).click();

    String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
    Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"));

}

}
