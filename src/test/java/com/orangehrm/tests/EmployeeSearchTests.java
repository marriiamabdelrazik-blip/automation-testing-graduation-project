package com.orangehrm.tests;

import com.orangehrm.dataproviders.TestDataProvider;
import com.orangehrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeSearchTests extends BaseTest {

    @Test(description = "TC4: Search for an existing employee",
            dataProvider = "existingEmployee",
            dataProviderClass = TestDataProvider.class)
    public void searchExistingEmployee(String name) {
        loginAsAdmin();

        PimPage pim = new PimPage();
        pim.openEmployeeList().searchEmployee(name);

        String results = pim.getResultsText();
        Assert.assertTrue(results.toLowerCase().contains(name.toLowerCase()),
                "Results should contain employee: " + name);
    }

    @Test(description = "TC5: Search for a non-existing employee",
            dataProvider = "nonExistingEmployee",
            dataProviderClass = TestDataProvider.class)
    public void searchNonExistingEmployee(String name) {
        loginAsAdmin();

        PimPage pim = new PimPage();
        pim.openEmployeeList().searchEmployee(name);

        Assert.assertTrue(pim.isNoRecordsFoundDisplayed(),
                "'No Records Found' message should be displayed");
    }
}