package MultiThreadingMay03.MultiThreading_Assignment_June03;

public class OddThread extends Thread {
    private final OddEvenPrinter printer;

    public OddThread(OddEvenPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printOdd();
    }
}

