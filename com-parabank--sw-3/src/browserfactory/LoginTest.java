package browserfactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
//        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
//        userName.sendKeys("Prime123");
        sendTextToElement(By.xpath("//input[@name='username']"),"Prime123");

        //Enter valid password
//        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//        password.sendKeys("abc123");
        sendTextToElement(By.xpath("//input[@name='password']"),"abc123");

        //Click on ‘LOGIN’ button
//        WebElement loginText = driver.findElement(By.xpath("//input[@class='button' and @value='Log In']"));
//        loginText.click();
        clickOnElement(By.xpath("//input[@class='button' and @value='Log In']"));
        //Verify the ‘Accounts Overview’ text is display
        String expectedMsg = "Accounts Overview";

      //  WebElement actual = driver.findElement(By.xpath("//h1[@class = 'title']"));
        String actualMsg = getTextFromElement(By.xpath("//h1[@class = 'title']"));
        Assert.assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void verifyTheErrorMessage() {
        // Enter invalid username
//        WebElement invalidUser = driver.findElement(By.xpath("//input[@name='username']"));
//        invalidUser.sendKeys("amm12");
        sendTextToElement(By.xpath("//input[@name='username']"),"amm12");

        // Enter invalid password
//        WebElement invalidpassword = driver.findElement(By.xpath("//input[@name='password']"));
//        invalidpassword.sendKeys("aaa123");
        sendTextToElement(By.xpath("//input[@name='password']"),"aaa123");


        // Click on Login button
//        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='button' and @value='Log In']"));
//        loginBtn.click();
        clickOnElement(By.xpath("//input[@class='button' and @value='Log In']"));

        // Verify the error message ‘The username and password could not be verified.’
      //  WebElement error = driver.findElement(By.xpath("//p[@class='error']"));
        String actualErrorMessage = getTextFromElement(By.xpath("//p[@class='error']"));

        String expected = "The username and password could not be verified.";
        Assert.assertEquals(expected, actualErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Enter valid username
       sendTextToElement(By.xpath("//input[@name='username']"),"Prime123");
        // Enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"abc123");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//h2[text() ='Customer Login']"));
        //  Click on ‘Log Out’ link
//        WebElement logOut = driver.findElement(By.xpath("//a[text()='Log Out']"));
//        logOut.click();
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        // Verify the text ‘Customer Login’
//        WebElement customerLogin = driver.findElement(By.xpath("//h2[text()='Customer Login']"));
       String actualMsg = getTextFromElement(By.xpath("//h2[text()='Customer Login']"));
        String expectedMsg = "Customer Login";
        Assert.assertEquals(expectedMsg, actualMsg);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
