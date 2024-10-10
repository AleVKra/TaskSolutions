package solutionTasks.documentReference;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryOfTechnologicalDocumentsTest {

//    @Test
//    void add() {
//        DirectoryOfTechnologicalDocuments documents=
//                new DirectoryOfTechnologicalDocuments();
//
//    }

    @Test
    void getTechnologicalDocumentByDetail() {

    }

    @Test
    @DisplayName("выводит ли весь список одноименный метод")
    void getAllTechnologicalDocuments() {
// создание тестовых данных

        DirectoryOfTechnologicalDocuments documentsTest =
                new DirectoryOfTechnologicalDocuments();

        DirectoryOfTechnologicalDocuments t1 =
                new DirectoryOfTechnologicalDocuments();


        t1.add("123-35-9546", "2-35");
        t1.add("95-35-9544", "2-155");
        t1.add("354-35-94", "5-157");
        t1.add("123-35-9546", "2-36");

        HashMap<String, HashSet<String>> expected =
                documentsTest.getAllTechnologicalDocuments();
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
        * org.opentest4j.AssertionFailedError:
Expected :[]
Actual   :[123-35-9546, 95-35-9544, 354-35-94]*/
    }
}