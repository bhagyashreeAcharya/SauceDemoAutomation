package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductTest extends BaseTest {

    @Test
    public void verifyRemoveProductFromCart() {

        // Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        // Step 2: Wait for inventory page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));


        // Step 3: Add two products
        By backpackAdd = By.id("add-to-cart-sauce-labs-backpack");
        By bikeLightAdd = By.id("add-to-cart-sauce-labs-bike-light");

        wait.until(ExpectedConditions.elementToBeClickable(backpackAdd));
        driver.findElement(backpackAdd).click();

        wait.until(ExpectedConditions.elementToBeClickable(bikeLightAdd));
        driver.findElement(bikeLightAdd).click();


        // Step 4: Verify cart count = 2
        By cartBadge = By.className("shopping_cart_badge");

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));

        Assert.assertEquals(driver.findElement(cartBadge).getText(), "2",
                "Cart count should be 2 after adding products");


        // Step 5: Remove one product
        By removeBackpack = By.id("remove-sauce-labs-backpack");

        wait.until(ExpectedConditions.elementToBeClickable(removeBackpack));

        driver.findElement(removeBackpack).click();


        // Step 6: Verify cart count = 1
        wait.until(ExpectedConditions.textToBe(cartBadge, "1"));

        Assert.assertEquals(driver.findElement(cartBadge).getText(), "1",
                "Cart count should be 1 after removing product");

    }
}
