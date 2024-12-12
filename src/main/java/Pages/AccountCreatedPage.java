package Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreatedPage {
    private WebDriver driver;
    private By AccountCreatedText_h2 = By.xpath("//h2[@class='title text-center']");
    private By ContinueButton_a = By.xpath("//a[@data-qa='continue-button']");


    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
    }
    @Step("Appearance Of Account Created Text")
    public boolean AppearanceOfAccountCreatedText(){
        return driver.findElement(AccountCreatedText_h2).isDisplayed();
    }
    @Step("Assert On Appearance Of Account Created Text")
    public AccountCreatedPage assertOnAppearanceOfAccountCreatedText(){
        Assert.assertTrue(AppearanceOfAccountCreatedText());
        return this;
    }
    @Step("Click On Continue Button In Account Created Page")
    public AccountCreatedPage clickContinueButtonInAccountCreatedPage(){
        driver.findElement(ContinueButton_a).click();
        return this;

    }
}
