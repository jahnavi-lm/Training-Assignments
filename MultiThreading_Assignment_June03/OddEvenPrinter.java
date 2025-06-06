package MultiThreadingMay03.MultiThreading_Assignment_June03;

public class OddEvenPrinter {
    private int number = 1;
    private final int max;
    private final Object lock = new Object();

    public OddEvenPrinter(int max) {
        this.max = max;
    }

    public void printOdd() {
        while (number <= max) {
            synchronized (lock) {
                if (number % 2 == 1) {
                    System.out.println(number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void printEven() {
        while (number <= max) {
            synchronized (lock) {
                if (number % 2 == 0) {
                    System.out.println(number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}

