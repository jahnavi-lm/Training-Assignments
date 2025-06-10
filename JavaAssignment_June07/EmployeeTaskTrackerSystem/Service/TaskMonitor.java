package JavaAssignment_June07.EmployeeTaskTrackerSystem.Service;

import JavaAssignment_June07.EmployeeTaskTrackerSystem.model.Task;

import java.time.LocalDate;
import java.util.List;

public class TaskMonitor extends Thread {

    private final TaskManager manager;
    public TaskMonitor(TaskManager manager) {
        this.manager = manager;
    }
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("\n[TaskMonitor] Checking for overdue tasks...");
                List<Task> overdueTasks = manager.getAllOverdueTasks();

                if (overdueTasks.isEmpty()) {
                    System.out.println("[TaskMonitor] No overdue tasks.");
                } else {
                    System.out.println("[TaskMonitor] Overdue Tasks:");
                    overdueTasks.forEach(System.out::println);
                }
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                System.out.println("[TaskMonitor] Monitor interrupted. Stopping...");
                break;
            }
        }
    }
}
