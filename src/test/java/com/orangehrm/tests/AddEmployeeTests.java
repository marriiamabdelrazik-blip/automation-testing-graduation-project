package com.orangehrm.tests;

import com.orangehrm.dataproviders.TestDataProvider;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.PersonalDetailsPage;
import com.orangehrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTests extends BaseTest {

    @Test(description = "TC6: Open Add Employee page")
    public void openAddEmployeePage() {
        loginAsAdmin();

        AddEmployeePage addPage = new AddEmployeePage();
        addPage.openAddEmployee();

        Assert.assertTrue(addPage.getCurrentUrl().contains("/pim/addEmployee"),
                "URL should contain /pim/addEmployee");
        Assert.assertTrue(addPage.isFirstNameDisplayed(), "First Name field should be displayed");
        Assert.assertTrue(addPage.isLastNameDisplayed(), "Last Name field should be displayed");
    }

    @Test(description = "TC7: Add employee with empty First Name",
            dataProvider = "addEmployeeNegative",
            dataProviderClass = TestDataProvider.class)
    public void addEmployeeWithoutFirstName(String firstName, String lastName) {
        loginAsAdmin();

        AddEmployeePage addPage = new AddEmployeePage();
        addPage.openAddEmployee()
                .enterFirstName(firstName)
                .enterLastName(lastName);
        addPage.clickSave();

        Assert.assertEquals(addPage.getFirstNameError(), "Required");
    }

    @Test(description = "TC8: End-to-end - add a new employee successfully",
            dataProvider = "newEmployee",
            dataProviderClass = TestDataProvider.class)
    public void addNewEmployeeEndToEnd(String firstName, String lastName) {
        loginAsAdmin();

        AddEmployeePage addPage = new AddEmployeePage();
        addPage.openAddEmployee()
                .enterFirstName(firstName)
                .enterLastName(lastName);
        addPage.clickSave();

        PersonalDetailsPage details = new PersonalDetailsPage();
        Assert.assertTrue(details.isPersonalDetailsDisplayed(),
                "Personal Details page should open for the new employee");

        PimPage pim = new PimPage();
        pim.openEmployeeList().searchEmployee(firstName + " " + lastName);

        Assert.assertTrue(pim.getResultsText().contains(firstName),
                "New employee should appear in search results");
    }
}