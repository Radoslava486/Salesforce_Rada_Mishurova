package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BaseEntityPage {

    private static final By NEW_BUTTON = By.cssSelector("div.active a[title=New]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
    }


}