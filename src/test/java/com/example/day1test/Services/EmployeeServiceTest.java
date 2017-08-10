package com.example.day1test.Services;

import com.example.day1test.Domains.Employee;
import com.example.day1test.Domains.Project;
import com.example.day1test.Repository.EmployeeRepository;
import com.example.day1test.Repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by xplode on 10/8/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;


    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEmployeeList(){
        List<Employee> employeeList=new ArrayList<>();
        Employee employee=new Employee();
        employee.setEmployeeId(1L);
        employee.setUsername("il");
        employeeList.add(employee);

        when(employeeRepository.findById(1L)).thenReturn(employeeList);
        List<Employee> employeeList1=employeeService.getEmployeeList(1L);
        assertEquals(1,employeeList1.size());
    }
}