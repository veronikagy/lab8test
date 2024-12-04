package src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(id = "small-searchterms")
  private WebElement searchInput;

  @FindBy(css = ".button-1.search-box-button")
  private WebElement searchButton;

  @FindBy(className = "product-item")
  private WebElement productItem;

  @FindBy(className = "result")
  private WebElement noResultMessage;

  @FindBy(className = "warning")
  private WebElement warningMessage;

  public SearchPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public void searchForProduct(String productName) {
    wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(productName);
    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
  }

  public boolean isProductDisplayed() {
    try {
      wait.until(ExpectedConditions.visibilityOf(productItem));
      return productItem.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public String getNoResultMessage() {
    wait.until(ExpectedConditions.visibilityOf(noResultMessage));
    return noResultMessage.getText();
  }

  public boolean isNoResultMessageDisplayed() {
    return noResultMessage.isDisplayed();
  }

  public String getWarningMessage() {
    wait.until(ExpectedConditions.visibilityOf(warningMessage));
    return warningMessage.getText();
  }

  public boolean isWarningMessageDisplayed() {
    return warningMessage.isDisplayed();
  }
}