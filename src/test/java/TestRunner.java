import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(//features={"src/test/resources/register.feature"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}
        //tags = {"@test"}
)
public class TestRunner {
    static WebDriver driver;
    public static final String USERNAME = "rohini51";
    public static final String AUTOMATE_KEY = "7tYqduB9ruwBbWYTW8AJ";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    @BeforeClass
    public static void startBrowser() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "83.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("resolution", "1024x768");
    caps.setCapability("name", "Rohini Test");

       // try {
            driver = new RemoteWebDriver(new URL(URL), caps);
       // } catch (MalformedURLException e) {
           // e.printStackTrace();
       // }
    }

    @AfterClass
    public static void stopBrowser()
    {
        driver.quit();

    }

}
