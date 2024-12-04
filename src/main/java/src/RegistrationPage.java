package src;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(id = "FirstName")
  private WebElement firstNameField;

  @FindBy(id = "LastName")
  private WebElement lastNameField;

  @FindBy(id = "Email")
  private WebElement emailField;

  @FindBy(id = "Password")
  private WebElement passwordField;

  @FindBy(id = "ConfirmPassword")
  private WebElement confirmPasswordField;

  @FindBy(id = "register-button")
  private WebElement registerButton;

  @FindBy(className = "result")
  private WebElement successMessage;

  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public void register(String firstName, String lastName, String email, String password) {
    wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
    wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
    wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    wait.until(ExpectedConditions.visibilityOf(confirmPasswordField)).sendKeys(password);
    wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
  }

  public boolean isRedirectedToSuccessPage() {
    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/registerresult/1"));
    return driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/registerresult/1");
  }

  public String getSuccessMessage() {
    wait.until(ExpectedConditions.visibilityOf(successMessage));
    return successMessage.getText();
  }
}