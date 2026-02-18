package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void verifyCheckoutProcess(){
//        Step 1 : Login

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//        step 2 : wait for inventory page loading
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));

//       Step 3 : add product to the cart
        By addToCart = By.id("add-to-cart-sauce-labs-backpack");
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        driver.findElement(addToCart).click();

//        Step 4 : open cart
        By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));

        driver.findElement(cartIcon).click();

//        Step 5 : Click checkout
        By checkoutButton = By.cssSelector("[data-test='checkout']");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();

//        Step 6 : Enter checkout information
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys(("Doe"));
        driver.findElement(By.id("postal-code")).sendKeys("411110");

//        Step 7 : Continue checkout
        driver.findElement(By.id("continue")).click();

//        Step 8 : click finish
        By finishButton = By.cssSelector("[data-test = 'finish']");
        wait.until((ExpectedConditions.elementToBeClickable(finishButton)));
        driver.findElement(finishButton).click();

//        Step 9: Verify order confirmation
        By confirmationMessage = By.cssSelector("[data-test = 'complete-text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));

        String message = driver.findElement(confirmationMessage).getText();
        Assert.assertEquals(message,"Your order has been dispatched, and will arrive just as fast as the pony can get there!", "Confirmation Message Mismatch");

    }
}
