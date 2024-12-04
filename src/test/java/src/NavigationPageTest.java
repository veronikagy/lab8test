package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationPageTest {

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
  public void navigationToHomeTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToHome();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertEquals("URL главной страницы неверный", "https://demowebshop.tricentis.com/", currentUrl);
    } finally {
      quit();
    }
  }

  @Test
  public void navigationToBooksTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToBooks();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("URL для раздела 'Books' неверный", currentUrl.contains("/books"));
    } finally {
      quit();
    }
  }

  @Test
  public void navigationToComputersTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToComputers();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("URL для раздела 'Computers' неверный", currentUrl.contains("/computers"));
    } finally {
      quit();
    }
  }

  @Test
  public void navigationToApparelShoesTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToApparelShoes();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("URL для раздела 'Apparel & Shoes' неверный", currentUrl.contains("/apparel-shoes"));
    } finally {
      quit();
    }
  }

  @Test
  public void navigationToDigitalDownloadsTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToDigitalDownloads();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("URL для раздела 'Digital downloads' неверный", currentUrl.contains("/digital-downloads"));
    } finally {
      quit();
    }
  }

  @Test
  public void navigationToElectronicsTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToElectronics();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("URL для раздела 'Electronics' неверный", currentUrl.contains("/electronics"));
    } finally {
      quit();
    }
  }

  @Test
  public void navigationToJewelryTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToJewelry();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("URL для раздела 'Jewelry' неверный", currentUrl.contains("/jewelry"));
    } finally {
      quit();
    }
  }

  @Test
  public void navigationToGiftCardsTest() {
    setUp();
    try {
      driver.get("https://demowebshop.tricentis.com/");
      NavigationPage navigationPage = new NavigationPage(driver);
      navigationPage.goToGiftCards();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertTrue("URL для раздела 'Gift Cards' неверный", currentUrl.contains("/gift-cards"));
    } finally {
      quit();
    }
  }
}
