package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
    openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //click on Register link

       clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        String expectedMessage = "Signing up is easy!";

        String actualMessage =getTextFromElement(By.xpath("//h1[@class='title']"));

        //Verifying the text
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //click on Register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //Enter First name
       sendTextToElement(By.xpath("//input[@id='customer.firstName']"),"PrimeMember112342");

        //Enter Last name
        sendTextToElement(By.xpath("//input[@name='customer.lastName']"),"Testing");

       // Enter Address

        sendTextToElement(By.xpath("//input[@id='customer.address.street']"),"3,Isobel Street");

		//Enter City

        sendTextToElement(By.xpath("//input[@id='customer.address.city']"),"London");

        //Enter State
        sendTextToElement(By.xpath("//input[@name='customer.address.state']"),"Northwood");

        // Enter Zip Code
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"),"ha2 5rt");

        // Enter Phone
        sendTextToElement(By.xpath("//input[@name='customer.phoneNumber']"),"0778812561");

        // Enter SSN
        sendTextToElement(By.xpath("//input[@name='customer.ssn']"),"12345");

        // Enter Username
        sendTextToElement(By.xpath("//input[@name='customer.username']"),"Prime123");

        // Enter Password
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"abc123");

        // Enter Confirm
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"),"abc123");

        // Click on REGISTER button
        clickOnElement(By.xpath("//input[@class='button' and @value='Register']"));

       //Verify the text 'Your account was created successfully. You are now logged in.
        String expectedResult = "Your account was created successfully. You are now logged in.";
       String actual = getTextFromElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));

        Assert.assertEquals(expectedResult,actual);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}



