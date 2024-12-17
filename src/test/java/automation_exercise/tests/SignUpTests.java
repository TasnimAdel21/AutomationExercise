package automation_exercise.tests;

import Pages.*;
import Utilities.JsonFileManager;
import framework.DriverFactory;
import framework.PropertiesReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class SignUpTests {
    private JsonFileManager jsonFileManager;
    private WebDriver driver;
    private HomePage homePage;
    private ManuHeader ManuHeader;
    private SignupandLoginPage SignupandLoginPage;
    private EnterAccountInformationPage EnterAccountInformationPage;
    private AccountCreatedPage AccountCreatedPage;
    private AccountDeletedPage AccountDeletedPage;
    @Test(description = "Register New User")
    @Severity(SeverityLevel.CRITICAL)
    public void RegisterUser(){
        new HomePage(driver)
        .assertOnAppearanceOfFeaturesItemsInHomePage();
        new ManuHeader(driver)
                .clickSignupAndLoginLinkText();
        new SignupandLoginPage(driver)
                .assertOnAppearanceOfTheNewUserSignUpForm()
                .setNameAndEmailAddressInSignUpForm(jsonFileManager.getTestData("RegisterUserTest.userFirstName"), jsonFileManager.getTestData("RegisterUserTest.email"))
                .clickOnSignUpButton();
        new EnterAccountInformationPage(driver)
               .assertOnAppeareanceOfEnterAccountInformationText()
               .chooseFemaleGenderForTitle()
               .setUserPasswordAndDateOfBirth(jsonFileManager.getTestData("RegisterUserTest.userPassword"), jsonFileManager.getTestData("RegisterUserTest.optionForDay"), jsonFileManager.getTestData("RegisterUserTest.optionForMonth"), jsonFileManager.getTestData("RegisterUserTest.optionForYear"))
               .clickNewsLetterCheckBox()
              .clickSpecialOffersCheckBox()
              .setUserAddressInformation(jsonFileManager.getTestData("RegisterUserTest.userFirstName"),
                      jsonFileManager.getTestData("RegisterUserTest.userLastName"),
                      jsonFileManager.getTestData("RegisterUserTest.userCompanyName"),
                      jsonFileManager.getTestData("RegisterUserTest.userFirstAddress"),
                      jsonFileManager.getTestData("RegisterUserTest.userSecondAddress"),
                      jsonFileManager.getTestData("RegisterUserTest.userCountry"),
                      jsonFileManager.getTestData("RegisterUserTest.userState"),
                      jsonFileManager.getTestData("RegisterUserTest.userCity"),
                      jsonFileManager.getTestData("RegisterUserTest.userZipCode"),
                      jsonFileManager.getTestData("RegisterUserTest.userMobileNumber")
                )
              .clickCreateAccountButton();
        new AccountCreatedPage(driver)
            .assertOnAppearanceOfAccountCreatedText()
            .clickContinueButtonInAccountCreatedPage();
        new ManuHeader(driver)
        .assertOnGetUserNameAfterLogin()
        .clickDeleteAccount();
        new AccountDeletedPage(driver)
        .assertOnAppearanceOfAccountDeletedText()
        .clickContinueButtonForDelete();
    }
    @Test(description = "Register User with existing email")
    public void RegisterUserWithExistingEmail(){
        new HomePage(driver)
                .assertOnAppearanceOfFeaturesItemsInHomePage();
        new ManuHeader(driver)
                .clickSignupAndLoginLinkText();
        new SignupandLoginPage(driver)
                .assertOnAppearanceOfTheNewUserSignUpForm()
                .setNameAndEmailAddressInSignUpForm(jsonFileManager.getTestData("RegisterUserTest.userFirstName"), jsonFileManager.getTestData("LoginData.email"))
                .clickOnSignUpButton()
                .AssertOnErrorMessageAppearedAlreadyRegisteredEmail();
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











//       Assert.assertEquals(homePage.GetLoggedInText() + " " +homePage.GetUserNameAfterLogin(),"Logged in as Tasnim");

//public void goBack(){
//    driver.navigate().back();
//}
//public void goForward(){
//    driver.navigate().forward();
//}

//fluent design: ay method void fe el class btrg3 object mn el class ely hia feh .