package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import drivers.WebDriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.PropertyLoader;

import java.time.Duration;

public class LoginStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private PropertyLoader propertyLoader;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        propertyLoader = new PropertyLoader();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open();
    }

    @When("I enter credentials for valid user {int}")
    public void iEnterValidCredentialsForUser2(int index) {
        String username = propertyLoader.getUsername(index);
        String password = propertyLoader.getPassword(index);

        loginPage.enterCredentials(username, password);
        if (loginPage.isLoginSuccessful()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        }
    }

    @When("I enter credentials for invalid user {int}")
    public void iEnterInvalidCredentialsForUser(int index) {
        String username = propertyLoader.getInvalidUsername(index);
        String password = propertyLoader.getInvalidPassword(index);

        loginPage.enterCredentials(username, password);
    }

    @Then("I should see the error message for invalid user {int}")
    public void iShouldSeeTheErrorMessageForInvalidUser(int index) {

        String expectedErrorMessage = propertyLoader.getErrorMessage(index);
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() {
        String pageTitle = loginPage.getPageTitle();
        assertEquals("Products", pageTitle);
    }

    @And("I sign out")
    public void iSignOut() {
        loginPage.signOut();
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.quit();
    }
}