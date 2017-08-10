package com.example.day1test.Services;

import com.example.day1test.Domains.Project;
import com.example.day1test.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xplode on 9/8/17.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /*
     Returning  Project Lists
     */
    public List<Project> getProjectList(){
           List<Project> projectList=projectRepository.findAll();
           return projectList;
    }
}
