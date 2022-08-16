package wrappers;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2

public class TextArea extends BaseWrapper {

    private final static String TEXTAREA_LOCATOR = "//label[text()='%s']/following-sibling::div/textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        log.debug(String.format("Setting %s input value = %s", label, value));
        WebElement textareaElement = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(textareaElement);
            System.out.printf("Setting %s input value = %s ", label, value);
            textareaElement.sendKeys(value);

        }

    }
}