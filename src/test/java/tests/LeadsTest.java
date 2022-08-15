package tests;


import enums.LeadSource;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LeadDetailsPage;
import pages.LeadsPage;
import pages.NewLeadModal;

import static enums.Industry.CHEMICALS;
import static enums.LeadSource.ADVERTISEMENT;
import static enums.LeadSource.WEB;
import static enums.LeadStatus.*;
import static enums.Rating.HOT;
import static enums.Rating.WARM;
import static enums.Salutation.MR;
import static enums.Salutation.MS;

@Log4j2

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

    @AfterMethod(alwaysRun = true)
    public void logout() {
        leadDetailsPage.logout();
        loginPage.waitForPageLoaded();
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
        newLeadModal.waitForPageLoaded();
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
                        Lead.builder().company("neft").leadStatus(NEW).lastName("Mishurova").firstName("Rada")
                                .salutation(MS).email("mishurova486@gmail.com").zipcode("34856126").rating(HOT)
                                .title("Manager").street("Skrypnikova").city("Minsk").state("Minsk").country("Belarus")
                                .website("None").phone("4586256").numberOfEmployees("3").annualRevenue("520")
                                .leadSource(WEB).industry(CHEMICALS).description("some description").build()
                },

                {
                        Lead.builder().company("qwe").leadStatus(WORKING).lastName("Alexeev").
                                salutation(MR).email("mishurova486@gmail.com").zipcode("1111").rating(WARM)
                                .street("Ratomskaya").city("Minsk").state("Minsk").country("Belarus")
                                .leadSource(ADVERTISEMENT).industry(CHEMICALS).build()
                },


                {
                        Lead.builder().company("MC").lastName("Ivanov").leadStatus(QUALIFIED).leadSource(LeadSource.SOCIAL)
                                .build()


                }
        };
    }
}