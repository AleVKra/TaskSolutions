package solutionTasks;
/*
 * Основная идея заключается в подсчете всех встречающихся символов в строке.
 * Если у вас есть строка типа aba, то результатом должно быть {'a': 2, 'b': 1}.
 * Что делать, если строка пуста? Тогда результатом должен быть пустой объектный литерал, {}.
 * */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountCharactersInYourString {

    public static void main(String[] args) {
        System.out.println(count("шёл Костя по шоссе и кусал он сушку"));
    }

    public static Map<Character, Integer> count(String str) {
        StringBuilder sb = new StringBuilder(str);
        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < sb.length(); i++) {

            map.put(sb.charAt(i), count);
        }
//   подсчёт количества букв и символов
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < sb.length(); i++) {
                if (entry.getKey().equals(sb.charAt(i))) {
                    count++;
                }
            }
//     изменение значения счётчика в мапе
            map.replace(entry.getKey(), count);
//     сброс счётчика
            count = 0;
        }

//   проход итератором и вывод значения
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry item = (Map.Entry) iterator.next();
            System.out.println("{'" + item.getKey() + " : " + "'" + "'" + item.getValue() + "'}");
        }
        return map;
    }

}
