/*3. Write down the following test into ‘LoginTest’ class
1. userSholdLoginSuccessfullyWithValidCredentials
* Enter “tomsmith” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the text “Secure Area”
2. verifyTheUsernameErrorMessage
* Enter “tomsmith1” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the error message “Your username
 is invalid!”
3. verifyThePasswordErrorMessage
* Enter “tomsmith” username
* Enter “SuperSecretPassword” password
* Click on ‘LOGIN’ button
* Verify the error message “Your password
 is invalid!”*/
package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String BaseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Find username and enter the username
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        //Find password and enter the password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        //Find Login Button and Click on Login Button
        WebElement LoginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        LoginButton.click();

        //This requirement is from document
        String ExpectedMsg = "Secure Area";
        //Find the Secure Area text element and get the text
        WebElement ActualMsgEl = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String ActMsg = ActualMsgEl.getText();
        System.out.println("Actual Message:"+ActMsg);

        //Validate actual and expected message
        Assert.assertEquals("Message is not expected:",ExpectedMsg,ActMsg);
    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Find username and enter the username
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");

        //Find password and enter the password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        //Find Login Button and Click on Login Button
        WebElement LoginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        LoginButton.click();

        //This requirement is from document
        String ExpectedMsg = "Your username is invalid!\n"+
                "×";
        //Find the Your username is invalid! text element and get the text
        WebElement ActualMsgEl = driver.findElement(By.xpath("//div[@id='flash']"));
        String ActMsg = ActualMsgEl.getText();
        System.out.println("Actual Message:"+ActMsg);

        //Validate actual and expected message
        Assert.assertEquals("Message is not expected;",ExpectedMsg,ActMsg);
    }
    @Test
    public void verifyThePasswordErrorMessage() {
        //Find username and enter the username
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        //Find password and enter the password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword");

        //Find Login Button and Click on Login Button
        WebElement LoginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        LoginButton.click();

        //This requirement is from document
        String ExpectedMsg = "Your password is invalid!\n"+
                "×";
        //Find the Secure Area text element and get the text
        WebElement ActualMsgEl = driver.findElement(By.id("flash"));
        String ActMsg = ActualMsgEl.getText();
        System.out.println("Actual Message:"+ActMsg);

        //Validate actual and expected message
        Assert.assertEquals("Message is not expected;",ExpectedMsg,ActMsg);
    }
    @After
    public void closedown(){
        closeBrowser();
    }
}