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

public class ModifyComputerStepDefs extends BaseSteps {
    HomeComputerPageObject home;
    EditComputerPageObject editComputer;
    String nameComputer= "RV420V";

    @Given("^a user who is on the home page computer$")
    public void aUserWhoIsOnTheHomePageComputer() {
        Setup();
        home = new HomeComputerPageObject(driver);
        home.GoToHome();
    }

    @When("^looking for RV420V computer$")
    public void lookingForComputer() throws Throwable{
        home.FindComputer(nameComputer);
        home.GoToMenu(2);
    }

    @Then("^it shows that only one result was found$")
    public void itShowsThatOnlyOneResultWasFound() {
        String titule= driver.findElement(By.xpath("//h1[contains(text(),'One computer found')]")).getText();
        Assert.assertEquals(titule,"One computer found");
    }

    @When("^you select the computer$")
    public void youSelectTheComputer() {
        home.selectComputerToEdit(nameComputer);
    }

    @Then("^the computer edit page opens$")
    public void theComputerEditPageOpens() {
        String  tituleEdit= driver.findElement(By.xpath("//h1[contains(text(),'Edit computer')]")).getText();
        Assert.assertEquals(tituleEdit,"Edit computer");
        editComputer = new EditComputerPageObject(driver);
    }

    @When("^you enter the discontinuation date and click Save$")
    public void youEnterTheDiscontinuationDateAndClickSave() {
        String discontinuedDate = "2019-09-10";
        editComputer.modifyDateComputer(discontinuedDate);
        editComputer.saveComputer();
    }

    @Then("^the update exist message is displayed$")
    public void theUpdateExistMessageIsDisplayed() {
        String massageUpdate = driver.findElement(By.xpath("//div[@class='alert-message warning']")).getText();
        Assert.assertEquals(massageUpdate,"Done! Computer RV420V has been updated");
        closeChrome();
    }


}
