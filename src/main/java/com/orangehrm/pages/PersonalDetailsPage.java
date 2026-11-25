package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PersonalDetailsPage extends BasePage {

    private final By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

    @Step("Wait for Personal Details page")
    public boolean isPersonalDetailsDisplayed() {
        waitForUrlContains("/pim/viewPersonalDetails");
        return isDisplayed(personalDetailsHeader);
    }
}