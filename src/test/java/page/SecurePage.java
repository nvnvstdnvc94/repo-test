package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecurePage extends BaseTest {
    public SecurePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="flash")
    WebElement successfulMessageLogin;
    @FindBy(xpath ="//h2[contains(text(),' Secure Area')]")
    WebElement headerTitle;
    @FindBy(className="subheader")
    WebElement subheader;
    @FindBy(css=".button.secondary.radius")
    WebElement logoutButton;
    public boolean successfulMessageLoginDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulMessageLogin));
        successfulMessageLogin.isDisplayed();
        return true;
    }
    public String successfulMessageLoginPrinted() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulMessageLogin));
        String successfulMessageText=successfulMessageLogin.getText();
        return successfulMessageText;
    }

    public boolean headerTitleDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(headerTitle));
        headerTitle.isDisplayed();
        return true;
    }
    public String headerTitlePrinted() {
        wdWait.until(ExpectedConditions.visibilityOf(headerTitle));
        String headerTitleText=headerTitle.getText();
        return headerTitleText;
    }
    public boolean logoutButtonDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.isDisplayed();
        return true;
    }
    public String subheaderPrinted() {
        wdWait.until(ExpectedConditions.visibilityOf(subheader));
        String subheaderText=subheader.getText();
        return subheaderText;
    }
    public boolean subheaderDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(subheader));
        subheader.isDisplayed();
        return true;
    }
    public void logoutButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

    }
}
