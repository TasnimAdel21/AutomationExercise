package Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomePage {
     private WebDriver driver;
     private By FeaturesItemsInHomePage_h2 = By.xpath("//h2[@class='title text-center' and text()='Features Items']");

     public HomePage (WebDriver driver){
         this.driver=driver;
     }
     @Step("Appearance Of Feature Items In Home Page")
     public boolean AppearanceOfFeaturesItemsInHomePage(){
        return driver.findElement(FeaturesItemsInHomePage_h2).isDisplayed();
     }
    @Step("Assert on Appearance Of Features Items In Home Page")
     public HomePage assertOnAppearanceOfFeaturesItemsInHomePage(){
         Assert.assertTrue(AppearanceOfFeaturesItemsInHomePage());
         return this;
     }



}
