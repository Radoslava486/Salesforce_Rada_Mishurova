package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LeadsTest extends BaseTest {

    String lastName = "Ivanov";
    String company = "Lg";


    @Test
    public void createLeadTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.clickNewButton();
        newLeadPage.setLastName(lastName);
        newLeadPage.setCompany(company);
        newLeadPage.clickSave();
        homePage.waitForLeadAlertLoaded();
        String actualAlertMessage = homePage.getAlertNewLeadMessage();
        String expectedAlertMessage = String.format("success\nLead \"%s\" was created.\nClose",
                lastName);
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

    }
}