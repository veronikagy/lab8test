
package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditCartPageTest {

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
  public void updateProductQuantityTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      driver.findElement(By.linkText("Books")).click();
      CartPage cartPage = new CartPage(driver);
      cartPage.addProductToCart();
      cartPage.goToShoppingCart();

      EditCartPage editCartPage = new EditCartPage(driver);
      double total = Double.parseDouble(editCartPage.getCartTotal());

      editCartPage.updateProductQuantity(3);
      double total3 = total * 3;

      double updatedTotal = Double.parseDouble(editCartPage.getCartTotal());

      Assert.assertEquals(total3, updatedTotal, 0.01);
    } finally {
      quit();
    }
  }

}
