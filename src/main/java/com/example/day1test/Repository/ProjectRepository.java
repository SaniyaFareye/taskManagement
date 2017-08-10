package com.example.day1test.Repository;

import com.example.day1test.Domains.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xplode on 9/8/17.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Query("select j.projectId from Project j ")
    List<Long> getId();
}
