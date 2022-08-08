package wrappers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



    public class LightningCombobox extends BaseWrapper {

        private final static String BUTTON_LOCATOR = "//label[text()='%s']/following-sibling::div//button";
        private final static String OPTION_LOCATOR = "//lightning-base-combobox-item[@data-value='%s']";

        public LightningCombobox(WebDriver driver, String label) {
            super(driver, label);
        }

        public void selectByVisibleText(String visibleText) {
            WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
            scrollIntoView(button);
            button.click();
            driver.findElement(By.xpath(String.format(OPTION_LOCATOR, visibleText))).click();
            System.out.printf("Setting %s input value = %s", label, visibleText);
        }

    }

