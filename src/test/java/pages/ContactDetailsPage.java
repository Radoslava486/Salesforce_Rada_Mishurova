package pages;

import enums.AccountType;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import models.Lead;
import org.openqa.selenium.WebDriver;
import wrappers.LightningFormattedElement;
@Log4j2

public class ContactDetailsPage extends HomePage {


    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }


    public String getFullName() {
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        return fullName;
    }
    public Contact getContactInfo(){
        log.debug(String.format("Getting %s contact info", getFullName()));
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        accountName = accountName.replace("Open", "");
        accountName = accountName.replace("Preview", "");
        accountName = accountName.trim();
        Contact.ContactBuilder contactBuilder = Contact.builder()
                .fullName(fullName).accountName(accountName);


        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            contactBuilder.phone(phone);
        }
        String mobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (mobile != "") {
            contactBuilder.mobile(mobile);
        }
        String email = new LightningFormattedElement(driver, "Email").getText();
        if (email != "") {
            contactBuilder.email(email);
        }
        String title = new LightningFormattedElement(driver, "Title").getText();
        if (title != "") {
            contactBuilder.title(title);
        }
        String reportsTo = new LightningFormattedElement(driver, "Reports To").getText();
        if (reportsTo != "") {
            contactBuilder.reportsTo(reportsTo);
        }
        String fax = new LightningFormattedElement(driver, "Fax").getText();
        if (fax != "") {
            contactBuilder.fax(fax);
        }
        String homePhone = new LightningFormattedElement(driver, "Home Phone").getText();
        if (homePhone != "") {
            contactBuilder.homePhone(homePhone);
        }
        String otherPhone = new LightningFormattedElement(driver, "Other Phone").getText();
        if (otherPhone != "") {
            contactBuilder.otherPhone(otherPhone);
        }
        String asstPhone = new LightningFormattedElement(driver, "Asst. Phone").getText();
        if (asstPhone != "") {
            contactBuilder.asstPhone(asstPhone);
        }
        String assistant = new LightningFormattedElement(driver, "Assistant").getText();
        if (assistant != "") {
            contactBuilder.assistant(assistant);
        }
        String department = new LightningFormattedElement(driver, "Department").getText();
        if (department != "") {
            contactBuilder.department(department);
        }
        String leadSource = new LightningFormattedElement(driver, "Lead Source").getText();
        if (leadSource != "") {
            contactBuilder.leadSource(LeadSource.fromString(leadSource));
        }
        String birthdate = new LightningFormattedElement(driver, "Birthdate").getText();
        if (birthdate != "") {
            contactBuilder.birthdate(birthdate);
        }
        String description = new LightningFormattedElement(driver, "Description").getText();
        if (description != "") {
            contactBuilder.description(description);
        }

        String mailingAddress = new LightningFormattedElement(driver, "Mailing Address").getText();
        if (mailingAddress != "") {
            contactBuilder.mailingAddress(mailingAddress);
        }

        String otherAddress = new LightningFormattedElement(driver, "Other Address").getText();
        if (otherAddress != "") {
            contactBuilder.otherAddress(otherAddress);
        }
        return contactBuilder
                .build();
    }
}


