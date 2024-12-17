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

public class ContactUsTests {
    private JsonFileManager jsonFileManager;
    private WebDriver driver;
    private HomePage homePage;
    private Pages.ManuHeader ManuHeader;
    private Pages.SignupandLoginPage SignupandLoginPage;
    private Pages.EnterAccountInformationPage EnterAccountInformationPage;
    private Pages.AccountCreatedPage AccountCreatedPage;
    private AccountDeletedPage AccountDeletedPage;

    @Test(description = "Contact Us Form")
    public void ContactUsForm(){
        new HomePage(driver)
                .assertOnAppearanceOfFeaturesItemsInHomePage();
        new ManuHeader(driver)
                .clickContactUs();
        new ContactUsPage(driver)
                .AssertOnAppearanceOfGetInTouchText()
                .EnterContactUsData(jsonFileManager.getTestData("ContactUsData.name")
                        , jsonFileManager.getTestData("ContactUsData.email")
                        , jsonFileManager.getTestData("ContactUsData.subject")
                        , jsonFileManager.getTestData("ContactUsData.message"))
                
                .clickOnSubmitButton()
                .clickOKButtonInAlert()
                .AssertOnTheAppearanceOfSuccessfullMessageTextAfterSubmit();
        new ManuHeader(driver)
                .clickOnHome();
        new HomePage(driver)
                .assertOnAppearanceOfFeaturesItemsInHomePage();

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
