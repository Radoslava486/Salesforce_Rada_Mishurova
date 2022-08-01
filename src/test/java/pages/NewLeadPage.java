package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewLeadPage extends BasePage {

    private final static By surnameInputLocator = By.xpath("//input[@name='lastName']");
    private final static By companyInputLocator = By.xpath("//input[@name='Company']");
    private final static By saveLeadButtonLocator = By.xpath("//button[@name='SaveEdit']");


    public NewLeadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(surnameInputLocator);
    }

    public void setLastName(String lastName) {
        driver.findElement(surnameInputLocator).sendKeys(lastName);
    }


    public void setCompany(String company) {
        driver.findElement(companyInputLocator).sendKeys(company);

    }

    public void clickSave() {

        driver.findElement(saveLeadButtonLocator).click();
    }


}

