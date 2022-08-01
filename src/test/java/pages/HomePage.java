package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public void waitForLeadAlertLoaded() {
        waitForElementDisplayed(ALERT_LEAD_LOCATOR);
    }

    public void waitForAccountAlertLoaded() {
        waitForElementDisplayed(ALERT_ACCOUNT_LOCATOR);
    }


    public boolean isUserIconDisplayed() {
        return driver.findElement(USER_ICON_LOCATOR).isDisplayed();
    }

    public void openLeadsTab() {
        jsClick(driver.findElement(LEADS_TAB_LOCATOR));
    }

    public void openAccountsTab() {
        jsClick(driver.findElement(ACCOUNTS_TAB_LOCATOR));
    }

    public String getAlertNewLeadMessage() {
        return driver.findElement(ALERT_LEAD_LOCATOR).getText();
    }

    public String getAlertNewAccountMessage() {
        return driver.findElement(ALERT_ACCOUNT_LOCATOR).getText();
    }
}