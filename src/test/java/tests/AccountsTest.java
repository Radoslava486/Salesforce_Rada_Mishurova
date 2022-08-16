package tests;

import enums.AccountType;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import pages.NewAccountModal;

import static enums.Industry.CHEMICALS;

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

    @AfterMethod(alwaysRun = true)
    public void logout() {
        accountDetailsPage.logout();
        loginPage.waitForPageLoaded();
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
                        Account.builder().accountName("Sasha Bely").type(AccountType.ANALYST)
                                .annualRevenue("5689").employees("5")
                                .fax("78965236896")
                                .phone("889662148")
                                .industry(CHEMICALS)
                                .website("none")
                                .description("some description")
                                .billingCity("Minsk")
                                .billingCountry("Belarus")
                                .billingStreet("ghf")
                                .billingZipPostalCode("564789")
                                .billingStateProvince("Minsk")
                                .shippingCity("Minsk")
                                .shippingCountry("Sweden")
                                .shippingStreet("5th Avenue")
                                .shippingZipPostalCode("456789")
                                .shippingStateProvince("London")
                                .build()
                },

                {
                        Account.builder().accountName("Ivan Ivanov")
                                .build()
                }


        };
    }

}