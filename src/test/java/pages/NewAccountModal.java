package pages;

import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.*;

public class NewAccountModal extends BasePage {

    private static final By SAVE_BUTTON_LOCATOR = By.cssSelector("button[title = 'Save']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(SAVE_BUTTON_LOCATOR);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }

    public void fillForm(Account inputAccount) {

        new AccountInput(driver, "Phone").setValue(inputAccount.getPhone());
        new AccountInput(driver, "Fax").setValue(inputAccount.getFax());
        new AccountInput(driver, "Website").setValue(inputAccount.getWebsite());
        new InputWithSearch(driver, "Account Name").setValue(inputAccount.getAccountName());
        new InputWithSearch(driver, "Parent Account").setValue(inputAccount.getParentAccount());
        new AccountCombobox(driver, "Industry").selectByVisibleText((inputAccount.getIndustry().getName()));
        new AccountCombobox(driver, "Type").selectByVisibleText((inputAccount.getType().getName()));
        new AccountInput(driver, "Employees").setValue(inputAccount.getEmployees());
        new AccountInput(driver, "Annual Revenue").setValue(inputAccount.getAnnualRevenue());
        new AccountTextArea(driver, "Description").setValue(inputAccount.getDescription());
        new AccountTextArea(driver, "Billing Street").setValue(inputAccount.getBillingStreet());
        new AccountTextArea(driver, "Shipping Street").setValue(inputAccount.getShippingStreet());
        new AccountInput(driver, "Billing City").setValue(inputAccount.getBillingCity());
        new AccountInput(driver, "Billing State/Province").setValue(inputAccount.getBillingStateProvince());
        new AccountInput(driver, "Billing Zip/Postal Code").setValue(inputAccount.getBillingZipPostalCode());
        new AccountInput(driver, "Billing Country").setValue(inputAccount.getBillingCountry());
        new AccountInput(driver, "Shipping City").setValue(inputAccount.getShippingCity());
        new AccountInput(driver, "Shipping Zip/Postal Code").setValue(inputAccount.getShippingZipPostalCode());
        new AccountInput(driver, "Shipping State/Province").setValue(inputAccount.getShippingStateProvince());
        new AccountInput(driver, "Shipping Country").setValue(inputAccount.getShippingCountry());







    }

}