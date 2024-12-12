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



}
