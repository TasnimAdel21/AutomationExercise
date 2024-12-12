package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletedPage {
    private WebDriver driver;
    private By AccountDeletedText_h2 = By.xpath("//h2[@class='title text-center']");
    private By ContinueDeleteButton_a = By.xpath("//a[@data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver){
        this.driver=driver;
    }
    @Step("Appearance Of Account Deleted Text")
    public boolean AppearanceOfAccountDeletedText(){
        return driver.findElement(AccountDeletedText_h2).isDisplayed();
    }
    @Step("Assert On Appearance Of Account Deleted Text")
    public AccountDeletedPage assertOnAppearanceOfAccountDeletedText(){
        Assert.assertTrue(AppearanceOfAccountDeletedText());
        return this;
    }
    @Step("Click On Continue Button For Delete")
    public AccountDeletedPage clickContinueButtonForDelete(){
        driver.findElement(ContinueDeleteButton_a).click();
        return this;
    }

}
