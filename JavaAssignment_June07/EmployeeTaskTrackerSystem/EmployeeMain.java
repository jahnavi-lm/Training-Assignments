package JavaAssignment_June07.EmployeeTaskTrackerSystem;
import JavaAssignment_June07.EmployeeTaskTrackerSystem.Service.TaskManager;
import JavaAssignment_June07.EmployeeTaskTrackerSystem.Service.TaskMonitor;
import JavaAssignment_June07.EmployeeTaskTrackerSystem.exception.TaskNotFoundException;
import JavaAssignment_June07.EmployeeTaskTrackerSystem.model.Employee;
import JavaAssignment_June07.EmployeeTaskTrackerSystem.model.Task;

import java.time.LocalDate;
import java.util.*;

public class EmployeeMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();
    private static final TaskMonitor monitor = new TaskMonitor(taskManager);

    public static void main(String[] args) {
        initializeSampleData();
        monitor.start(); // Start background thread

        System.out.println("Welcome to Employee Task Tracker System");
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Assign Task to Employee");
            System.out.println("3. View Tasks of an Employee");
            System.out.println("4. Search Tasks by Keyword");
            System.out.println("5. Sort Tasks by Priority/Due Date");
            System.out.println("6. View Tasks Due Tomorrow");
            System.out.println("7. Employees with >3 Pending Tasks");
            System.out.println("9. Update Task Status");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> assignTask();
                case 3 -> viewTasks();
                case 4 -> searchTasks();
                case 5 -> sortTasks();
                case 6 -> tasksDueTomorrow();
                case 7 -> employeesWithMorePending();
                case 9 -> updateTaskStatus();
                case 10 -> {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeSampleData() {
        Employee emp1 = new Employee(101, "Adi", "Engineering");
        Employee emp2 = new Employee(102, "Ramu", "QA");
        Employee emp3 = new Employee(103, "Raju", "HR");

        taskManager.addEmployee(emp1);
        taskManager.addEmployee(emp2);
        taskManager.addEmployee(emp3);
        Task task1 = new Task(1, "Design DB schema", "Pending", LocalDate.now().minusDays(2), 1);
        Task task2 = new Task(2, "Write project proposal", "In Progress", LocalDate.now().plusDays(1), 2);
        Task task3 = new Task(3, "Organize team meeting", "Completed", LocalDate.now().minusDays(1), 3);
        taskManager.assignTask(emp1, task1);
        taskManager.assignTask(emp2, task2);
        taskManager.assignTask(emp3, task3);
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String dept = scanner.nextLine();
        taskManager.addEmployee(new Employee(id, name, dept));
        System.out.println("Employee added.");
    }

    private static void assignTask() {
        System.out.print("Enter employee ID: ");
        int empId = scanner.nextInt(); scanner.nextLine();
        Employee emp = taskManager.getEmployeeById(empId);
        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter status: ");
        String status = scanner.nextLine();
        System.out.print("Enter due date (yyyy-MM-dd): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter priority (1-High, 2-Med, 3-Low): ");
        int priority = scanner.nextInt(); scanner.nextLine();

        taskManager.assignTask(emp, new Task(taskId, desc, status, dueDate, priority));
        System.out.println("Task assigned.");
    }

    private static void viewTasks() {
        System.out.print("Enter employee ID: ");
        int empId = scanner.nextInt(); scanner.nextLine();
        Employee emp = taskManager.getEmployeeById(empId);
        if (emp != null) {
            List<Task> tasks = taskManager.getTasks(emp);
            tasks.forEach(System.out::println);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void searchTasks() {
        System.out.print("Enter keyword: ");
        List<Task> key = taskManager.searchTasksByKeyword(scanner.nextLine());
        System.out.println(key.toString());
    }


    private static void sortTasks() {
        System.out.print("1. Priority 2. Due Date: ");
        int c = scanner.nextInt(); scanner.nextLine();
        if (c == 1) taskManager.sortTasksByPriority();
        else if (c == 2) taskManager.sortTasksByDueDate();
    }

    private static void updateTaskStatus() {
        try {
            System.out.print("Enter employee ID: ");
            int empId = scanner.nextInt(); scanner.nextLine();
            Employee emp = taskManager.getEmployeeById(empId);
            if (emp == null) {
                System.out.println("Employee not found!");
                return;
            }
            System.out.print("Enter task ID: ");
            int taskId = scanner.nextInt(); scanner.nextLine();
            System.out.print("Enter new status (Pending/In Progress/Completed): ");
            String newStatus = scanner.nextLine();
            taskManager.updateTaskStatus(emp, taskId, newStatus);
            System.out.println("Task status updated successfully.");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void tasksDueTomorrow() {
        List<Task> t = taskManager.getTasksDueTomorrow();
        System.out.println(t.toString());
    }

    private static void employeesWithMorePending() {
        List<Employee> emp = taskManager.getEmployeesWithMoreThanThreePendingTasks();
        System.out.println(emp.toString());
    }
}
