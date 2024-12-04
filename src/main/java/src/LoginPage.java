package src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  private WebDriver driver;

  @FindBy(id = "Email")
  private WebElement usernameField;

  @FindBy(id = "Password")
  private WebElement passwordField;

  @FindBy(className = "login-button")
  private WebElement loginButton;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void login(String username, String password) {
    usernameField.sendKeys(username);
    passwordField.sendKeys(password);
    loginButton.click();
  }
}