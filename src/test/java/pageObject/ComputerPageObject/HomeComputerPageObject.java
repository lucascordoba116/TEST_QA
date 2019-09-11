package pageObject.ComputerPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.PageObject;

public class HomeComputerPageObject extends PageObject {



    public HomeComputerPageObject(WebDriver driver){super(driver);}

    public void GoToHome(){
        GoToUrl("http://computer-database.herokuapp.com/computers");
    }

    public void GoToMenu(int arg) {
        switch (arg) {
            case 1:
                clickOnButton(driver.findElement(By.id("add")));
                break;
            case 2:clickOnButton(driver.findElement(By.id("searchsubmit")));
            break;
            default:
                break;

        }
    }

        public void FindComputer (String nameComputer){
            WebElement inputSearch = driver.findElement(By.id("searchbox"));
            inputSearch.click();
             enterText(inputSearch,nameComputer);
        }

        public void selectComputerToEdit(String nameComputer){
        clickOnButton(driver.findElement(By.xpath("//a[contains(text(),'"+ nameComputer +"')]")));
        }










}
