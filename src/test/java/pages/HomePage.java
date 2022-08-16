package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class HomePage extends BasePage {
    private final static By USER_ICON_LOCATOR = By.cssSelector(".slds-avatar_profile-image-small");
    private final static By LEADS_TAB_LOCATOR = By.xpath("//*[@title='Leads']");
    private final static By ACCOUNTS_TAB_LOCATOR = By.xpath("//*[@title='Accounts']");

    private final static By ALERT_LEAD_LOCATOR = By.xpath(" //div[@aria-label='Success']");
    private final static By ALERT_ACCOUNT_LOCATOR = By.xpath("//span[text()=' was created.']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for page loaded");
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public void logout() {
        log.info("Logging out");
        driver.findElement(USER_ICON_LOCATOR).click();
        driver.findElement(By.linkText("Log Out")).click();
    }

    public void waitForLeadAlertLoaded() {
        log.info("Waiting for alert loaded");
        waitForElementDisplayed(ALERT_LEAD_LOCATOR);
    }

    public void waitForAccountAlertLoaded() {
        waitForElementDisplayed(ALERT_ACCOUNT_LOCATOR);
    }


    public boolean isUserIconDisplayed() {
        return driver.findElement(USER_ICON_LOCATOR).isDisplayed();
    }

    public void openLeadsTab() {
        log.info("Opening Leads Tab");
        jsClick(driver.findElement(LEADS_TAB_LOCATOR));
    }

    public void openAccountsTab() {
        log.info("Opening Accounts Tab");
        jsClick(driver.findElement(ACCOUNTS_TAB_LOCATOR));
    }

    public String getAlertNewLeadMessage() {
        return driver.findElement(ALERT_LEAD_LOCATOR).getText();
    }
}