package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManuHeader {
    private WebDriver driver;
    private By SignupAndLoginLink_i = By.xpath("//i[@class='fa fa-lock']");
    private By LoggedInText = By.xpath("//a//i[@class='fa fa-user']/following-sibling::text()");
    private By UserNameAfterLogin_b = By.xpath("//a/b");
    private By DeleteAccount_i = By.xpath("//i[@class='fa fa-trash-o']");
    private By Logout_i = By.className("fa-lock");
    private By ContactUs_i = By.className("fa-envelope");
    private By Home_i = By.className("fa-home");
    public  ManuHeader(WebDriver driver){
        this.driver=driver;
    }
    @Step("Click On Sign Up and Login Link Text")
    public ManuHeader clickSignupAndLoginLinkText(){
        driver.findElement(SignupAndLoginLink_i).click();
        return this;
    }
    public String GetLoggedInText(){
        return driver.findElement(LoggedInText).getText();
    }
    @Step("Get Username After Login")
    public String GetUserNameAfterLogin(){
        return driver.findElement(UserNameAfterLogin_b).getText();
    }
    @Step("Assert On Get User Name After Login")
    public ManuHeader assertOnGetUserNameAfterLogin(){
        /// /
        Assert.assertEquals("Logged in as "+GetUserNameAfterLogin(),"Logged in as Tasnim");
        return this;
    }
    @Step("Click On Delete Account")
    public ManuHeader clickDeleteAccount(){
        driver.findElement(DeleteAccount_i).click();
        return this;
    }
    @Step("Click On Logout Button")
    public ManuHeader clickLogout(){
        driver.findElement(Logout_i).click();
        return this;
    }
    @Step("Click On Contact Us")
    public ManuHeader clickContactUs(){
        driver.findElement(ContactUs_i).click();
        return this;
    }
    @Step("Click On Home")
    public ManuHeader clickOnHome(){
        driver.findElement(Home_i).click();
        return this;
    }

}
