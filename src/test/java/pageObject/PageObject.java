package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected static WebDriver driver;

    public PageObject (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this    );
    }

    protected void GoToUrl(String url){
        driver.get(url);
    }

    protected void clickOnButton(WebElement btn){
        btn.click();
    }

    protected void enterText(WebElement inputElement,String txt){
        inputElement.sendKeys(txt);
    }
}
