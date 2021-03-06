package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TenMinuteMailPage extends AbstractPage {
    public final String BASE_URL = "https://10minutemail.net";
    private final Logger logger = LogManager.getRootLogger();
    Actions actions = new Actions(driver);
    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id='fe_text']")
    public WebElement emailFromTenMinute;
    @FindBy(xpath = "//*[@id='maillist']/tbody/tr[2]/td[1]")
    public WebElement tenMinuteMail;
    @FindBy(xpath = "//*[@id='tab1']//table/tbody/tr[2]/td[2]/h3")
    public WebElement mailTotalEstCost;

    public  String getemailFromTenMinute() {
          String emailFromTenMinuteMail = emailFromTenMinute.getAttribute("value");
    return emailFromTenMinuteMail;
    }

    public String readTotalEstimateCostFromTenMinute() {
        logger.info("Wait for GoogleEmail");
        try {
            TimeUnit.SECONDS.sleep(85);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new WebDriverWait(driver, 80)
//                .until(ExpectedConditions.elementToBeClickable(tenMinuteMail));
        logger.info("....");
        actions.moveToElement(tenMinuteMail);
        tenMinuteMail.click();
        String mailTotalEstimateCostFromTenMinuteEmail = mailTotalEstCost.getText();
        logger.info("Email from GoogleCloud with Total Coast");
        return mailTotalEstimateCostFromTenMinuteEmail;
    }
    @Override
    public TenMinuteMailPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("TenMinuteMailPage opened");
        return new TenMinuteMailPage(driver);
    }
}
