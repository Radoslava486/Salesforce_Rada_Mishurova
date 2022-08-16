package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2


public class LeadsPage extends BaseEntityPage {

    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By ICON_LOCATOR = By.cssSelector("//img[@title='Leads']/parent::div");

    public LeadsPage(WebDriver driver) {
        super(driver);
    }


    public void clickNewButton() {
        log.info("Clicking 'New' button");
        driver.findElement(NEW_BUTTON).click();
    }


}


