package solutionTasks.arrayTasks;


import java.awt.font.FontRenderContext;
import java.util.Arrays;

/**
 * Переместите каждую букву в предоставленной строке на
 * 10 букв вперед по алфавиту.
 * Если она идет дальше "z", начните сначала с "a".
 * Вводимыми данными будут строки длиной > 0.
 * задачи массива
 */

public class MoveLetter {

    public static void main(String[] args) {

        String alphavitStr = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sbAlphavit = new StringBuilder(alphavitStr);

        String slovo = "brzyx"; //
        StringBuilder sb = new StringBuilder(slovo);
        char temp = ' ';

        int start = 0;
        int period = 10;
        for (int i = 0; i < sb.length(); i++){
            for (int j = 0; j < sbAlphavit.length(); j++) {
//       условие совпадения символов и то что он не 26-ой
                if (sb.charAt(i) == sbAlphavit.charAt(j)) {
                    start++;
//      создать условие, если сумма заданного изменения вылетает за пределы массива, то обнулить счётчик
                    if ((j + period) > sbAlphavit.length()) {
                        temp = sbAlphavit.charAt(j + (period - start));
                        sb.replace(i + 0, i + 1, String.valueOf(temp));
                        j = 0; // zkx
                        i++;
                        start=0;
                    } else {
                        temp = sbAlphavit.charAt(j + period);  // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: index 35,length 26
                        sb.replace(i + 0, i + 1, String.valueOf(temp));
                        j = 0; i++;
                        start=0;
                    }
                    if (i ==sb.length()) {
                        break;
                    }
//                    if (!sb.equals(sb.charAt(i))) {  // условие что sb не содержит элементов
//                        j++;
//                    }
                }
            }
        System.out.println(sb);}
    }
}
