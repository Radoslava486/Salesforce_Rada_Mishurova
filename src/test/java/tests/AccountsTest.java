package tests;

import enums.AccountType;
import models.Account;
import models.Lead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import static enums.Industry.CHEMICALS;
import static enums.LeadSource.ADVERTISEMENT;
import static enums.LeadStatus.NEW;
import static enums.LeadStatus.WORKING;
import static enums.Rating.HOT;
import static enums.Rating.WARM;
import static enums.Salutation.MR;
import static enums.Salutation.MS;

public class AccountsTest extends BaseTest {
    private AccountsPage accountsPage;
    private NewAccountModal newAccountModal;
    private AccountDetailsPage accountDetailsPage;

    @BeforeClass
    public void initialise() {
        accountsPage = new AccountsPage(driver);
        newAccountModal = new NewAccountModal(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
    }

    @Test(dataProvider = "newAccountData")
    public void createAccountTest(Account testAccount) {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openAccountsTab();
        accountsPage.waitForPageLoaded();
        accountsPage.clickNewButton();
        newAccountModal.fillForm(testAccount);
        newAccountModal.clickSaveButton();
        homePage.waitForLeadAlertLoaded();
        String actualAlertMessage = homePage.getAlertNewLeadMessage();
        String expectedAlertMessage = String.format("success\nAccount \"%s\" was created.\nClose",
                accountDetailsPage.getAccountName());
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        Assert.assertEquals(accountDetailsPage.getAccountInfo(), testAccount);
    }

    @DataProvider(name = "newAccountData")
    public Object[][] newAccountTestData() {
        return new Object[][]{
                {
                        new Account.AccountBuilder("Sasha Bely").accountType(AccountType.ANALYST)
                                .annualRevenue("5689").employees("5")
                                .description("hUGE")
                                .fax("78965236896")
                                .phone("889662148")
                                .industry(CHEMICALS)
                                .description(" ")
                                .build()
                }


        };
    }

}