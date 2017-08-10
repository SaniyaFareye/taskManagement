package com.example.day1test.Repository;

import com.example.day1test.Domains.Employee;
import com.example.day1test.Domains.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xplode on 10/8/17.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("select j from Task j where j.project.projectId=:id")
   List<Task> findById(@Param("id")Long id);

    @Query("select j from Task j where j.project.projectId IN (:id)")
    List<Task> findByAllId(@Param("id")List<Long> id);


}
