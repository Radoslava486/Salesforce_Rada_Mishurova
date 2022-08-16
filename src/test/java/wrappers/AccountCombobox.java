package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2

public class AccountCombobox extends BaseWrapper {

    private final static String BUTTON_LOCATOR = "//span[text()='%s']/parent::span/following-sibling::div/descendant::a";
    private final static String OPTION_LOCATOR = "//a[@role='menuitemradio' and contains(text(),'%s')]";

    public AccountCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        log.debug(String.format("Setting %s input value = %s", label, visibleText));
        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        if (Objects.nonNull(visibleText)) {
            scrollIntoView(button);
            button.click();
            driver.findElement(By.xpath(String.format(OPTION_LOCATOR, visibleText))).click();
        }

    }
}
