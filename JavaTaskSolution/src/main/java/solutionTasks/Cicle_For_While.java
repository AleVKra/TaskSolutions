package solutionTasks;

/*
* 1. Вывести на экран слово ​“JAVA”,​ в строку, чтобы оно повторилось 10 раз, используя цикл ​while​.
Вывод в консоль должен быть таким:
JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA
2. Повторить задание 1, но используя цикл ​for.​ 3. Вывести на экран слово ​“JAVA”,​ в столбик, чтобы оно повторилось 10 раз, используя цикл на ваше усмотрение (​for​ или ​while​).
Вывод в консоль должен быть таким:
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA


*/
public class Cicle_For_While {
    /**
     * 1. Вывести на экран слово ​“JAVA”,​ в строку, чтобы оно повторилось 10 раз,
     * используя цикл ​while​. Вывод в консоль должен быть таким:
     * JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA
     */
    public static void main(String[] args) {
//        String str = "JAVA";
//        int count = 0;
//        while (count < 10) {
//            count++;
//            System.out.print(str + " ");
//        }
////        System.out.println(------------------);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.print(str + " ");
//        }
        /**
         * 4. Объявите переменную типа ​int,​ имя переменной - ​year.​ Присвойте этой переменной значение 1980.
         * Используя цикл ​while​, выведите в столбик строки вида “Олимпиада X года”, где X - это число, которое
         * принимает значения, начиная от 1980 до 2020 с шагом увеличения равным 4.
         * То есть на первой итерации цикла, X равен 1980, а на каждой следующей итерации,
         *  значение X увеличивается на 4. Строки такого вида выводятся до тех пор, пока значение X не станет
         *  больше 2020.
         * Пример:
         * year = 1980​, вывод должен быть таким:
         * Олимпиада 1980 года Олимпиада 1984 года Олимпиада 1988 года Олимпиада 1992 года ……
         * Олимпиада 2016 года Олимпиада 2020 года*/

//        int year = 1980;
//        int x = 4;
//        while (year <= 2020) {
//            System.out.print("Олимпиада " + year + " года_");
//            year = year + x;
//        }

        /**
         * 5. Повторить задание 4, но используя цикл ​for​. */
//        int year = 1980;
//        int x = 4;
//        for (int i = 0; i <= 10; i++) {
//            System.out.print("Олимпиада " + year + " года_");
//            year = year + x;
//        }
        /**
         * 6. Объявите переменную типа ​int,​ имя переменной - ​k.
         * ​ Присвойте этой переменной какую-нибудь цифру от 1 до 9.
         * Используя цикл на ваше усмотрение (​for​ или ​while​), выведите
         * в консоль таблицу умножения для этой цифры в следующем формате:
         * 1 x k = … 2 x k = … 3 x k = … ……
         * 9 x k = …
         * Пример:
         * k = 3
         * Вывод в консоль:
         * 1 x 3 = 3 2 x 3 = 6 3 x 3 = 9 ……
         * 9 x 3 = 27*/

        int k = 8;

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + k + " = " + i * k);
        }
    }
}

