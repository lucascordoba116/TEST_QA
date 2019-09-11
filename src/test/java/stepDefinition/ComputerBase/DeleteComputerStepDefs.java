package stepDefinition.ComputerBase;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObject.ComputerPageObject.EditComputerPageObject;
import pageObject.ComputerPageObject.HomeComputerPageObject;
import stepDefinition.BaseSteps;

public class DeleteComputerStepDefs extends BaseSteps {
    HomeComputerPageObject home;
    EditComputerPageObject editComputer;


    @Given("^a user who is on the home page$")
    public void aUserWhoIsOnTheHomePage() {
        Setup();
        home = new HomeComputerPageObject(driver);
        home.GoToHome();
    }

    @When("^looking for \"([^\"]*)\" computer$")
    public void lookingForComputer1(String arg0) {
        home.FindComputer(arg0);
        home.GoToMenu(2);
    }
    @Then("^it shows that one result was found$")
    public void itShowsThatOneResultWasFound() {
        String titule= driver.findElement(By.xpath("//h1[contains(text(),'One computer found')]")).getText();
        Assert.assertEquals(titule,"One computer found");
    }

    @When("^you select the computer \"([^\"]*)\"$")
    public void youSelectTheComputer(String arg0) {
        home.selectComputerToEdit(arg0);

    }
    @Then("^the computer edit page open$")
    public void theComputerEditPageOpen() {
        String  tituleEdit= driver.findElement(By.xpath("//h1[contains(text(),'Edit computer')]")).getText();
        Assert.assertEquals(tituleEdit,"Edit computer");
        editComputer = new EditComputerPageObject(driver);
    }

    @When("^you press the Delete button$")
    public void youPressTheDeleteButton() throws Throwable{
        editComputer.deleteComputer();
    Thread.sleep(3000);
    }

    @Then("^the message that the computer was deleted is displayed$")
    public void theMessageThatTheComputerWasDeletedIsDisplayed() {
        String massageUpdate = driver.findElement(By.xpath("//div[@class='alert-message warning']")).getText();
        Assert.assertEquals(massageUpdate,"Done! Computer has been deleted");
        closeChrome();
    }

}
