package pages;


import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Rating;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.LightningFormattedElement;

@Log4j2

public class LeadDetailsPage extends HomePage {

    private final static By ICON_LOCATOR = By.cssSelector("//img[@title='Leads']/parent::div");

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR);
    }

    public String getFullName() {
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        return fullName;
    }


    public Lead getLeadInfo() {
        log.info(String.format("Getting %s lead info", getFullName()));
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        String company = new LightningFormattedElement(driver, "Company").getText();
        String leadStatus = new LightningFormattedElement(driver, "Lead Status").getText();
        Lead.LeadBuilder leadBuilder = Lead.builder().company(company)
                .leadStatus(LeadStatus.fromString(leadStatus))
                .fullName(fullName);

        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            leadBuilder.phone(phone);
        }

        String email = new LightningFormattedElement(driver, "Email").getText();
        if (email != "") {
            leadBuilder.email(email);
        }

        String rating = new LightningFormattedElement(driver, "Rating").getText();
        if (rating != "") {
            leadBuilder.rating(Rating.fromString(rating));
        }

        String annualRevenue = new LightningFormattedElement(driver, "Annual Revenue").getText();
        if (annualRevenue != "") {
            StringBuffer revenue = new StringBuffer(annualRevenue);
            revenue.deleteCharAt(0);
            leadBuilder.annualRevenue(revenue.toString());
        }

        String numberOfEmployees = new LightningFormattedElement(driver, "No. of Employees").getText();
        if (numberOfEmployees != "") {
            leadBuilder.numberOfEmployees(numberOfEmployees);
        }
        String leadSource = new LightningFormattedElement(driver, "Lead Source").getText();
        if (leadSource != "") {
            leadBuilder.leadSource(LeadSource.fromString(leadSource));
        }

        String industry = new LightningFormattedElement(driver, "Industry").getText();
        if (industry != "") {
            leadBuilder.industry(Industry.fromString(industry));
        }
        String description = new LightningFormattedElement(driver, "Description").getText();
        if (description != "") {
            leadBuilder.description(description);
        }
        String website = new LightningFormattedElement(driver, "Website").getText();
        if (website != "") {
            leadBuilder.website(website);
        }
        String title = new LightningFormattedElement(driver, "Title").getText();
        if (title != "") {
            leadBuilder.title(title);
        }


        String fullAddress = new LightningFormattedElement(driver, "Address").getText();
        if (fullAddress != "") {
            fullAddress = fullAddress.replace(",", " ");
            fullAddress = fullAddress.replace("\n", " ");
            fullAddress = fullAddress.replace("  ", " ");
            String[] fullAddressSplit = fullAddress.split(" ");
            leadBuilder.street(fullAddressSplit[0]);
            leadBuilder.city(fullAddressSplit[1]);
            leadBuilder.state(fullAddressSplit[2]);
            leadBuilder.zipcode(fullAddressSplit[3]);
            leadBuilder.country(fullAddressSplit[4]);
        }


        return leadBuilder.build();

    }
}

