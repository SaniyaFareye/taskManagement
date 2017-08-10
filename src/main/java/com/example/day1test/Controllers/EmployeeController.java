package com.example.day1test.Controllers;

import com.example.day1test.Domains.Employee;
import com.example.day1test.Domains.Project;
import com.example.day1test.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xplode on 9/8/17.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employeeList",method = RequestMethod.POST)
    public ResponseEntity getProjectList(@Param("projectId") Long projectId){

        List<Employee> employees= employeeService.getEmployeeList(projectId);
        if(employees.isEmpty()){
            return new ResponseEntity("NO Data Found", HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity(employees,HttpStatus.OK);

    }
}
