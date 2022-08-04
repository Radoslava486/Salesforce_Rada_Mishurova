package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LeadsPage extends BaseEntityPage {

    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By ICON_LOCATOR = By.cssSelector("//img[@title='Leads']/parent::div");

    public LeadsPage(WebDriver driver) {
        super(driver);
    }



    public void clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
    }


}


