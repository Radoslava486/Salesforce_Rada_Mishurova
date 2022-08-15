package wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseWrapper {
    protected WebDriver driver;
    String label;

    public BaseWrapper(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
