package automation_exercise.tests;

import Pages.*;
import Utilities.JsonFileManager;
import framework.DriverFactory;
import framework.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LogoutTests {
    private WebDriver driver;
    private HomePage homePage;
    private Pages.SignupandLoginPage SignupandLoginPage;
    private Pages.EnterAccountInformationPage EnterAccountInformationPage;
    private Pages.AccountCreatedPage AccountCreatedPage;
    private Pages.AccountDeletedPage AccountDeletedPage;
    private ManuHeader ManuHeader;
    private JsonFileManager jsonFileManager;

    @Test(description = "Logout User")
    public void LogoutUser(){
        new HomePage(driver)
                .assertOnAppearanceOfFeaturesItemsInHomePage();
        new ManuHeader(driver)
                .clickSignupAndLoginLinkText();
        new SignupandLoginPage(driver)
                .assertOnAppearanceOfLoginToYourAccountText()
                .setEmailAddressAndPasswordInLoginForm(jsonFileManager.getTestData("LoginData.email"), jsonFileManager.getTestData("LoginData.password") )
                .clickOnLogginButton();
        /// ///////
        Assert.assertEquals("Logged in as "+ManuHeader.GetUserNameAfterLogin(),"Logged in as Aya Ahmed");
        new ManuHeader(driver)
                .clickLogout();
        new SignupandLoginPage(driver)
                .assertOnAppearanceOfTheNewUserSignUpForm()
                .assertOnAppearanceOfLoginToYourAccountText();
    }


    @BeforeSuite
    public void beforeSuite(){
        PropertiesReader.loadProperties();
    }
    @BeforeMethod  //kol mraaa 2bl kol testcase
    public void SetUP(){
        driver = DriverFactory.intiateDriver(System.getProperty("browserType"),Boolean.valueOf(System.getProperty("maximize")),Boolean.valueOf(System.getProperty("headlessExecution")));
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
        SignupandLoginPage = new SignupandLoginPage(driver);
        EnterAccountInformationPage = new EnterAccountInformationPage(driver);
        AccountCreatedPage = new AccountCreatedPage(driver);
        AccountDeletedPage = new AccountDeletedPage(driver);
        ManuHeader = new ManuHeader(driver);
        jsonFileManager = new JsonFileManager("src/test/resources/TestDataJsonFile/TestData.json");

    }
    @AfterMethod
    public void TearDown() {
        driver.quit();
    }

}
