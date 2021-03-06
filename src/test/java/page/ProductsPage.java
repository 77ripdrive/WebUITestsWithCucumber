package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://cloud.google.com/products/";

    @FindBy(xpath = "//a[@class='cloud-button cloud-button--secondary' and @track-name='seePricing']")
    public WebElement seePricingButton;

    public PricingPage pushSeePrising(){
        logger.info("Products page opened");
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(seePricingButton));
        seePricingButton.click();
        return new PricingPage(driver);
    }


    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ProductsPage openPage() {
        driver.navigate().to(BASE_URL);
    return new ProductsPage(driver);
    }
}
