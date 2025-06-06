package MultiThreadingMay03.MultiThreading_Assignment_June03;

public class OddEvenMain {
    public static void main(String[] args) {
        int max = 10;
        OddEvenPrinter printer = new OddEvenPrinter(max);

        Thread oddThread = new OddThread(printer);
        Thread evenThread = new EvenThread(printer);

        oddThread.start();
        evenThread.start();
    }
}

