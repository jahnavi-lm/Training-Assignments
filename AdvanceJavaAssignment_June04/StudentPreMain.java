package AdvanceJavaJune05.AdvanceJavaAssignment_June04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentPreMain {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Jahnavi", "Female"),
                new Student("Adi", "Male"),
                new Student("Sindhu", "Female"),
                new Student("Sai", "Male")
        );

        List<String> prefixedNames = students.stream()
                .map(student -> {
                    String prefix = student.getGender().equalsIgnoreCase("Male") ? "Mr. " : "Ms. ";
                    return prefix + student.getName();
                })
                .collect(Collectors.toList());

        prefixedNames.forEach(System.out::println);
    }
}
