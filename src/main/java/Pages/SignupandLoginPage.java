package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupandLoginPage {
    private WebDriver driver ;
    private By NewUserSignUpForm_div = By.xpath("//div[@class='signup-form']");
    private By NameInSignUp_input = By.xpath("//input[@name='name']");
    private By EmailAddressInSignUp_input = By.xpath("//input[@data-qa='signup-email']");
    private By SignUpButton_button = By.xpath("//button[@data-qa='signup-button']");
    private By LoginToYourAccount_h2 = By.xpath("//div[@class='login-form']/h2");
    private By EmailAddressInLogin_input = By.xpath("//input[@data-qa='login-email']");
    private By PasswordInLogin_input = By.xpath("//input[@data-qa='login-password']");
    private By LoginButton_button = By.xpath("//button[@data-qa='login-button']");
    public SignupandLoginPage(WebDriver driver){
        this.driver = driver;
    }
    @Step("Appearance Of The New User Sign Up Form")
    public boolean AppearanceOfTheNewUserSignUpForm (){
        return driver.findElement(NewUserSignUpForm_div).isDisplayed();
    }
    @Step("Assert On Appearance Of The New User Sign Up Form")
    public SignupandLoginPage assertOnAppearanceOfTheNewUserSignUpForm(){
        Assert.assertTrue(AppearanceOfTheNewUserSignUpForm());
        return this;
    }
    @Step("Set Name And Email Address For User In Sign Up Form")
    public SignupandLoginPage setNameAndEmailAddressInSignUpForm(String username,String email){
        driver.findElement(NameInSignUp_input).sendKeys(username);
        driver.findElement(EmailAddressInSignUp_input).sendKeys(email);
        return this;
    }
    @Step("Click on Sign Up Button")
    public SignupandLoginPage clickOnSignUpButton(){
        driver.findElement(SignUpButton_button).click();
        return this;
    }
    @Step("Appearance Of Login To Your Account Text")
    public boolean AppearanceOfLoginToYourAccountText(){
        return driver.findElement(LoginToYourAccount_h2).isDisplayed();
    }
    @Step("Assert On Appearance Of Login To Your Account Text")
    public SignupandLoginPage assertOnAppearanceOfLoginToYourAccountText(){
        Assert.assertTrue(AppearanceOfLoginToYourAccountText());
        return this;
    }
    @Step("Set Email Address And Password In Login Form")
    public SignupandLoginPage setEmailAddressAndPasswordInLoginForm(String email, String password){
        driver.findElement(EmailAddressInLogin_input).sendKeys(email);
        driver.findElement(PasswordInLogin_input).sendKeys(password);
        return this;
    }

    public SignupandLoginPage clickOnLogginButton(){
        driver.findElement(LoginButton_button).click();
        return this;
    }



}
