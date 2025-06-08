package AdvanceJavaJune05.AdvanceJavaAssignment_June04;

import java.time.LocalDate;

public class Laptop {
    private String model;
    private String processor;
    private int ram;
    private int graphicsCard;
    private int hardDisk;
    private LocalDate manufactureDate;

    public Laptop(String model, String processor, int ram, int graphicsCard, int hardDisk, LocalDate manufactureDate) {
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.graphicsCard = graphicsCard;
        this.hardDisk = hardDisk;
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public int getGraphicsCard() {
        return graphicsCard;
    }

    public int getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return  model + " | " + processor + " | " + ram + " | " + graphicsCard + " | " + hardDisk + " | " + manufactureDate ;
    }
}
