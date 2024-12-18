package solutionTasks.multithreading;

import java.util.Arrays;

/**
 * 1. Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * static  final  int  SIZE =   10 000 000;
 * static  final  int  HALF =   size/2;
 * float[] arr = new  float[size].
 * 2) Заполняют этот массив единицами.
 * 3) Засекают время выполнения: long a = System.currentTimeMillis().
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float) (arr[i]*Math.sin(0.2f + i/5)*Math.cos(0.2f + i/5)*Math.cos(0.4f + i/2)).
 * 5) Проверяется время окончания метода System.currentTimeMillis().
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).
 * <p>
 * Отличие первого метода от второго:
 * ● Первый просто бежит по массиву и вычисляет значения.
 * ● Второй разбивает массив на два массива, в двух потоках
 * высчитывает новые значения и потом склеивает эти массивы обратно в один.
 * <p>
 * Пример деления одного массива на два:
 * ● System.arraycopy(arr, 0, a1, 0, h);
 * ● System.arraycopy(arr, h, a2, 0, h).
 * Пример обратной склейки:
 * ● System.arraycopy(a1, 0, arr, 0, h);
 * ● System.arraycopy(a2, 0, arr, h, h).
 * <p>
 * Примечание:
 * System.arraycopy() — копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из
 * массива-источника, массив-назначение, откуда начинаем записывать данные
 * в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * for  (int i=0; i <size; i++)  { arr[i] =( float) (arr[i] * Math.sin(0.2f + i/5)* Math.cos(0.2f + i/5 ) * Math.cos(0.4f + i/2)); }
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */


public class PractikTask_Multithread {


    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        createArrayOne(SIZE);
        createArrayTwo(SIZE);
    }
    /**
     * Output: time 1: 808  msTime 2: 649  ms
     * Вывод времени выполнения 2-х методов сколько бы раз мы их не запускали,
     * указывает на то, что время выполнения 1-го метода в отличии от 2-го будет
     * всегда больше. Причиной можно назвать разделение работы на 2 потока, которые
     * будут выполняться параллельно и делать обем работы меньший в отличии от потока,
     * который выполоняет main.
     * Таким образом при обработке большого количества данных, целесообразно применять
     * многопоточность, задействовав тем самым несколько ядер для пользования.
     * Для эксперимента было установлено значение в 1 млрд, вывод следующий:
     * Output:
     * time 1: 82384  msException in thread "main" java.lang.OutOfMemoryError: Java heap space
     * говорит о том, что память стека была заполнена и выбросилась ошибка  time 1: 82384  msException in thread "main" java.lang.OutOfMemoryError: Java heap space
     * */


    static void createArrayOne(int SIZE) {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        //  время выполнения которого нужно измерить
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime1);

        System.out.print("time 1: " + elapsedTime +"  ms");
    }

    static void createArrayTwo(int SIZE) {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        float[] array1 = new float[HALF];
        float[] array2 = new float[HALF];
        long startTimeTwo = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, 0, array1, 0, HALF);
                for (int i = 0; i < array1.length; i++) {
                    array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5)
                            * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(array1, 0, arr, 0, HALF);
            }
        });
        t1.start();
        try {
            t1.join(); // заставит подождать указанный поток t1,
            // после выполнения t1, поток join оттпускает
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, HALF, array2, 0, HALF);
                for (int i = 0; i < array2.length; i++) {
                    array2[i] = (float) (array2[i] * Math.sin(0.2f + i / 5)
                            * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(array2, 0, arr, HALF, HALF);
            }
        });
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTimeTwo = System.currentTimeMillis();
        long elapsedTimeTwo = (endTimeTwo - startTimeTwo);

        System.out.print("Time 2: " + elapsedTimeTwo+"  ms");
    }
}
