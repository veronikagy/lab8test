package src;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(className = "header-logo")
  private WebElement homeLink;

  @FindBy(linkText = "Books")
  private WebElement booksLink;

  @FindBy(linkText = "Computers")
  private WebElement computersLink;

  @FindBy(linkText = "Electronics")
  private WebElement electronicsLink;

  @FindBy(linkText = "Apparel & Shoes")
  private WebElement apparelShoesLink;

  @FindBy(linkText = "Digital downloads")
  private WebElement digitalDownloadsLink;

  @FindBy(linkText = "Jewelry")
  private WebElement jewelryLink;

  @FindBy(linkText = "Gift Cards")
  private WebElement giftCardsLink;

  public NavigationPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public void goToHome() {
    wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
  }

  public void goToBooks() {
    wait.until(ExpectedConditions.elementToBeClickable(booksLink)).click();
  }

  public void goToComputers() {
    wait.until(ExpectedConditions.elementToBeClickable(computersLink)).click();
  }

  public void goToElectronics() {
    wait.until(ExpectedConditions.elementToBeClickable(electronicsLink)).click();
  }

  public void goToApparelShoes() {
    wait.until(ExpectedConditions.elementToBeClickable(apparelShoesLink)).click();
  }

  public void goToDigitalDownloads() {
    wait.until(ExpectedConditions.elementToBeClickable(digitalDownloadsLink)).click();
  }

  public void goToJewelry() {
    wait.until(ExpectedConditions.elementToBeClickable(jewelryLink)).click();
  }

  public void goToGiftCards() {
    wait.until(ExpectedConditions.elementToBeClickable(giftCardsLink)).click();
  }
}