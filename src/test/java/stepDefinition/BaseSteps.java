package stepDefinition;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSteps {
    protected WebDriver driver;

    public void Setup(){
        System.setProperty("webdriver.chrome.driver","utils\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void closeChrome(){
        driver.quit();
    }

}
