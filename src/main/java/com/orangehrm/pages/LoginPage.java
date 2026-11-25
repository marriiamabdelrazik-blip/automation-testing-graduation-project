package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends BasePage {

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorMessage = By.cssSelector(".oxd-alert-content-text");
    private final By requiredMessages = By.cssSelector(".oxd-input-field-error-message");

    @Step("Enter username: {0}")
    public LoginPage enterUsername(String username) {
        type(usernameField, username);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    @Step("Click Login button")
    public void clickLogin() {
        click(loginButton);
    }

    @Step("Login with username: {0}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Get login error message")
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Get 'Required' validation messages")
    public List<String> getRequiredMessages() {
        waitForVisible(requiredMessages);
        return findAll(requiredMessages).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}