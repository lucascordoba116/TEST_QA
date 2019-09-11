package stepDefinition.ComputerBase;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObject.ComputerPageObject.AddNewComputerPageObject;
import pageObject.ComputerPageObject.HomeComputerPageObject;
import stepDefinition.BaseSteps;

public class AddNewComputerStepDefs extends BaseSteps {
    HomeComputerPageObject home;
    AddNewComputerPageObject addNewComputer;


    @Given("^a user who is on the Computers database page$")
    public void a_user_who_is_on_the_Computers_database_page() {
        Setup();
        home = new HomeComputerPageObject(driver);
        home.GoToHome();
    }

    @When("^you press the Add a new computer button$")
    public void you_press_the_Add_a_new_computer_button(){

        home.GoToMenu(1);

    }

    @Then("^title and loading form is displayed$")
    public void title_and_loading_form_is_displayed() {
        Assert.assertEquals(driver.getCurrentUrl(),"http://computer-database.herokuapp.com/computers/new");
    }

    @When("^you enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void you_enter_and(String arg1, String arg2, String arg3, String arg4){

        addNewComputer = new AddNewComputerPageObject(driver);
        addNewComputer.enterComputerData(arg1,arg2,arg3,arg4);
    }

    @When("^press button Create this computer$")
    public void press_button_Create_this_computer() {
        addNewComputer.createComputer();
    }

    @Then("^a computer \"([^\"]*)\" creation success message is displayed$")
    public void aComputerCreationSuccessMessageIsDisplayed(String arg0) {
        String successMessage= driver.findElement(By.xpath("//div[@class='alert-message warning']")).getText();
        String expectMessage =  "Done! Computer " + arg0 + " has been created";
        Assert.assertEquals(expectMessage,successMessage);
        closeChrome();
    }


}
