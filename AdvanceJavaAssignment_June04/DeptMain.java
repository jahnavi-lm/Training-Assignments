package AdvanceJavaJune05.AdvanceJavaAssignment_June04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeptMain {
    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department(List.of(new Employee("Jahnavi"), new Employee("Lakshmi"))),
                new Department(List.of(new Employee("Raj"), new Employee("Adi"))),
                new Department(List.of(new Employee("Sindhu"), new Employee("Hridya"), new Employee("Ramu")))
        );

        // 1. Combine all employees into a single list
        List<Employee> allEmployees = departments.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .toList();

        // 2. Filter employees whose names start with a specific letter
        char startingLetter = 'R';
        List<Employee> filteredEmployees = allEmployees.stream()
                .filter(emp -> emp.getName().startsWith(String.valueOf(startingLetter)))
                .toList();

        // 3. Sort filtered names alphabetically
        List<String> sortedNames = filteredEmployees.stream()
                .map(Employee::getName)
                .sorted()
                .toList();

        // 4. Group all employee names by their starting letter (using HashMap)
        Map<Character, List<String>> groupedByFirstLetter = allEmployees.stream()
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        // 5. Create 5 sports teams with random employees
        List<Employee> shuffled = new ArrayList<>(allEmployees);
        Collections.shuffle(shuffled);
        int teamSize = (int) Math.ceil((double) shuffled.size() / 5);

        List<List<Employee>> teams = IntStream.range(0, 5)
                .mapToObj(i -> shuffled.stream()
                        .skip(i * teamSize)
                        .limit(teamSize)
                        .collect(Collectors.toList()))
                .filter(team -> !team.isEmpty())
                .toList();

        // 6. Merge 5 teams into 3 divisions
        List<List<Employee>> divisions = IntStream.range(0, 3)
                .mapToObj(i -> new ArrayList<Employee>())
                .collect(Collectors.toList());

        IntStream.range(0, teams.size()).forEach(i ->
                divisions.get(i % 3).addAll(teams.get(i))
        );

        // Output results
        System.out.println("All Employees: " + allEmployees.stream().map(Employee::getName).toList());
        System.out.println("Filtered (starts with '" + startingLetter + "'): " + filteredEmployees.stream().map(Employee::getName).toList());
        System.out.println("Sorted Names: " + sortedNames);
        System.out.println("Grouped by First Letter: " + groupedByFirstLetter);

        System.out.println("\nTeams:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Team " + (i + 1) + ": " + teams.get(i).stream().map(Employee::getName).toList());
        }

        System.out.println("\nDivisions:");
        for (int i = 0; i < divisions.size(); i++) {
            System.out.println("Division " + (i + 1) + ": " + divisions.get(i).stream().map(Employee::getName).toList());
        }
    }
}
