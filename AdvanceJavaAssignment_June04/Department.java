package AdvanceJavaJune05.AdvanceJavaAssignment_June04;

import java.util.List;

public class Department {
    private List<Employee> employees;

    public Department(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
