package com.example.day1test.Domains;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * Created by xplode on 9/8/17.
 */
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id",nullable = false)
    private Long taskId;

    @Column(name = "start_date" ,nullable = false)
    private Date startDate;

    @Column(name = "due_date",nullable = false)
    private Date dueDate;

    @Column(name="task_description",unique = true,nullable = false)
    private String taskDescription;

    public Task() {
    }

    @ManyToOne
    @JoinColumn(name="projectId",insertable=true,updatable=true,nullable = false)
    private Project project;

    @ManyToMany
    @JoinTable(name="task_employee", joinColumns=@JoinColumn(name = "task_id",referencedColumnName = "task_id"),inverseJoinColumns = @JoinColumn(name ="employee_id",referencedColumnName = "employee_id"))
    private Set<Employee> employee;

    public Long getTaskId() {
        return taskId;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
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

}
