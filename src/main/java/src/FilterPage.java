package src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FilterPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(linkText = "Under 25.00")
  private WebElement under25Filter;

  @FindBy(linkText = "25.00 - 50.00")
  private WebElement from25To50Filter;

  @FindBy(linkText = "Over 50.00")
  private WebElement over50Filter;

  @FindBy(css = ".product-item")
  private List<WebElement> productItems;

  public FilterPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public void filterUnder25Filter() {
    wait.until(ExpectedConditions.elementToBeClickable(under25Filter)).click();
  }
  public void filterFrom25To50Filter() {
    wait.until(ExpectedConditions.elementToBeClickable(from25To50Filter)).click();
  }
  public void filterOver50Filter() {
    wait.until(ExpectedConditions.elementToBeClickable(over50Filter)).click();
  }

  public int getFilteredProductCount() {
    return productItems.size();
  }

  public boolean isProductDisplayed(String productName) {
    for (WebElement item : productItems) {
      if (item.getText().equalsIgnoreCase(productName)) {
        return true;
      }
    }
    return false;
  }

  public boolean isNoProductsDisplayed() {
    return productItems.isEmpty();
  }
}