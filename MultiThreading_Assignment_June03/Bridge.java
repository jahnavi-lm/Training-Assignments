package MultiThreadingMay03.MultiThreading_Assignment_June03;

public class Bridge {
    private String tokenLocation = "CityB";
    private boolean bridgeBusy = false;
    public synchronized void crossBridge(String name, String fromCity) throws InterruptedException {
        while (bridgeBusy || !tokenLocation.equals(fromCity)) {
            wait();
        }
        bridgeBusy = true;
        System.out.println(name + " from " + fromCity + " is crossing the bridge...");
        Thread.sleep(1000);
        String toCity = fromCity.equals("CityA") ? "CityB" : "CityA";
        System.out.println(name + " has crossed to " + toCity);
        tokenLocation = toCity;
        bridgeBusy = false;
        notifyAll();
    }
}
