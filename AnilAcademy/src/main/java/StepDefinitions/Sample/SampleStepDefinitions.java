package StepDefinitions.Sample;

import Helpers.helper;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SampleStepDefinitions {
    public WebDriver wd;
    helper help=new helper(wd);

    public SampleStepDefinitions() {
        this.wd=help.getWebDriver();
    }
    @Given("User logged into Sample Website")
    public void userLoggedIntoSampleWebsite() {
        help.launchBrowser();
    }

    @When("user logged in with Username and password")
    public void userLoggedInWithUsernameAndPassword() {
        System.out.println("Java");
    }

    @Then("Verify user is on Sample website")
    public void verifyUserIsOnSampleWebsite() {
        System.out.println("Java");
    }

    @When("user logged in with {string} and {string}")
    public void userLoggedInWithAnd(String arg0, String arg1) {
        System.out.println("Java"+arg0+arg1);
    }
    @After
    public void CloseBrowser(){
       help.afterScenario();
    }

    @Given("User logged into topgeek Website")
    public void userLoggedIntoTopgeekWebsite() {
        help.launchBrowser();

    }

    @When("user performes search with {string}")
    public void userPerformesSearchWith(String value) {
        wd.findElement(By.xpath("//input[@placeholder='Search Blog']")).sendKeys(value);
        wd.findElement(By.xpath("//button[text()='Search']")).click();

    }


    @Then("Verify valid  {string} search is performed")
    public void verifyValidSearchIsPerformed(String value) {
        List<WebElement> values=wd.findElements(By.xpath("//div[@class='css-103otoi']//div[@href]/p[1]"));
        for (WebElement element : values) {
            if (element.getText().contains(value)) {
                System.out.println("Value is present");
                break;
            } else {
                System.out.println("Value is not present");

            }
        }
    }
}
