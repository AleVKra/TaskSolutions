package solutionTasks.documentReference;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryOfTechnologicalDocumentsTest {

    @Test
    void addingDocumentToAnExistingPart() {
        DirectoryOfTechnologicalDocuments docExpected =
                new DirectoryOfTechnologicalDocuments();
        docExpected.add("654684", "86468f");
        docExpected.add("654684", "95-35f");
        docExpected.add("654697-4", "8f984-g");
        docExpected.add("654686-4", "imiofl694");
        DirectoryOfTechnologicalDocuments result =
                new DirectoryOfTechnologicalDocuments();
        result.add("654684", "86468f");
        result.add("654684", "95-35f");
        result.add("654697-4", "8f984-g");
        result.add("654686-4", "imiofl694");


        System.out.println(docExpected.toString());
            assertEquals(docExpected,result);
    }

    @Test
    void getTechnologicalDocumentByDetail() {

    }

    @Test
    @DisplayName("выводит ли весь список одноименный метод")
    void getAllTechnologicalDocuments() {
// создание тестовых данных
        DirectoryOfTechnologicalDocuments exT1 =
                new DirectoryOfTechnologicalDocuments();
        DirectoryOfTechnologicalDocuments exT2 =
                new DirectoryOfTechnologicalDocuments();
        DirectoryOfTechnologicalDocuments exT3 =
                new DirectoryOfTechnologicalDocuments();

        HashMap<String, String> expected = new HashMap<>();
        exT1.add("123-35-9546", "2-35");
        exT2.add("95-35-9544", "2-155");
        exT3.add("354-35-94", "5-157");
//        expected.put(exT1);


        DirectoryOfTechnologicalDocuments t1 =
                new DirectoryOfTechnologicalDocuments();

        t1.add("123-35-9546", "2-35");
        t1.add("95-35-9544", "2-155");
        t1.add("354-35-94", "5-157");
//        t1.add("123-35-9546", "2-36");


        List<String> expectedKey = new ArrayList<>();
        for (String key : expected.keySet()) {
            expectedKey.add(key);
        }

        List<String> actualKey = new ArrayList<>();
        for (String key : t1.getAllTechnologicalDocuments().keySet()) {
            actualKey.add(key);
        }
        assertEquals(expectedKey, actualKey);
        /*Вывод:
         * Process finished with exit code 0
         * */
    }
}