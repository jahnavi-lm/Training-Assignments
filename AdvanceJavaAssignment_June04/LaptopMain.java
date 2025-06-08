package AdvanceJavaJune05.AdvanceJavaAssignment_June04;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LaptopMain {
    public static void main(String[] args) {
        List<Laptop> laptops = Arrays.asList(
                new Laptop("Dell XPS", "Intel i7", 16, 4, 512, LocalDate.of(2023, 3, 10)),
                new Laptop("HP Envy", "Intel i5", 8, 2, 256, LocalDate.of(2022, 5, 20)),
                new Laptop("Lenovo ", "Lenovo 7", 16, 6, 1024, LocalDate.of(2023, 1, 15)),
                new Laptop("Asus ", "Intel i7", 32, 8, 2048, LocalDate.of(2024, 2, 5)),
                new Laptop("Acer ", "AMD  5", 8, 2, 512, LocalDate.of(2021, 8, 18))
        );

        int minRam = 8;
        int minGpu = 4;

        List<Laptop> filtered = laptops.stream()
                .filter(l -> l.getRam() >= minRam && l.getGraphicsCard() >= minGpu)
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);

        System.out.println();

        Map<String, List<Laptop>> groupedByProcessor = filtered.stream()
                .collect(Collectors.groupingBy(Laptop::getProcessor));

        groupedByProcessor.forEach((processor, list) -> {
            System.out.println("Processor: " + processor);
            list.forEach(System.out::println);
        });

        System.out.println();

        Map<String, List<Laptop>> sortedGroups = new HashMap<>();

        for (Map.Entry<String, List<Laptop>> entry : groupedByProcessor.entrySet()) {
            List<Laptop> sortedList = entry.getValue().stream()
                    .sorted(Comparator.comparingInt(Laptop::getRam).reversed()
                            .thenComparingInt(Laptop::getHardDisk).reversed()
                            .thenComparing(Laptop::getManufactureDate).reversed())
                    .collect(Collectors.toList());

            sortedGroups.put(entry.getKey(), sortedList);
        }

        sortedGroups.forEach((processor, list) -> {
            System.out.println("\nProcessor: " + processor);
            list.forEach(System.out::println);
        });
    }
}

