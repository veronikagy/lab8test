package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPageTest {

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
  public void addProductToCartTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/books");

      CartPage cartPage = new CartPage(driver);
      cartPage.addProductToCart();

      Assert.assertTrue("Уведомление об успешном добавлении товара не отображается.", cartPage.isSuccessNotificationDisplayed());
    } finally {
      quit();
    }
  }

  @Test
  public void goToShoppingCartTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/books");
      CartPage cartPage = new CartPage(driver);
      cartPage.addProductToCart();
      cartPage.goToShoppingCart();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("Мы должны находиться на странице корзины.", currentUrl.contains("cart"));
    } finally {
      quit();
    }
  }
}