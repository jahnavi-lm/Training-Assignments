package WeekendAssignment_31May_01June.Car;

public class CarData {
    private String manufacturer;
    private String model;
    private String transmission;
    private String fuelType;
    private String color;
    private String location;

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setfuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void carSelections(){
        System.out.println("\nYour Car Build Summary:");
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Model: " + model);
        System.out.println("Transmission: " + transmission);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Accessories:");
        System.out.println("Color: " + color);
        System.out.println("Location: " + location);
    }
}
