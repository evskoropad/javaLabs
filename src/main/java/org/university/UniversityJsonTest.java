package org.university;

import org.university.controller.*;
import org.university.model.*;
import java.io.IOException;

public class UniversityJsonTest {
    public void testUniversityJsonSerialization(University oldUniversity) throws IOException {
        // Test JSON serialization of the passed university
        JsonManager jsonManager = new JsonManager();
        String filePath = "./test_university.json";

        jsonManager.writeUniversityToJson(oldUniversity, filePath);
        University newUniversity = jsonManager.readUniversityFromJson(filePath);

        // Compare
        if (!oldUniversity.equals(newUniversity)) {
            throw new AssertionError("Universities are not equal");
        }
    }
}