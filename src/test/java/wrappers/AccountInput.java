package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class AccountInput extends BaseWrapper{


    public AccountInput(WebDriver driver, String label) {
        super(driver, label);

    }
    private final static String INPUT_LOCATOR = "//label/span[text()='%s']/parent::label/following-sibling::input";

    public void setValue(String value){
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if(Objects.nonNull(value)){
            scrollIntoView(inputElement);
            System.out.printf("Setting %s input value = %s", label, value);
            System.out.println();
            inputElement.sendKeys(value);
        }
    }
}


