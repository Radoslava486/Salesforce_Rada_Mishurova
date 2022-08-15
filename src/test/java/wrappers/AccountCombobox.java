package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class AccountCombobox extends BaseWrapper {

    private final static String BUTTON_LOCATOR = "//span[text()='%s']/parent::span/following-sibling::div/descendant::a";
    private final static String OPTION_LOCATOR = "//a[@role='menuitemradio' and contains(text(),'%s')]";

    public AccountCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        if (Objects.nonNull(visibleText)) {
            scrollIntoView(button);
            button.click();
            driver.findElement(By.xpath(String.format(OPTION_LOCATOR, visibleText))).click();
            System.out.printf("Setting %s input value = %s", label, visibleText);
        }

    }
}
