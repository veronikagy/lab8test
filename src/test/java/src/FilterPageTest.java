package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilterPageTest {

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
  public void filterProductsUnder25Test() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/books");
      FilterPage filterPage = new FilterPage(driver);

      filterPage.filterUnder25Filter();

      int productCount = filterPage.getFilteredProductCount();
      Assert.assertTrue(productCount > 0);
      Assert.assertTrue(filterPage.isProductDisplayed("Computing and Internet\n"
          + "30.00\n"
          + "10.00"));
    } finally {
      quit();
    }
  }

  @Test
  public void filterProductsFrom25To50Test() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/books");
      FilterPage filterPage = new FilterPage(driver);

      filterPage.filterFrom25To50Filter();

      Assert.assertTrue("Ожидалось, что продукты не будут найдены.", filterPage.isNoProductsDisplayed());

    } finally {
      quit();
    }
  }

  @Test
  public void filterProductsOver50Test() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/books");
      FilterPage filterPage = new FilterPage(driver);

      filterPage.filterOver50Filter();

      int productCount = filterPage.getFilteredProductCount();
      Assert.assertTrue( productCount > 0);
      Assert.assertTrue(filterPage.isProductDisplayed("Science\n"
          + "67.00\n"
          + "51.00"));
    } finally {
      quit();
    }
  }

}