package JavaAssignment_June07.EmployeeTaskTrackerSystem.Service;

import JavaAssignment_June07.EmployeeTaskTrackerSystem.model.*;
import JavaAssignment_June07.EmployeeTaskTrackerSystem.exception.*;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private Map<Employee, List<Task>> taskMap = new HashMap<>();


    public void addEmployee(Employee e) {
        taskMap.putIfAbsent(e, new ArrayList<>());
    }

    public Employee getEmployeeById(int id) {
        return taskMap.keySet().stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElse(null);
    }

    public void assignTask(Employee emp, Task task) {
        taskMap.computeIfAbsent(emp, k -> new ArrayList<>()).add(task);
    }

    public void updateTaskStatus(Employee emp, int taskId, String newStatus) throws TaskNotFoundException {
        List<Task> tasks = taskMap.get(emp);
        if (tasks != null) {
            for (Task t : tasks) {
                if (t.getId() == taskId) {
                    t.setStatus(newStatus);
                    return;
                }
            }
        }
        throw new TaskNotFoundException("Task ID " + taskId + " not found for employee: " + emp);
    }

    public List<Task> getTasks(Employee emp) {
        return taskMap.getOrDefault(emp, new ArrayList<>());
    }

    public List<Task> searchTasksByKeyword(String keyword) {
        return taskMap.values().stream()
                .flatMap(List::stream)
                .filter(t -> t.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }


    public void sortTasksByPriority() {
        taskMap.forEach((emp, tasks) -> {
            tasks.sort(Comparator.naturalOrder());
            tasks.forEach(System.out::println);
        });
    }

    public void sortTasksByDueDate() {
        taskMap.forEach((emp, tasks) -> {
            tasks.sort(Comparator.comparing(Task::getDueDate));
            tasks.forEach(System.out::println);
        });
    }

    public List<Task> getTasksDueTomorrow() {
        return taskMap.values().stream()
                .flatMap(List::stream)
                .filter(t -> t.getDueDate().equals(java.time.LocalDate.now().plusDays(1)))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWithMoreThanThreePendingTasks() {
        return taskMap.entrySet().stream()
                .filter(e -> e.getValue().stream().filter(t -> t.getStatus().equals("Pending")).count() > 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Task> getAllOverdueTasks() {
        return taskMap.values().stream()
                .flatMap(List::stream)
                .filter(t -> t.getDueDate().isBefore(java.time.LocalDate.now()) && !t.getStatus().equals("Completed"))
                .collect(Collectors.toList());
    }
}
