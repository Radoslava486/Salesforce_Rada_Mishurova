package pages;


import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.LightningCombobox;
import wrappers.LightningInput;
import wrappers.TextArea;

@Log4j2

public class NewLeadModal extends BaseModal {

    private final static By saveLeadButtonLocator = By.xpath("//button[@name='SaveEdit']");


    public NewLeadModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for New account modal loaded");
        waitForElementDisplayed(saveLeadButtonLocator);
    }


    public void fillForm(Lead inputLead) {
        log.info(String.format("Creating new lead with name %s", inputLead.getFullName()));

        if (inputLead.getRating() != null) {
            new LightningCombobox(driver, "Rating").selectByVisibleText((inputLead.getRating().getName()));
        }
        if (inputLead.getIndustry() != null) {
            new LightningCombobox(driver, "Industry").selectByVisibleText((inputLead.getIndustry().getName()));
        }
        if (inputLead.getLeadStatus() != null) {
            new LightningCombobox(driver, "Lead Status").selectByVisibleText((inputLead.getLeadStatus().getName()));
        }
        if (inputLead.getLeadSource() != null) {
            new LightningCombobox(driver, "Lead Source").selectByVisibleText((inputLead.getLeadSource().getName()));
        }

        if (inputLead.getSalutation() != null) {
            new LightningCombobox(driver, "Salutation").selectByVisibleText((inputLead.getSalutation().getName()));
        }

        new LightningInput(driver, "First Name").setValue(inputLead.getFirstName());
        new LightningInput(driver, "Last Name").setValue(inputLead.getLastName());
        new LightningInput(driver, "Company").setValue(inputLead.getCompany());
        new LightningInput(driver, "Phone").setValue(inputLead.getPhone());
        new LightningInput(driver, "Email").setValue(inputLead.getEmail());
        new LightningInput(driver, "Title").setValue(inputLead.getTitle());

        new TextArea(driver, "Street").setValue(inputLead.getStreet());
        new TextArea(driver, "Description").setValue(inputLead.getDescription());
        new LightningInput(driver, "City").setValue(inputLead.getCity());
        new LightningInput(driver, "Zip/Postal Code").setValue(inputLead.getZipcode());
        new LightningInput(driver, "State/Province").setValue(inputLead.getState());

        new LightningInput(driver, "Country").setValue(inputLead.getCountry());
        new LightningInput(driver, "Website").setValue(inputLead.getWebsite());
        new LightningInput(driver, "No. of Employees").setValue(inputLead.getNumberOfEmployees());
        new LightningInput(driver, "Annual Revenue").setValue(inputLead.getAnnualRevenue());


    }
}



