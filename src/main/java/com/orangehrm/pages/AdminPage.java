package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AdminPage extends BasePage {

    private final By adminMenu = By.xpath("//span[text()='Admin']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");

    private final By userRoleLabel = By.xpath("//label[text()='User Role']");
    private final By employeeNameLabel = By.xpath("//label[text()='Employee Name']");
    private final By usernameLabel = By.xpath("//label[text()='Username']");
    private final By passwordLabel = By.xpath("//label[text()='Password']");

    @Step("Open Admin > User Management > Users")
    public AdminPage openUsers() {
        click(adminMenu);
        waitForUrlContains("/admin/viewSystemUsers");
        return this;
    }

    @Step("Click Add button")
    public AdminPage clickAdd() {
        click(addButton);
        waitForUrlContains("/admin/saveSystemUser");
        return this;
    }

    @Step("Check Add User form fields")
    public boolean areAddUserFieldsDisplayed() {
        return isDisplayed(userRoleLabel)
                && isDisplayed(employeeNameLabel)
                && isDisplayed(usernameLabel)
                && isDisplayed(passwordLabel);
    }
}