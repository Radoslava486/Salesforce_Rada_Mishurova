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
import static enums.LeadStatus.WORKING;
import static enums.Rating.HOT;
import static enums.Rating.WARM;
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
    public void createLeadTest(Lead testLead) {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();
        newLeadModal.fillForm(testLead);
        newLeadModal.clickSaveButton();
        homePage.waitForLeadAlertLoaded();
        String actualAlertMessage = homePage.getAlertNewLeadMessage();
        String expectedAlertMessage = String.format("success\nLead \"%s\" was created.\nClose",
              leadDetailsPage.getFullName());
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        Assert.assertEquals(leadDetailsPage.getLeadInfo(), testLead);
    }

    @DataProvider(name = "newLeadData")
    public Object[][] newLeadTestData() {
        return new Object[][]{
                {
                    new Lead.LeadBuilder("neft", NEW).lastName("Mishurova").firstName("Rada").
                                salutation(MS).email("mishurova486@gmail.com").zipcode("34856126").rating(HOT).title("")
                                .street("Skrypnikova").city("Minsk").state("Minsk").country("Belarus")
                                .website("None").phone("4586256").numberOfEmployees("3").annualRevenue("520")
                                .leadSource(ADVERTISEMENT).industry(CHEMICALS).description(" ").build()
                },

                {
                        new Lead.LeadBuilder("Mila", WORKING).lastName("Ivanov").firstName("Alexey").
                                salutation(MR).email("mishurova486@gmail.com").zipcode("1111").rating(WARM).title("")
                                .street("Ratomskaya").city("Minsk").state("Minsk").country("Belarus")
                                .website("None").phone("452636").numberOfEmployees("33").annualRevenue("520")
                                .leadSource(ADVERTISEMENT).industry(CHEMICALS).description(" ").build()
                }


        };
    }

}