package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EnterAccountInformationPage {
    private WebDriver driver;
    private By EnterAccountInformation_h2 = By.xpath("//h2[@class='title text-center' and b[text()='Enter Account Information']]");
    private By GenderMale_label = By.xpath("//label[@for='id_gender1']");
    private By GenderFemale_label = By.xpath("//label[@for='id_gender2']");
    private By Password_input = By.xpath("//input[@id='password']");
    private By Day_select = By.xpath("//select[@name='days']");
    private By Month_select = By.xpath("//select[@name='months']");
    private By Year_select = By.xpath("//select[@name='years']");
    private By NewsLetterCheckBox_label = By.xpath("//label[@for='newsletter']");
    private By SpecialOffersCheckBox_label = By.xpath("//label[@for='optin']");
    private By FirstName_input = By.xpath("//input[@name='first_name']");
    private By LastName_input = By.xpath("//input[@name='last_name']");
    private By Company_input = By.xpath("//input[@name='company']");
    private By Address1_input = By.xpath("//input[@name='address1']");
    private By Address2_input = By.xpath("//input[@name='address2']");
    private By CountryDropDown_select = By.xpath("//select[@name='country']");
    private By State_input = By.id("state");
    private By City_input = By.id("city");
    private By ZipCode_input = By.id("zipcode");
    private By MobileNumber_input = By.id("mobile_number");
    private By CreateAccountButton_button = By.xpath("//button[@data-qa='create-account']");

    public EnterAccountInformationPage(WebDriver driver){
        this.driver=driver;
    }

    @Step("Appearance Of Enter Account Information Text")
    public boolean AppeareanceOfEnterAccountInformationText(){
        return driver.findElement(EnterAccountInformation_h2).isDisplayed();
    }
    @Step("Assert On Appearance Of Enter Account Information Text")
    public EnterAccountInformationPage assertOnAppeareanceOfEnterAccountInformationText(){
        Assert.assertTrue(AppeareanceOfEnterAccountInformationText());
        return this;
    }
    @Step("Choose Male Gender For Title")
    public EnterAccountInformationPage chooseMaleGenderForTitle(){
        driver.findElement(GenderMale_label).click();
        return this;
    }
    @Step("Choose Female Gender For Title")
    public EnterAccountInformationPage chooseFemaleGenderForTitle(){
        driver.findElement(GenderFemale_label).click();
        return this;
    }
    @Step("Set User Password: {password} | And Date Of Birth: {optionForDay}/{optionForMonth}/{optionForYear}")
    public EnterAccountInformationPage setUserPasswordAndDateOfBirth(String password,String optionForDay,String optionForMonth,String optionForYear){
        driver.findElement(Password_input).sendKeys(password);
        new Select(driver.findElement(Day_select)).selectByVisibleText(optionForDay);
        new Select(driver.findElement(Month_select)).selectByVisibleText(optionForMonth);
        new Select(driver.findElement(Year_select)).selectByVisibleText(optionForYear);
        return this;
    }
    @Step("Click On News Letters CheckBox")
    public EnterAccountInformationPage clickNewsLetterCheckBox(){
        driver.findElement(NewsLetterCheckBox_label).click();
        return this;
    }
    @Step("Click On Special Offers CheckBox")
    public EnterAccountInformationPage clickSpecialOffersCheckBox(){
        driver.findElement(SpecialOffersCheckBox_label).click();
        return this;
    }
    @Step("Set User Address Information For {userfirstname} {userlastname}")
    public EnterAccountInformationPage setUserAddressInformation(
             String userfirstname,
             String userlastname,
             String usercompanyname,
             String userfirstaddress,
             String usersecondAddress,
             String usercountry,
             String userstate,
             String userCity,
             String userzipcode,
             String usermobilenumber){
        driver.findElement(FirstName_input).sendKeys(userfirstname);
        driver.findElement(LastName_input).sendKeys(userlastname);
        driver.findElement(Company_input).sendKeys(usercompanyname);
        driver.findElement(Address1_input).sendKeys(userfirstaddress);
        driver.findElement(Address2_input).sendKeys(usersecondAddress);
        new Select(driver.findElement(CountryDropDown_select)).selectByVisibleText(usercountry);
        driver.findElement(State_input).sendKeys(userstate);
        driver.findElement(City_input).sendKeys(userCity);
        driver.findElement(ZipCode_input).sendKeys(userzipcode);
        driver.findElement(MobileNumber_input).sendKeys(usermobilenumber);
        return this;

    }
    @Step("Click On Create Account Button")
    public EnterAccountInformationPage clickCreateAccountButton(){
        driver.findElement(CreateAccountButton_button).click();
        return this;
    }


}
