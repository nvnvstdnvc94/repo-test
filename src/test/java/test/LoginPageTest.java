package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.LoginPage;
import page.SecurePage;
import java.util.Random;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    SecurePage securePage;
    String validPassword =
            "SuperSecretPassword!";
    String validUsername = "tomsmith";
    String messageSuccessfulLogin =
            "You logged into a secure area!\n" +
                    "×";
    String messageSuccessfulLogout =
            "You logged out of the secure area!\n" +
                    "×";

    String headerTitleSecurePage = "Secure Area";
    String subheaderSecurePage =
            "Welcome to the Secure Area. When you are done click logout below.";
    String subheaderLoginPage =
            "This is where you can log into the secure area. Enter tomsmith " +
                    "for the username and SuperSecretPassword! for the password. " +
                    "If the information is wrong you should see error messages.";
    String headerTitleLoginPage = "Login Page";
    String errorMessageWithBlankFieldsOrInvalidUsernameOrBlankUsername =
            "Your username is invalid!\n" +
                    "×";
    String errorMessagewithBlankOrInvalidlPassword =
            "Your password is invalid!\n" +
                    "×";
    String errorMessageForNavigatingOnSecurePageWithoutLogging =
            "You must login to view the secure area!\n" +
                    "×";
    Random random = new Random();
    String invalidPassword = "pas" + random.nextInt(9999);
    String invalidUsername = "user" + random.nextInt(9999);
    String securePageUrl = "https://the-internet.herokuapp.com/secure";

    @Before
    public void setUpTest() {
        loginPage = new LoginPage();
        securePage = new SecurePage();
    }

    @Test
    public void successfulLoginWithLoginButtonClick() {
        loginPage.usernameInputFieldSendKeys(validUsername);
        loginPage.passwordInputFieldSendKeys(validPassword);
        loginPage.loginButtonClick();
        Assert.assertTrue(securePage.successfulMessageLoginDisplayed());
        Assert.assertEquals(messageSuccessfulLogin, securePage.successfulMessageLoginPrinted());
        Assert.assertTrue(securePage.headerTitleDisplayed());
        Assert.assertEquals(headerTitleSecurePage, securePage.headerTitlePrinted());
        Assert.assertTrue(securePage.subheaderDisplayed());
        Assert.assertEquals(subheaderSecurePage, securePage.subheaderPrinted());
        Assert.assertTrue(securePage.logoutButtonDisplayed());
        securePage.logoutButtonClick();
        Assert.assertTrue(loginPage.successfulMessageLogoutDisplayed());
        Assert.assertEquals(messageSuccessfulLogout, loginPage.successfulMessageLogoutPrinted());
        Assert.assertTrue(loginPage.headerTitleDisplayed());
        Assert.assertEquals(headerTitleLoginPage, loginPage.headerTitlePrinted());
        Assert.assertTrue(loginPage.subheaderDisplayed());
        Assert.assertEquals(subheaderLoginPage, loginPage.subheaderPrinted());
        Assert.assertTrue(loginPage.loginButtonDisplayed());
        Assert.assertTrue(loginPage.userNameInputFieldDisplayed());
        Assert.assertTrue(loginPage.passwordInputFieldDisplayed());
        driver.navigate().refresh();
    }

    @Test
    public void successfulLoginWithEnterClick() {
        loginPage.usernameInputFieldSendKeys(validUsername);
        loginPage.passwordInputFieldSendKeys(validPassword);
        loginPage.enterClick();
        Assert.assertTrue(securePage.successfulMessageLoginDisplayed());
        Assert.assertEquals(messageSuccessfulLogin, securePage.successfulMessageLoginPrinted());
        Assert.assertTrue(securePage.headerTitleDisplayed());
        Assert.assertEquals(headerTitleSecurePage, securePage.headerTitlePrinted());
        Assert.assertTrue(securePage.logoutButtonDisplayed());
    }

    @Test
    public void unsuccessfulLoginBlankFields() {
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        Assert.assertEquals(errorMessageWithBlankFieldsOrInvalidUsernameOrBlankUsername,
                loginPage.errorMessagePrinted());
    }

    @Test
    public void unsuccessfulLoginInvalidPassword() {
        loginPage.usernameInputFieldSendKeys(validUsername);
        loginPage.passwordInputFieldSendKeys(invalidPassword);
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        Assert.assertEquals(errorMessagewithBlankOrInvalidlPassword,
                loginPage.errorMessagePrinted());
    }

    @Test
    public void unsuccessfulLoginBlankPasswordField() {
        loginPage.usernameInputFieldSendKeys(validUsername);
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        Assert.assertEquals(errorMessagewithBlankOrInvalidlPassword,
                loginPage.errorMessagePrinted());
    }

    @Test
    public void unsuccessfulLoginBlankUserNameField() {
        loginPage.passwordInputFieldSendKeys(validPassword);
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        Assert.assertEquals(errorMessageWithBlankFieldsOrInvalidUsernameOrBlankUsername,
                loginPage.errorMessagePrinted());
    }

    @Test
    public void unsuccessfulLoginInvalidUserNameField() {
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        loginPage.usernameInputFieldSendKeys(invalidUsername);
        loginPage.passwordInputFieldSendKeys(validPassword);
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        Assert.assertEquals(errorMessageWithBlankFieldsOrInvalidUsernameOrBlankUsername,
                loginPage.errorMessagePrinted());
    }

    @Test
    public void navigateToSecurePageWithoutLogging() {
        loginPage.usernameInputFieldSendKeys(validUsername);
        loginPage.passwordInputFieldSendKeys(validPassword);
        loginPage.loginButtonClick();
        securePage.logoutButtonClick();
        loginPage.navigateToSecurePage(securePageUrl);
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        Assert.assertEquals(errorMessageForNavigatingOnSecurePageWithoutLogging,
                loginPage.errorMessagePrinted());
    }
}



