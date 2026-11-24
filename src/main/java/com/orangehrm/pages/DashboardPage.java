package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private final By dashboardHeader = By.cssSelector(".oxd-topbar-header-breadcrumb h6");

    @Step("Get dashboard header text")
    public String getHeaderText() {
        return getText(dashboardHeader);
    }

    @Step("Check dashboard header is displayed")
    public boolean isHeaderDisplayed() {
        return isDisplayed(dashboardHeader);
    }
}