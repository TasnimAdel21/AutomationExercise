package framework;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v129.network.model.CookieSourceScheme;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    static WebDriver driver;
    @Step("Initializing new driver (Browser Type: {browserType} | Headless Execution: {headless})")
   public  static WebDriver intiateDriver(String browserName , boolean maximize,boolean headless){
       if (browserName.equalsIgnoreCase("chrome")){
           ChromeOptions chromeOptions;
           if (Boolean.TRUE.equals(headless)) {
               chromeOptions = new ChromeOptions();
               chromeOptions.addArguments("--headless=new");
               System.out.println("Initializing Chrome Driver | Headless Execution ....");
               driver = new ChromeDriver(chromeOptions);
               System.out.println("Chrome Driver initialized successfully....");
           } else {
               System.out.println("Initializing Chrome Driver....");
               driver = new ChromeDriver();
               System.out.println("Chrome Driver initialized successfully....");
           }
       } else if (browserName.equalsIgnoreCase("firefox")) {
           FirefoxOptions ffOptions;
           if (Boolean.TRUE.equals(headless)) {
               ffOptions = new FirefoxOptions();
               ffOptions.addArguments("--headless");
               System.out.println("Initializing Firefox Driver | Headless Execution....");
               driver = new FirefoxDriver(ffOptions);
               System.out.println("Firefox Driver initialized successfully....");
           } else {
               System.out.println("Initializing Firefox Driver....");
               driver = new FirefoxDriver();
               System.out.println("Firefox Driver initialized successfully....");
           }
       } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions;
            if (Boolean.TRUE.equals(headless)) {
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                System.out.println("Initializing Edge Driver | Headless Execution....");
                driver = new EdgeDriver(edgeOptions);
                System.out.println("Edge Driver initialized successfully....");
            } else {
                System.out.println("Initializing Edge Driver....");
                driver = new EdgeDriver();
                System.out.println("Edge Driver initialized successfully....");
            }
       } else {
           System.out.println("Initializing Safari Driver....");
           driver = new SafariDriver();
           System.out.println("Safari Driver initialized successfully....");
       }
       if (maximize){
           driver.manage().window().maximize();
           System.out.println("Browser Window will be maximized..");
       }
       return  driver;
   }
}
