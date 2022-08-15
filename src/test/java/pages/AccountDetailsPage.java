package pages;

import enums.AccountType;
import enums.Industry;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.LightningFormattedElement;

@Log4j2

public class AccountDetailsPage extends HomePage {

    private final static By ICON_LOCATOR = By.cssSelector("//img[@title='Accounts']/parent::div");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for Account details page loaded");
        waitForElementDisplayed(ICON_LOCATOR);
    }

    public String getAccountName() {
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        return accountName;
    }


    public Account getAccountInfo() {
        log.info(String.format("Getting %s lead info", getAccountName()));
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        Account.AccountBuilder accountBuilder = Account.builder().accountName(accountName);

        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            accountBuilder.phone(phone);
        }
        String website = new LightningFormattedElement(driver, "Website").getText();
        if (website != "") {
            accountBuilder.website(website);
        }
        String fax = new LightningFormattedElement(driver, "Fax").getText();
        if (fax != "") {
            accountBuilder.fax(fax);
        }
        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        if (parentAccount != "") {
            accountBuilder.parentAccount(parentAccount);
        }
        String type = new LightningFormattedElement(driver, "Type").getText();
        if (type != "") {
            accountBuilder.type(AccountType.fromString(type));
        }
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        if (industry != "") {
            accountBuilder.industry(Industry.fromString(industry));
        }

        String description = new LightningFormattedElement(driver, "Description").getText();
        if (description != "") {
            accountBuilder.description(description);
        }
        String annualRevenue = new LightningFormattedElement(driver, "Annual Revenue").getText();
        if (annualRevenue != "") {
            StringBuffer revenue = new StringBuffer(annualRevenue);
            revenue.deleteCharAt(0);
            revenue.deleteCharAt(1);
            accountBuilder.annualRevenue(revenue.toString());

        }
        String employees = new LightningFormattedElement(driver, "Employees").getText();
        if (employees != "") {
            accountBuilder.employees(employees);
        }


        String billingAddress = new LightningFormattedElement(driver, "Billing Address").getText();
        if (billingAddress != "") {
            accountBuilder.billingAddress(billingAddress);
        }

        String shippingAddress = new LightningFormattedElement(driver, "Shipping Address").getText();
        if (shippingAddress != "") {
            accountBuilder.shippingAddress(shippingAddress);
        }


        return accountBuilder
                .build();

    }
}
