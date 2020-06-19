import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPageObjects {
    WebDriver driver;

    @FindBy(className = "ico-register")
    public WebElement RegisterLinkText;

    @FindBy(id="gender-female")
    public WebElement femaleRadioButton;

    @FindBy(id="FirstName")
    public WebElement firstNameTextBox;

    @FindBy(id="LastName")
    public WebElement lastNameTextBox;

    @FindBy(id="Email")
    public WebElement emailTextBox;

    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(id="ConfirmPassword")
    public WebElement confPasswordTextBox;

    //register-button

    @FindBy(css="input#register-button")
    public WebElement registerButton;

    @FindBy(css="div.result")
    public WebElement resultText;
    public MyPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void gotoHomePage(){
        driver.get("http://twentyconsulting-001-site1.dtempurl.com/");
    }
    public void enterFirstname(String fn)
    {
        firstNameTextBox.sendKeys("Helen");
    }

    public void enterLastname(String ln)
    {
        lastNameTextBox.sendKeys("keler");
    }
    public void enterEmail(String email)
    {
        emailTextBox.sendKeys("helenkel@testing.com");
    }

    public void enterPassword(String pw)
    {
        passwordTextBox.sendKeys("roni12345!");
    }
    public void enterConfPassword(String cpw)
    {
        confPasswordTextBox.sendKeys("roni12345!");
    }

    public void clickFemaleRadioButton()
    {
        femaleRadioButton.click();
    }

    public void clickRegisterButton()
    {
        registerButton.click();
    }


    public String verifyRegisterText()
    {
        return resultText.getText();
    }
}
