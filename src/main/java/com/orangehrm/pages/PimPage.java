package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

public class PimPage extends BasePage {

    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By employeeNameInput =
            By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By searchButton = By.cssSelector("button[type='submit']");
    private final By resultRows = By.cssSelector(".oxd-table-body .oxd-table-card");
    private final By noRecordsMessage = By.xpath("//*[text()='No Records Found']");
    private final By loadingSpinner = By.cssSelector(".oxd-loading-spinner");

    @Step("Open PIM > Employee List")
    public PimPage openEmployeeList() {
        click(pimMenu);
        waitForUrlContains("/pim/viewEmployeeList");
        return this;
    }

    @Step("Search for employee: {0}")
    public PimPage searchEmployee(String name) {
        type(employeeNameInput, name);
        click(searchButton);
        waitForInvisible(loadingSpinner);
        return this;
    }

    @Step("Get search results text")
    public String getResultsText() {
        waitForVisible(resultRows);
        return findAll(resultRows).stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(" "));
    }

    @Step("Check 'No Records Found' message")
    public boolean isNoRecordsFoundDisplayed() {
        return isDisplayed(noRecordsMessage);
    }
}