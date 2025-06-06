package MultiThreadingMay03.MultiThreading_Assignment_June03;

public class Person extends Thread {
    private final String name;
    private final String fromCity;
    private final Bridge bridge;

    public Person(String name, String fromCity, Bridge bridge) {
        this.name = name;
        this.fromCity = fromCity;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        try {
            bridge.crossBridge(name, fromCity);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
    }
}
