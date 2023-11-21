package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl ="https://www.saucedemo.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath(" //input[@id='login-button']")).click();
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath(" //input[@id='login-button']")).click();
        List<WebElement>products=driver.findElements(By.xpath("//Div[@class='inventory_item']"));
        int actualText= products.size();
      int expectedText=6;
       Assert.assertEquals("Six products displayed",expectedText, actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();

    }

}
