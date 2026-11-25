package com.orangehrm.tests;

import com.orangehrm.pages.AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTests extends BaseTest {

    @Test(description = "TC9: Verify Admin > Add User page fields")
    public void verifyAddUserForm() {
        loginAsAdmin();

        AdminPage admin = new AdminPage();
        admin.openUsers().clickAdd();

        Assert.assertTrue(admin.areAddUserFieldsDisplayed(),
                "Add User form should contain User Role, Employee Name, Username and Password fields");
    }
}