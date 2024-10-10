package solutionTasks.documentReference;

import java.util.HashMap;
import java.util.HashSet;

public class MainDirectoryOfTechnologicalDocuments {

    public static void main(String[] args) {
        DirectoryOfTechnologicalDocuments documents=
                new DirectoryOfTechnologicalDocuments();

        documents.add("123-35-9546", "2-35");
        documents.add("95-35-9544", "2---155");
        documents.add("354-35-94", "5-157");
        documents.add("123-35-9546", "2-36");


        System.out.println("Все номера деталей и документов: ");
        documents.getAllTechnologicalDocuments();
    }
}
