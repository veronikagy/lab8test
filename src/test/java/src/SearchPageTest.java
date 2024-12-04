package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPageTest {

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
  public void searchForExistingProductTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      SearchPage searchPage = new SearchPage(driver);
      searchPage.searchForProduct("Computer");

      Assert.assertTrue("Продукт не найден, но он должен быть в результатах поиска.", searchPage.isProductDisplayed());
    } finally {
      quit();
    }
  }

  @Test
  public void searchForNonExistentProductTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      SearchPage searchPage = new SearchPage(driver);
      searchPage.searchForProduct("NoExistentProduct");

      Assert.assertTrue("Сообщение об отсутствии результатов должно быть отображено.", searchPage.isNoResultMessageDisplayed());
      Assert.assertEquals("Не отобразилось ожидаемое сообщение об отсутствии товаров.",
          "No products were found that matched your criteria.",
          searchPage.getNoResultMessage());
    } finally {
      quit();
    }
  }

  @Test
  public void searchForShortTermTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      SearchPage searchPage = new SearchPage(driver);
      searchPage.searchForProduct("a");

      Assert.assertTrue("Сообщение о длине слова должно быть отображено.", searchPage.isWarningMessageDisplayed());
      Assert.assertEquals("Не отобразилось ожидаемое сообщение о минимальной длине поискового запроса.",
          "Search term minimum length is 3 characters",
          searchPage.getWarningMessage());
    } finally {
      quit();
    }
  }
}