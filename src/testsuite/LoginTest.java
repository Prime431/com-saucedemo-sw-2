package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class LoginTest extends BaseTest { //calling the BaseTest class to LoginTest class
    String baseUrl = "https://www.saucedemo.com/"; //URL

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    } //Method for launching the browser

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Username enter
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Password enter
        driver.findElement(By.id("login-button")).click(); // clicking login button
        String expectedText = "Products"; //Storing expected Text
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText(); // storing actual Text
        Assert.assertEquals(actualText, expectedText); // Comparing actual and expected text
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");//Username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // Entering Password
        driver.findElement(By.id("login-button")).click();
        int actualProduct = driver.findElements(By.className("inventory_item")).size();
        int expectedList = 6;
        Assert.assertEquals(actualProduct,expectedList); // comparing the message
    }
    @After
    public void tearDown(){
        closeBrowser(); //closing the browser
        }
}

