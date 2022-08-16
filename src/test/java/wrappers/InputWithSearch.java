package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2

public class InputWithSearch extends BaseWrapper {

    private final static String INPUT_LOCATOR = "//label/span[text()='%s']/parent::label/following-sibling::div/descendant::input";


    public InputWithSearch(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        log.debug(String.format("Setting %s input value = %s", label, value));
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            System.out.printf("Setting %s input value = %s", label, value);
            System.out.println();
            inputElement.sendKeys(value);
        }
    }
}

