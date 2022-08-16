package tests;

import com.github.javafaker.Faker;
import enums.LeadSource;
import enums.Salutation;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;



public class ContactsTest extends BaseTest {
    private ContactsPage contactsPage;
    private NewContactModal newContactModal;
    private ContactDetailsPage contactDetailsPage;
    private static final Faker faker = new Faker();

    @BeforeClass
    public void initialise() {
        contactsPage = new ContactsPage(driver);
        newContactModal = new NewContactModal(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void logout() {
        contactDetailsPage.logout();
        loginPage.waitForPageLoaded();
    }

    @Test(dataProvider = "newContactData")
    public void createContactTest(Contact testContact) {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openContactsTab();
        contactsPage.waitForPageLoaded();
        contactsPage.clickNewButton();
        newContactModal.fillForm(testContact);
        newContactModal.clickSaveButton();
        homePage.waitForLeadAlertLoaded();
        String actualAlertMessage = homePage.getAlertNewLeadMessage();
        String expectedAlertMessage = String.format("success\nContact \"%s\" was created.\nClose",
                contactDetailsPage.getFullName());
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        Assert.assertEquals(contactDetailsPage.getContactInfo(), testContact);
    }

    @DataProvider(name = "newContactData")
    public Object[][] newContactTestData() {
        return new Object[][]{
                {
                 Contact.builder().lastName(faker.name().lastName()).accountName("Ivan Ivanov")
                        .firstName(faker.name().firstName())
                        .salutation(Salutation.MR)
                        .phone(faker.phoneNumber().phoneNumber())
                        .mobile(faker.phoneNumber().phoneNumber())
                        .email(faker.internet().emailAddress())
                        .title(faker.name().title())
                        .mailingStreet(faker.name().username())
                        .mailingCity(faker.name().username())
                        .mailingState(faker.name().username())
                        .mailingZip(faker.address().zipCode())
                        .mailingCountry(faker.name().username())
                        .otherStreet(faker.name().username())
                        .otherCity(faker.name().username())
                        .otherState(faker.name().username())
                        .otherZip(faker.address().zipCode())
                        .otherCountry(faker.name().username())
                        .fax(faker.phoneNumber().phoneNumber())
                        .homePhone(faker.phoneNumber().phoneNumber())
                        .otherPhone(faker.phoneNumber().phoneNumber())
                        .asstPhone(faker.phoneNumber().phoneNumber())
                        .assistant(faker.name().username())
                        .department(faker.name().username())
                        .leadSource(LeadSource.ADVERTISEMENT)
                        .birthdate("10/21/1997")
                        .description(faker.name().username())
                        .build()
        },

        {
                Contact.builder().lastName(faker.name().lastName()).accountName("Ivan Ivanov")
                        .leadSource(LeadSource.WEB)
                        .build()
        }
    };

    }

}