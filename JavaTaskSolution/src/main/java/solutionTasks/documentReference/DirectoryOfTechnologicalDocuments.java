package solutionTasks.documentReference;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Написать простой класс Справочник технологических документов,
 * который хранит в себе список № деталей (9535649-05Т и т.п.) и
 * № технологических документов, которые являются уникальными.
 * В созданный справочник при помощи метода add() можно добавлять записи, а с помощью
 * метода getTechnologicalDocumentByDetail() искать номер технологического докмумента
 * по детали.
 * Реализовать метод getAllTechnologicalDocuments(),
 * который выводит все детали и номера технологических документов.
 *
 *
 */

@Getter
@Setter
public class DirectoryOfTechnologicalDocuments {

     HashMap<String, HashSet<String>> mapdirectoryDocument;

    // конструктор для вызова при создании экземпляра класса
    public DirectoryOfTechnologicalDocuments() {

        mapdirectoryDocument = new HashMap<>();
    }

    /**
     * добавить данные в справочник
     */
    public void add(String numberDetail, String numberTechDocument) {
// если справочник не сдержит указанного номера детали
        if (!mapdirectoryDocument.containsKey(numberDetail)) {
// то справочник добавит номер детали и новый список документов к этой детали
            mapdirectoryDocument.put(numberDetail, new HashSet<>());
        }
// иначе справочник получит номер детали и добавит к существующему списку номер документа
        mapdirectoryDocument.get(numberDetail).add(numberTechDocument);
    }

    /**
     * получить список номеров технологических документов справочника по номеру детали
     */
//  в параметре задали номер детали
    public HashSet<String> getTechnologicalDocumentByDetail(String numberDetail) {
//  возвратили при помощи метода get
        return mapdirectoryDocument.get(numberDetail);
    }

    /**
     * получить все данные списка: все детали и номера технологических документов
     */
//    создали метод getAllTechnologicalDocuments()
    public  HashMap<String, HashSet<String>> getAllTechnologicalDocuments() {
        for (String key : mapdirectoryDocument.keySet()) {
// вывод в консоль всех данных сформировавшегося документа
//            System.out.println("№ детали: " + key + " № документа: " + mapdirectoryDocument.get(key));
        }
        return mapdirectoryDocument;
    }
}

