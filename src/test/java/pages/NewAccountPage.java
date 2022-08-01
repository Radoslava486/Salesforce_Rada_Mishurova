package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage extends BasePage {

    private static final By ACCOUNTNAME_INPUT_LOCATOR = By.xpath("//label/span[text() = 'Account Name']/parent::label/following-sibling::div//input");
    private static final By SAVE_BUTTON_LOCATOR = By.cssSelector("button[title = 'Save']");

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ACCOUNTNAME_INPUT_LOCATOR);
    }

    public void setAccountName(String accountName) {
        driver.findElement(ACCOUNTNAME_INPUT_LOCATOR).sendKeys(accountName);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }


}