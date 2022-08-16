package wrappers;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2


public class LightningFormattedElement extends BaseWrapper {

    String visibleTextLocator = "//div[contains(@class, 'active')]//span[text() = '%s' and @class='test-id__field-label']/ancestor::div[contains(@class, 'test-id__output-root')]//*[@data-output-element-id='output-field']";

    public LightningFormattedElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        log.debug(String.format("Getting %s value", label));
        WebElement outputElement = driver.findElement(By.xpath(String.format(visibleTextLocator, label)));
        scrollIntoView(outputElement);
        return outputElement.getText();
    }
}

