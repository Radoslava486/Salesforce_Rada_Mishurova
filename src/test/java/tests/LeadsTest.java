package tests;

import enums.*;
import models.Lead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LeadDetailsPage;
import pages.LeadsPage;
import pages.NewLeadModal;

import static enums.Industry.CHEMICALS;
import static enums.LeadSource.ADVERTISEMENT;
import static enums.LeadStatus.NEW;
import static enums.Rating.HOT;
import static enums.Salutation.MR;
import static enums.Salutation.MS;

public class LeadsTest extends BaseTest {
    private LeadsPage leadsPage;
    private NewLeadModal newLeadModal;
    private LeadDetailsPage leadDetailsPage;

    @BeforeClass
    public void initialise() {
        leadsPage = new LeadsPage(driver);
        newLeadModal = new NewLeadModal(driver);
        leadDetailsPage = new LeadDetailsPage(driver);
    }

    @Test(dataProvider = "newLeadData")
    public void createLeadTest(String firstName, String lastName, String company, Salutation salutation, String title, String email, String phone, LeadStatus leadStatus, Rating rating, String street, String city, String state, String country, String website, String zipcode, String numberOfEmployees, String annualRevenue, LeadSource leadSource, Industry industry, String description) {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();


       Lead testLead = new Lead.LeadBuilder(firstName, leadStatus)
                .build();
        newLeadModal.fillForm(testLead);
        newLeadModal.clickSaveButton();
        homePage.waitForLeadAlertLoaded();
        String actualAlertMessage = homePage.getAlertNewLeadMessage();
        String expectedAlertMessage = String.format("success\nLead \"%s\" was created.\nClose",
                lastName);
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        Assert.assertEquals(leadDetailsPage.getLeadInfo(), testLead);
    }

    @DataProvider(name = "newLeadData")
    public Object[][] newLeadTestData() {
        return new Object[][]{
                {"Radoslava", "Mishurova", "Lebyazhiy", MS, "DFGH", "mishurova486", "34856126", NEW, HOT, "Skrypnikova", "Minsk", "Minsk", "Belarus", "None", "4586256", "3", "520", ADVERTISEMENT, CHEMICALS, " "},
                {"DMITRIY", "IVANOV", "LG", MR, "DFGH", "mishurova486", "34856126", NEW, HOT, "Skrypnikova", "Minsk", "Minsk", "Belarus", "None", "4586256", "17", "520", ADVERTISEMENT, CHEMICALS, " "},
        };
    }
}
