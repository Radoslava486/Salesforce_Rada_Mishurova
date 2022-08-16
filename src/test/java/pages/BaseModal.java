package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public abstract class BaseModal extends BasePage {


    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//*[@title='Save']");

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(SAVE_BUTTON_LOCATOR);
        waitForElementClickable(SAVE_BUTTON_LOCATOR);
    }

    public void clickSaveButton() {
        log.info("Clicking 'Save' button");
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}

