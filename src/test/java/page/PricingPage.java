package page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://cloud.google.com/pricing/";

    @FindBy(xpath = "//*[@id='cloud-site']//a[@track-name='pricingNav/calculators']")
    private WebElement pricingNavigationCalculators;


    public CalculatorPage pushPricingNavigationCalculators(){
        pricingNavigationCalculators.click();
        return new CalculatorPage(driver);
    }

    protected PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected PricingPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Pricing page opened");
        return this;
    }
}
