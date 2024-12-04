package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPageTest {

  private WebDriver driver;

  private void setUp() {
    driver = new ChromeDriver();
  }

  private void quit() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void registrationSuccessTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/register");
      RegistrationPage registrationPage = new RegistrationPage(driver);
      registrationPage.register("John", "Doe", "john.doe2@example.com", "Password123");

      Assert.assertTrue("Пользователь не был перенаправлен на страницу успеха.",
          registrationPage.isRedirectedToSuccessPage());

      String successMessage = registrationPage.getSuccessMessage();
      Assert.assertEquals("Your registration completed", successMessage);
    } finally {
      quit();
    }
  }

  @Test
  public void registrationAlreadyExistTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/register");
      RegistrationPage registrationPage = new RegistrationPage(driver);
      registrationPage.register("John", "Doe", "john.doe@eerxample.com", "Password123");

      WebElement accountLink = driver.findElement(By.className("validation-summary-errors"));
      Assert.assertEquals("The specified email already exists", accountLink.getText());
    } finally {
      quit();
    }
  }

  @Test
  public void registrationFailedEmailTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/register");
      RegistrationPage registrationPage = new RegistrationPage(driver);
      registrationPage.register("John", "Doe", "123afa", "Password123");

      WebElement accountLink = driver.findElement(By.className("field-validation-error"));
      Assert.assertEquals("Wrong email", accountLink.getText());
    } finally {
      quit();
    }
  }
}