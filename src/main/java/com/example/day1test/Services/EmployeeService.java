package com.example.day1test.Services;

import com.example.day1test.Domains.Employee;
import com.example.day1test.Domains.Project;
import com.example.day1test.Repository.EmployeeRepository;
import com.example.day1test.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xplode on 9/8/17.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /*
     Returning  Employee Lists
     */
    public List<Employee> getEmployeeList(Long id){
        List<Employee> employeeList=employeeRepository.findById(id);
        return employeeList;
    }
}
