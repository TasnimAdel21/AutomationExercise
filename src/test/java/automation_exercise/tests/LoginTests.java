package automation_exercise.tests;

import Pages.*;
import Utilities.JsonFileManager;
import framework.DriverFactory;
import framework.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    private HomePage homePage;
    private SignupandLoginPage SignupandLoginPage;
    private EnterAccountInformationPage EnterAccountInformationPage;
    private AccountCreatedPage AccountCreatedPage;
    private AccountDeletedPage AccountDeletedPage;
    private ManuHeader ManuHeader;
    private JsonFileManager jsonFileManager;

    @Test(description = "Login User With Correct Email And Password")

    public void LoginUserWithCorrectEmailAndPassword(){
        new HomePage(driver)
                .assertOnAppearanceOfFeaturesItemsInHomePage();
        new ManuHeader(driver)
                .clickSignupAndLoginLinkText();
        new SignupandLoginPage(driver)
                .assertOnAppearanceOfLoginToYourAccountText()
                .setEmailAddressAndPasswordInLoginForm(jsonFileManager.getTestData("LoginUserWithCorrectEmailAndPasswordWillBeDeleted.email"), jsonFileManager.getTestData("LoginUserWithCorrectEmailAndPasswordWillBeDeleted.password") )
                .clickOnLogginButton();
        new ManuHeader(driver)
                .assertOnGetUserNameAfterLogin()
                .clickDeleteAccount();
        new AccountDeletedPage(driver)
                .assertOnAppearanceOfAccountDeletedText();
    }

    @Test(description = "Login User With Incorrect Email And Password")
    public void LoginUserWithIncorrectEmailAndPassword(){
        new HomePage(driver)
                .assertOnAppearanceOfFeaturesItemsInHomePage();
        new ManuHeader(driver)
                .clickSignupAndLoginLinkText();
        new SignupandLoginPage(driver)
                .assertOnAppearanceOfLoginToYourAccountText()
                .setEmailAddressAndPasswordInLoginForm(jsonFileManager.getTestData("LoginUserWithIncorrectEmailAndPassword.email"), jsonFileManager.getTestData("LoginUserWithIncorrectEmailAndPassword.password") )
                .clickOnLogginButton()
                .assertOnErrorMessageAppearedAfterInvalidLogin();
    }
    @BeforeSuite
    public void beforeSuite(){
        PropertiesReader.loadProperties();
    }
    @BeforeMethod  //kol mraaa 2bl kol testcase
    public void SetUP(){
        driver = DriverFactory.intiateDriver(System.getProperty("browserType"),Boolean.valueOf(System.getProperty("maximize")));
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
