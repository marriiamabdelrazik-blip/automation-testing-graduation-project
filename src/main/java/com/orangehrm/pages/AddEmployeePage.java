package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddEmployeePage extends BasePage {

    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private final By firstNameField = By.name("firstName");
    private final By lastNameField = By.name("lastName");
    private final By saveButton = By.cssSelector("button[type='submit']");
    private final By firstNameError = By.xpath(
            "//input[@name='firstName']/ancestor::div[contains(@class,'oxd-input-group')]"
                    + "//span[contains(@class,'oxd-input-field-error-message')]");

    @Step("Open PIM > Add Employee")
    public AddEmployeePage openAddEmployee() {
        click(pimMenu);
        click(addEmployeeTab);
        waitForUrlContains("/pim/addEmployee");
        return this;
    }

    @Step("Check First Name field is displayed")
    public boolean isFirstNameDisplayed() {
        return isDisplayed(firstNameField);
    }

    @Step("Check Last Name field is displayed")
    public boolean isLastNameDisplayed() {
        return isDisplayed(lastNameField);
    }

    @Step("Enter first name: {0}")
    public AddEmployeePage enterFirstName(String firstName) {
        if (!firstName.isEmpty()) {
            type(firstNameField, firstName);
        }
        return this;
    }

    @Step("Enter last name: {0}")
    public AddEmployeePage enterLastName(String lastName) {
        type(lastNameField, lastName);
        return this;
    }

    @Step("Click Save")
    public void clickSave() {
        click(saveButton);
    }

    @Step("Get First Name validation error")
    public String getFirstNameError() {
        return getText(firstNameError);
    }
}