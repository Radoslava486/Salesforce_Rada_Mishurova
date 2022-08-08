package pages;


import enums.*;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.LightningFormattedElement;

public class LeadDetailsPage extends BasePage {

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
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        String company = new LightningFormattedElement(driver, "Company").getText();
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        String email = new LightningFormattedElement(driver, "Email").getText();
        String rating = new LightningFormattedElement(driver, "Rating").getText();


        String address = new LightningFormattedElement(driver, "Address").getText();
        
        String street = new LightningFormattedElement(driver, "Street").getText();
        String city = new LightningFormattedElement(driver, "City").getText();
        String state = new LightningFormattedElement(driver, "State/Province").getText();
        String zipcode = new LightningFormattedElement(driver, "Zip/Postal Code").getText();
        String country = new LightningFormattedElement(driver, "Country").getText();



        String annualRevenue = new LightningFormattedElement(driver, "Annual Revenue").getText();
        String numberOfEmployees = new LightningFormattedElement(driver, "No. of Employees").getText();
        String leadSource = new LightningFormattedElement(driver, "Lead Source").getText();
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        String description = new LightningFormattedElement(driver, "Description").getText();
        String website = new LightningFormattedElement(driver, "Website").getText();
        String title = new LightningFormattedElement(driver, "Title").getText();
        String leadStatus = new LightningFormattedElement(driver, "Lead Status").getText();
        String salutation = new LightningFormattedElement(driver, "Salutation").getText();

        return new Lead.LeadBuilder(
                company,
                LeadStatus.fromString(leadStatus))
                .fullName(fullName)
                .rating(Rating.fromString(rating))
                .email(email).phone(phone).city(city).annualRevenue(annualRevenue)
                .country(country).state(state).zipcode(zipcode)
                .description(description).street(street)
                .website(website).title(title)
                .numberOfEmployees(numberOfEmployees)
                .industry(Industry.fromString(industry))
                .salutation(Salutation.fromString(salutation))
                .leadSource(LeadSource.fromString(leadSource))
                .build();

    }
}

