package solutionTasks.arrayTasks;


/**
 * Переместите каждую букву в предоставленной строке на
 * 10 букв вперед по алфавиту.
 * Если она идет дальше "z", начните сначала с "a".
 * Вводимыми данными будут строки длиной > 0.
 * задачи массива
 * После выполнения здания метод проверить тестом на выполнение
 *
 * Test Results:
 * MoveTenTest
 * sampleTests()
 * Test Passed
 * Completed in 26ms
 * Completed in 39ms
 * You have passed all of the tests! :)
 *
 */

public class MoveTen {
//
//    public static void main(String[] args) {
//
//        System.out.println(moveTen("zafira"));
//    }

    public static String moveTen(String slovo) {
        String alphavitStr = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sbAlphavit = new StringBuilder(alphavitStr);

        StringBuilder sb = new StringBuilder(slovo);
        char temp = ' ';

        int startPoint;

        int period = 10;
        for (int i = 0; i < sb.length(); i++)
            for (int j = 0; j < sbAlphavit.length(); j++) {
//       условие совпадения символов
                if (sb.charAt(i) == sbAlphavit.charAt(j)) {
//      разница от старта до конца массива
                    startPoint = sbAlphavit.length() - j;
//      условие, если сумма заданного изменения вылетает за пределы массива, то обнулит счётчик
                    if ((j + period) > sbAlphavit.length()) {
                        temp = sbAlphavit.charAt(0 + (period - startPoint));
//                       sb.setCharAt(i,);
                        sb.replace(i + 0, i + 1, String.valueOf(temp));
                        j = -1; // zkx
                        i++;
                    } else {
                        temp = sbAlphavit.charAt(j + period);
//                        sb.setCharAt(i,sbAlphavit.charAt(temp));
                        sb.replace(i + 0, i + 1, String.valueOf(temp));
//             заглушка для нулевого расчёта цикла с алфавитом
                        j = -1;
                        i++;
                    }
                    if (i == sb.length()) {
                        break;
                    }
                }
            }
        return sb.toString();
    }
}
