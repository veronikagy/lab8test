package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

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
  public void loginSuccessTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/login");
      LoginPage loginPage = new LoginPage(driver);
      loginPage.login("ver@mail.ru", "123456");

      WebElement accountLink = driver.findElement(By.className("ico-logout"));
      Assert.assertEquals("Некорректный адрес электронной почты", "Log out", accountLink.getText());
    } finally {
      quit();
    }
  }

  @Test
  public void loginFailedTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/login");
      LoginPage loginPage = new LoginPage(driver);
      loginPage.login("noValidUser", "123456");

      WebElement errorMessage = driver.findElement(By.className("field-validation-error"));
      Assert.assertEquals("Некорректный адрес электронной почты", "Please enter a valid email address.", errorMessage.getText());
    } finally {
      quit();
    }
  }
}