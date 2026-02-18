package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddMultipleProductTest extends BaseTest {
    @Test
    public void verifyAddMultipleProductsTest (){
//  Step 1 : Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//        Step 2: Wait until inventory page loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));

//       Step 3: Add first product (Backpack)
        By BackpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
        wait.until(ExpectedConditions.elementToBeClickable(BackpackAddButton));
        driver.findElement(BackpackAddButton).click();

//       Step 4: Add second product (Bike Light)
        By bikeLightAddButton = By.id("add-to-cart-sauce-labs-bike-light");
        wait.until(ExpectedConditions.elementToBeClickable(bikeLightAddButton));
        driver.findElement(bikeLightAddButton).click();

//        Step 5: Wait for cart badge to update
        By cartBadge = By.className("shopping_cart_badge");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));

//         Step 6: Verify cart count is 2
        String cartCount = driver.findElement(cartBadge).getText();

        Assert.assertEquals(cartCount, "2", "Cart count is incorrect after adding multiple products");


    }
}
