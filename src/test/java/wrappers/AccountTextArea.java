package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class AccountTextArea extends BaseWrapper {

    private final static String TEXTAREA_LOCATOR = "//label/span[text()='%s']/parent::label/following-sibling::textarea";

    public AccountTextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement textareaElement = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(textareaElement);
            System.out.printf("Setting %s input value = %s", label, value);
            System.out.println();
            textareaElement.sendKeys(value);

        }

    }
}

