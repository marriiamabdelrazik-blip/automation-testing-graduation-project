package com.orangehrm.tests;

import com.orangehrm.base.DriverManager;
import com.orangehrm.pages.SidebarComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class UiTests extends BaseTest {

    @Test(description = "TC10: Verify the OrangeHRM footer/branding link")
    public void verifyFooterLink() {
        loginAsAdmin();

        SidebarComponent sidebar = new SidebarComponent();
        Assert.assertTrue(sidebar.getFooterText().contains("OrangeHRM, Inc"),
                "Footer should contain 'OrangeHRM, Inc'");

        sidebar.clickFooterLink();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("orangehrm.com"),
                "New tab URL should contain orangehrm.com");
    }

    @Test(description = "TC11: Verify sidebar menu items")
    public void verifySidebarMenu() {
        loginAsAdmin();

        SidebarComponent sidebar = new SidebarComponent();
        List<String> actual = sidebar.getMenuItems();
        List<String> expected = Arrays.asList(
                "Admin", "PIM", "Leave", "Time", "Recruitment",
                "My Info", "Performance", "Dashboard", "Directory");

        Assert.assertTrue(actual.containsAll(expected),
                "Sidebar should contain " + expected + " but found " + actual);
    }
}