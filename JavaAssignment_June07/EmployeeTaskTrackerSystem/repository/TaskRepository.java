package JavaAssignment_June07.EmployeeTaskTrackerSystem.repository;

import java.util.*;

public class TaskRepository<T> {
    private List<T> taskList = new ArrayList<>();

    public void addTask(T task) {
        taskList.add(task);
    }

    public List<T> getAllTasks() {
        return taskList;
    }

    public boolean removeTask(T task) {
        return taskList.remove(task);
    }
}
