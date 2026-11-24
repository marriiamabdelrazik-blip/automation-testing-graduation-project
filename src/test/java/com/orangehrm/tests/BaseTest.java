package com.orangehrm.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.orangehrm.base.DriverManager;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigReader.getBaseUrl() + "auth/login");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

    protected void loginAsAdmin() {
        JsonNode creds = JsonReader.getData().get("validLogin");
        new LoginPage().login(creds.get("username").asText(), creds.get("password").asText());
        Assert.assertTrue(new DashboardPage().isHeaderDisplayed(), "Login failed: dashboard not displayed");
    }
}