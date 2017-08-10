package com.example.day1test.Domains;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xplode on 9/8/17.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long employeeId;

    @Column(name="username" ,unique = true)
    private String username;

    @ManyToOne
    @JoinColumn(name="projectId",insertable=true,updatable=true,nullable = false)
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
