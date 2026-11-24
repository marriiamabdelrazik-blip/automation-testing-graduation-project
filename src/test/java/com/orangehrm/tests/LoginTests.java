package com.orangehrm.tests;

import com.orangehrm.dataproviders.TestDataProvider;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "TC1: Login with valid credentials",
            dataProvider = "validLoginData",
            dataProviderClass = TestDataProvider.class)
    public void validLogin(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        DashboardPage dashboard = new DashboardPage();
        Assert.assertTrue(dashboard.getCurrentUrl().contains("/dashboard/index"),
                "URL should contain /dashboard/index");
        Assert.assertTrue(dashboard.isHeaderDisplayed(), "Dashboard header should be displayed");
        Assert.assertEquals(dashboard.getHeaderText(), "Dashboard");
    }

    @Test(description = "TC2: Login with invalid credentials",
            dataProvider = "invalidLoginData",
            dataProviderClass = TestDataProvider.class)
    public void invalidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }

    @Test(description = "TC3: Login with empty fields")
    public void emptyLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLogin();

        java.util.List<String> messages = loginPage.getRequiredMessages();
        Assert.assertEquals(messages.size(), 2, "Both fields should show a validation message");
        for (String msg : messages) {
            Assert.assertEquals(msg, "Required");
        }
    }
}