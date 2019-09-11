package pageObject.ComputerPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.PageObject;

public class AddNewComputerPageObject extends PageObject {

    @FindBy(id= "name")
    private WebElement inputName;
    @FindBy(id = "introduced")
    private WebElement inputIntroduced;
    @FindBy(id = "discontinued")
    private WebElement inputDiscontinued;
    @FindBy(xpath = "//input[@class='btn primary']")
    private WebElement buttonCreateComputer;



    public AddNewComputerPageObject(WebDriver driver){super(driver);}

    public void enterComputerData (String computerName,String introduced,String discontinued,String company){
        enterText(inputName,computerName);
        enterText(inputIntroduced,introduced);
        enterText(inputDiscontinued,discontinued);
        driver.findElement(By.xpath("//option[contains(text(),'"+company+"')]")).click();
    }

    public void createComputer(){
        clickOnButton(buttonCreateComputer);
    }

}
