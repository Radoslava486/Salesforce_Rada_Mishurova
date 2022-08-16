package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class LoginPage extends BasePage {

    private final static String URL = "https://tms45.my.salesforce.com/";
    private final static By usernameInput = By.cssSelector("input#username");
    private final static By passwordInput = By.cssSelector("input#password");
    private final static By loginButton = By.cssSelector("input#Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for login page loaded");
        waitForElementDisplayed(usernameInput);
    }

    public void setUserName(String userName) {
        log.info(String.format("Setting username = %s", userName));
        driver.findElement(usernameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        log.info(String.format("Setting password = %s", password));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        log.info("Clicking 'Login' button");
        driver.findElement(loginButton).click();
    }

    public void open() {
        driver.get(URL);
    }
}