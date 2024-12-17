package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage {
    private WebDriver driver;
    private By GetInTouchText_h2 = By.xpath("//div[@class='contact-form']/h2");
    private By NameInContactUs_input = By.xpath("//input[@name='name']");
    private By EmailInContactUS_input = By.xpath("//input[@name='email']");
    private By SubjectInContactUs_input = By.xpath("//input[@name='subject']");
    private By MessageInContactUs_textarea = By.xpath("//textarea[@name='message']");
    private By ChooseFileToUpload = By.xpath("//input[@name='upload_file']");
    private By SubmitButton = By.xpath("//input[@name='submit']");
    private By SuccessMessageAfterSubmit = By.xpath("//div[@class='status alert alert-success']");
    public ContactUsPage(WebDriver driver){
        this.driver=driver;
    }
    @Step("Get In Touch Text")
    public String GetInTouchText(){
        return driver.findElement(GetInTouchText_h2).getText();
    }
    @Step("Assert On Appearance Of Get In Touch Text")
    public ContactUsPage AssertOnAppearanceOfGetInTouchText(){
        Assert.assertEquals(GetInTouchText(),"GET IN TOUCH");
        return this;
    }
    @Step("In Contact Us Form Enter name, email, subject and messagee")
    public ContactUsPage EnterContactUsData(String name, String email, String subject ,String message){
        driver.findElement(NameInContactUs_input).sendKeys(name);
        driver.findElement(EmailInContactUS_input).sendKeys(email);
        driver.findElement(SubjectInContactUs_input).sendKeys(subject);
        driver.findElement(MessageInContactUs_textarea).sendKeys(message);
        return this;
    }
    @Step("Click On Submit Button")
    public ContactUsPage clickOnSubmitButton(){
        driver.findElement(SubmitButton).click();
        return this;
    }
    @Step("Click OK Button")
    public ContactUsPage clickOKButtonInAlert(){
        driver.switchTo().alert().accept();
        return this;
    }
    @Step("Get The Successfull Message Text After Submit")
    public String GetSuccessfullMessageTextAfterSubmit(){
        return driver.findElement(SuccessMessageAfterSubmit).getText();
    }
    @Step("Assert On The Appearance Of Successfull Message Text After Submit")
    public ContactUsPage AssertOnTheAppearanceOfSuccessfullMessageTextAfterSubmit(){
        Assert.assertEquals(GetSuccessfullMessageTextAfterSubmit(),"Success! Your details have been submitted successfully.");
        return this;
    }
}
