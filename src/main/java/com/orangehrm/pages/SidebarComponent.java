package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SidebarComponent extends BasePage {

    private final By menuItems = By.cssSelector(".oxd-main-menu-item .oxd-main-menu-item--name");
    private final By footerText = By.xpath("//div[contains(@class,'oxd-layout-footer')]//p[contains(.,'OrangeHRM, Inc')]");
    private final By footerLink = By.xpath("//div[contains(@class,'oxd-layout-footer')]//a[contains(@href,'orangehrm.com')]");

    @Step("Get sidebar menu items")
    public List<String> getMenuItems() {
        waitForVisible(menuItems);
        return findAll(menuItems).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Scroll to footer and get text")
    public String getFooterText() {
        return getText(footerText);
    }

    @Step("Click 'OrangeHRM, Inc' link")
    public void clickFooterLink() {
        click(footerLink);
        switchToNewTab();
    }
}