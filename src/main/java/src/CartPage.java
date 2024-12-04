package src;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(css = ".button-2.product-box-add-to-cart-button")
  private WebElement addToCartButton;

  @FindBy(className = "content")
  private WebElement successNotification;

  @FindBy(linkText = "shopping cart")
  private WebElement shoppingCartLink;

  public CartPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public void addProductToCart() {
    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
  }

  public boolean isSuccessNotificationDisplayed() {
    wait.until(ExpectedConditions.visibilityOf(successNotification));
    return successNotification.isDisplayed();
  }


  public void goToShoppingCart() {
    wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
  }
}