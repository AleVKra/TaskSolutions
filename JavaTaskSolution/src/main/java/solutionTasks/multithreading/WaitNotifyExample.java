package solutionTasks.multithreading;


/**
 * Задача
 * Написать магазин в котором покупают хлеб.
 * При отсутствии хлеба производитель должен поставить хлеб
 * в магазин не более 5 булок. Покупатель по мере получения
 * хлеба в магазине, берёт одну булку.
 */

public class WaitNotifyExample {

    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

class Market {
    private int breadCount = 0;
    private final Object lock = new Object();   // ссоздадим блок synchronized вместо метода synchronized

    public synchronized void getBread() {
//    public void getBread() {
//        synchronized (lock) {
        while (breadCount < 1) {
            try {
//                    lock.wait();   // освобождает монитор
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 булку");
        System.out.println("Количества хлеба в магазине = " + breadCount);
        notify();
    }
//    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель" +
                " добавил на витрину 1 булку = " + breadCount);
        notify();
    }
}

class Producer implements Runnable {
    Market market;

    Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}
