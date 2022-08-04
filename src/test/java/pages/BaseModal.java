package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public abstract class BaseModal extends BasePage {


        public BaseModal(WebDriver driver) {
            super(driver);
        }
        private static final By SAVE_BUTTON_LOCATOR = By.xpath("//*[@title='Save']");
        @Override
        public void waitForPageLoaded() {
            waitForElementDisplayed(SAVE_BUTTON_LOCATOR);
            waitForElementClickable(SAVE_BUTTON_LOCATOR);
        }
        public void clickSaveButton() {
            driver.findElement(SAVE_BUTTON_LOCATOR).click();
        }
    }

