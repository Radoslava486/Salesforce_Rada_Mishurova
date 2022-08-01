package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {
    String accountName = "Account Name";

    @Test
    public void createAccountTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openAccountsTab();
        accountsPage.waitForPageLoaded();
        accountsPage.clickNewButton();
        newAccountPage.setAccountName(accountName);
        newAccountPage.clickSaveButton();
        homePage.waitForAccountAlertLoaded();
        String actualAlertMessage = homePage.getAlertNewAccountMessage();
        String expectedAlertMessage = String.format("Account \"%s\" was created.", accountName);
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

    }
}
