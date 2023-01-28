package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameInputField;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(className = "radius")
    WebElement loginButton;
    @FindBy(css = ".flash.success")
    WebElement successfulMessageLogout;
    @FindBy(css = ".flash.error")
    WebElement errorMessage;

    @FindBy(xpath = "//h2[contains(text(),'Login Page')]")
    WebElement headerTitle;
    @FindBy(className = "subheader")
    WebElement subheader;

    public boolean errorMessageDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(errorMessage));
        errorMessage.isDisplayed();
        return true;
    }

    public String errorMessagePrinted() {
        wdWait.until(ExpectedConditions.visibilityOf(errorMessage));
        String errorMessageText = errorMessage.getText();
        return errorMessageText;
    }

    public boolean userNameInputFieldDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.isDisplayed();
        return true;
    }

    public boolean passwordInputFieldDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.isDisplayed();
        return true;
    }

    public boolean loginButtonDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.isDisplayed();
        return true;
    }

    public boolean headerTitleDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(headerTitle));
        headerTitle.isDisplayed();
        return true;
    }

    public String headerTitlePrinted() {
        wdWait.until(ExpectedConditions.visibilityOf(headerTitle));
        String headerTitleText = headerTitle.getText();
        return headerTitleText;
    }

    public boolean subheaderDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(subheader));
        subheader.isDisplayed();
        return true;
    }

    public String subheaderPrinted() {
        wdWait.until(ExpectedConditions.visibilityOf(subheader));
        String subheaderText = subheader.getText();
        return subheaderText;
    }

    //    }
    public void usernameInputFieldSendKeys(String username) {
        wdWait.until(ExpectedConditions.visibilityOf(usernameInputField)).clear();
        usernameInputField.sendKeys(username);
    }

    public void navigateToSecurePage(String securePageUrl) {
        driver.get(securePageUrl);
    }


    public void passwordInputFieldSendKeys(String password) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
    }

    public void enterClick() {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).sendKeys(Keys.ENTER);

    }

    public void loginButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }

    public boolean successfulMessageLogoutDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulMessageLogout));
        successfulMessageLogout.isDisplayed();
        return true;
    }

    public String successfulMessageLogoutPrinted() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulMessageLogout));
        String successfulMessageText = successfulMessageLogout.getText();
        return successfulMessageText;
    }

}
