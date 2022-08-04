package wrappers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

    public class LightningCombobox extends BaseWrapper {
        private WebDriver driver;
        private final static String BUTTON_LOCATOR = "//span[text()='%s']/ancestor::div[contains(@class, 'uiInputSelect')]//a[@class= 'select']";
        private final static String OPTION_LOCATOR = "//div[contains(@class, 'uiMenuList') and contains(@class, 'select')]//a[contains(text(), '%s')]";

        public LightningCombobox(WebDriver driver, String label) {
            super(driver, label);
        }

        public void selectByVisibleText(String visibleText) {
            WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
            scrollIntoView(button);
            button.click();

            driver.findElement(By.xpath(String.format(OPTION_LOCATOR, label, visibleText)));
            List<WebElement> allItems = driver.findElements(By.xpath(String.format(OPTION_LOCATOR, label)));
            allItems.stream().filter(webElement -> webElement.getText().equals(visibleText))
                    .findFirst()
                    .get()
                    .click();
        }

    }

