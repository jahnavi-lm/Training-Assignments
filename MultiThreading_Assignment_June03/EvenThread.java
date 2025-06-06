package MultiThreadingMay03.MultiThreading_Assignment_June03;

public class EvenThread extends Thread {
    private final OddEvenPrinter printer;

    public EvenThread(OddEvenPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printEven();
    }
}

