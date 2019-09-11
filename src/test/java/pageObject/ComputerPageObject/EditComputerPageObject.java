package pageObject.ComputerPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.PageObject;

public class EditComputerPageObject extends PageObject {
    //locators
    @FindBy(id = "discontinued")
    private WebElement inputDiscontinuation;
    @FindBy(xpath = "//input[@class='btn primary']")
    private WebElement btnSaveComputer;
    @FindBy(xpath = "//input[@class='btn danger']")
    private WebElement btnDeleteComputer;


    public EditComputerPageObject(WebDriver driver){super(driver);}

    public void modifyDateComputer(String discontinuationDate){
        inputDiscontinuation.clear();
        enterText(inputDiscontinuation,discontinuationDate);
    }

    public void saveComputer(){ clickOnButton(btnSaveComputer); }
    public void deleteComputer(){
        clickOnButton(btnDeleteComputer);
    }

}
