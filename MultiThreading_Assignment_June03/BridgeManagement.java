package MultiThreadingMay03.MultiThreading_Assignment_June03;

public class BridgeManagement {
    public static void main(String[] args) throws InterruptedException {
        Bridge bridge = new Bridge();

        Person b1 = new Person("PersonB1", "CityB", bridge);
        Person b2 = new Person("PersonB2", "CityB", bridge);
        Person b3 = new Person("PersonB3", "CityB", bridge);

        Person a1 = new Person("PersonA1", "CityA", bridge);
        Person a2 = new Person("PersonA2", "CityA", bridge);
        Person a3 = new Person("PersonA3", "CityA", bridge);

        b1.start();
        b2.start();
        b3.start();
        a1.start();
        a2.start();
        a3.start();

        b1.join();
        b2.join();
        b3.join();
        a1.join();
        a2.join();
        a3.join();

        System.out.println("All persons have crossed the bridge.");
    }
}
