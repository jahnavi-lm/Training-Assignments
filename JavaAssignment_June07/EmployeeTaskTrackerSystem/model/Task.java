package JavaAssignment_June07.EmployeeTaskTrackerSystem.model;

import java.time.LocalDate;

public class Task implements Comparable<Task> {
    private int id;
    private String description;
    private String status;
    private LocalDate dueDate;
    private int priority;

    public Task(int id, String description, String status, LocalDate dueDate, int priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", desc='" + description + "', status='" + status +
                "', due=" + dueDate + ", priority=" + priority + "}";
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.priority, o.priority);
    }
}

