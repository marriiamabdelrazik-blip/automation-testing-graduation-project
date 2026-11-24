package com.orangehrm.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    private static final String PATH = "src/test/resources/testdata/testdata.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode getData() {
        try {
            return mapper.readTree(new File(PATH));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + PATH, e);
        }
    }
}