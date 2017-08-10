package com.example.day1test.DTO;

import com.example.day1test.Domains.Employee;
import com.example.day1test.Domains.Project;

import java.util.Date;
import java.util.Set;

/**
 * Created by xplode on 10/8/17.
 */
public class TaskDTO {
    private String startDate;
    private String dueDate;
    private String taskDescription;
    private Project project;
    private Set<Employee> employee;

    public TaskDTO() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
