package pages;

import enums.*;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.LightningFormattedElement;

public class AccountDetailsPage extends BasePage {

    private final static By ICON_LOCATOR = By.cssSelector("//img[@title='Accounts']/parent::div");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR);
    }

    public String getAccountName() {
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        return accountName;
    }


    public Account getAccountInfo() {
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        String website = new LightningFormattedElement(driver, "Website").getText();
        String fax = new LightningFormattedElement(driver, "Fax").getText();
        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        String type = new LightningFormattedElement(driver, "Type").getText();
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        String description = new LightningFormattedElement(driver, "Description").getText();
        String annualRevenue = new LightningFormattedElement(driver, "Annual Revenue").getText();
        String employees = new LightningFormattedElement(driver, "Employees").getText();

        //lacks addresses

        return new Account.AccountBuilder(
                accountName)
                .phone(phone).annualRevenue(annualRevenue)
                .description(description)
                .website(website)
                .employees(employees)
                .industry(Industry.fromString(industry))
                .fax(fax).accountType(AccountType.fromString(type))
                .parentAccount(parentAccount)
                .build();

    }
}
