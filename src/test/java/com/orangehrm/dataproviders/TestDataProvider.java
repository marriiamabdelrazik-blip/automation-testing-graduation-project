package com.orangehrm.dataproviders;

import com.fasterxml.jackson.databind.JsonNode;
import com.orangehrm.utils.JsonReader;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        JsonNode node = JsonReader.getData().get("validLogin");
        return new Object[][]{
                {node.get("username").asText(), node.get("password").asText()}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        JsonNode array = JsonReader.getData().get("invalidLogins");
        List<Object[]> data = new ArrayList<>();
        for (JsonNode item : array) {
            data.add(new Object[]{
                    item.get("username").asText(),
                    item.get("password").asText()
            });
        }
        return data.toArray(new Object[0][]);
    }

    @DataProvider(name = "existingEmployee")
    public static Object[][] existingEmployee() {
        String name = JsonReader.getData().get("searchEmployee").get("existing").asText();
        return new Object[][]{{name}};
    }

    @DataProvider(name = "nonExistingEmployee")
    public static Object[][] nonExistingEmployee() {
        String name = JsonReader.getData().get("searchEmployee").get("nonExisting").asText().trim();
        return new Object[][]{{name}};
    }

    @DataProvider(name = "newEmployee")
    public static Object[][] newEmployee() {
        JsonNode node = JsonReader.getData().get("newEmployee");
        return new Object[][]{
                {node.get("firstName").asText(), node.get("lastName").asText()}
        };
    }

    @DataProvider(name = "addEmployeeNegative")
    public static Object[][] addEmployeeNegative() {
        JsonNode array = JsonReader.getData().get("addEmployeeNegative");
        List<Object[]> data = new ArrayList<>();
        for (JsonNode item : array) {
            data.add(new Object[]{
                    item.get("firstName").asText(),
                    item.get("lastName").asText()
            });
        }
        return data.toArray(new Object[0][]);
    }
}