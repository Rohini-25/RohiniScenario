import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs extends TestRunner {
    MyPageObjects myPageObjects;
   // WebDriver driver;
    @Before
    public void start(){

       // WebDriverManager.chromedriver().setup();
      //  driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        myPageObjects= new MyPageObjects(driver);
    }
    @After
    public void stop(Scenario scenario) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshotBytes, "image/png");
    }
    @Given("^User is at homepage$")
    public void userIsAtHomepage() throws InterruptedException {
        Thread.sleep(3000);
        myPageObjects.gotoHomePage();
    }

    @When("^I click on register link from nav bar$")
    public void iClickOnRegisterLinkFromNavBar() {
        myPageObjects.RegisterLinkText.click();
    }

    @Then("^I should be navigated to register page$")
    public void iShouldBeNavigatedToRegisterPage() {
        myPageObjects.enterFirstname("helen");
        myPageObjects.enterLastname("keler");
        myPageObjects.enterEmail("helenkel@testing.com");
        myPageObjects.enterPassword("roni12345!");
        myPageObjects.enterConfPassword("roni12345!");
    }

    @When("^I enter mandatory fields$")
    public void iEnterMandatoryFields() {
    }

    @And("^I click register button$")
    public void iClickRegisterButton() {
        myPageObjects.registerButton.click();
    }

    @When("^I am on home showing registration successful message$")
    public void iAmOnHomeShowingRegistrationSuccessfulMessage() {
        myPageObjects.verifyRegisterText();
    }
}
