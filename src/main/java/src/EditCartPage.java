package src;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCartPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(className = "qty-input")
  private WebElement quantityInput;

  @FindBy(name = "updatecart")
  private WebElement updateCartButton;

  @FindBy(className = "remove-from-cart")
  private WebElement removeFromCartButton;


  @FindBy(className = "cart-total-right")
  private WebElement cartTotal;

  @FindBy(className = "order-summary-content")
  private WebElement emptyCart;

  public EditCartPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public void updateProductQuantity(int quantity) {
    wait.until(ExpectedConditions.visibilityOf(quantityInput)).clear();
    quantityInput.sendKeys(String.valueOf(quantity));
    wait.until(ExpectedConditions.elementToBeClickable(updateCartButton)).click();
  }


  public String getCartTotal() {
    wait.until(ExpectedConditions.visibilityOf(cartTotal));
    return cartTotal.getText();
  }

}
