package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.network.model.CookieSourceScheme;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;
   public  static WebDriver intiateDriver(String browserName , boolean maximize){
       if (browserName.equalsIgnoreCase("chrome")){
           System.out.println("Intializing Chrome Driver...");
           driver = new ChromeDriver();
           System.out.println("Chrome Driver intialized successfully...");
       } else if (browserName.equalsIgnoreCase("firefox")) {
           System.out.println("Intializing Firefox Driver...");
           driver = new FirefoxDriver();
           System.out.println("Firefox Driver intialized successfully...");
       }
       if (maximize){
           driver.manage().window().maximize();
           System.out.println("Browser Window will be maximized..");
       }
       return  driver;
   }
}
