package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @Test
    public void verifyAddToCartTest(){
//        Step 1 : Lets first login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//        Step 2 : lets wait to see if login completed and inventory page loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));

//        Step 3: Click "Add to cart" for Backpack
        By addTocartButton = By.id("add-to-cart-sauce-labs-backpack");
        wait.until(ExpectedConditions.elementToBeClickable(addTocartButton));
        driver.findElement(addTocartButton).click();

//        Step4 - Verify product added to cart
        By removeButton = By.id("remove-sauce-labs-backpack");
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton));
        Assert.assertTrue(driver.findElement(removeButton).isDisplayed(),"Product was not added to cart");

    }
}
