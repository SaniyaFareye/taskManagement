package com.example.day1test.Repository;

import com.example.day1test.Domains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xplode on 9/8/17.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query("select j from Employee j where j.project.projectId=:id")
    List<Employee> findById(@Param("id")Long id);


}
