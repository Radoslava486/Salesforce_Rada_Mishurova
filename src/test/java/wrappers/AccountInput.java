package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2

public class AccountInput extends BaseWrapper {


    private final static String INPUT_LOCATOR = "//label/span[text()='%s']/parent::label/following-sibling::input";

    public AccountInput(WebDriver driver, String label) {
        super(driver, label);

    }

    public void setValue(String value) {
        log.debug(String.format("Setting %s input value = %s", label, value));
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }
}


